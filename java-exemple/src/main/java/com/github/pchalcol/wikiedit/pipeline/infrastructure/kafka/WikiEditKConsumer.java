package com.github.pchalcol.wikiedit.pipeline.infrastructure.kafka;

import com.github.cjmatta.kafka.connect.transform.wikiedit.WikiEdit;
import com.github.pchalcol.wikiedit.pipeline.domain.core.Processor;
import com.github.pchalcol.wikiedit.pipeline.domain.services.WikiEventService;
import com.github.pchalcol.wikiedit.pipeline.domain.model.WikiEditSourceEvent;
import com.github.pchalcol.wikiedit.pipeline.domain.model.repositories.WikiEditSource;
import io.confluent.kafka.serializers.KafkaAvroDeserializerConfig;
import org.apache.kafka.clients.consumer.*;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.errors.WakeupException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.*;

public class WikiEditKConsumer implements WikiEditSource {
    private static Logger logger = LoggerFactory.getLogger(WikiEditKConsumer.class);

    private final String groupId = "wpc-pipe";
    private final String clientId;
    private final Boolean fromBeginning;

    private KafkaConsumer<String, WikiEdit> consumer;

    private List<Processor> processors;

    /**
     *
     */
    // TODO pass topic as argument
    public WikiEditKConsumer(String clientId, Boolean fromBeginning) {

        this.clientId = clientId;
        this.fromBeginning = fromBeginning;

        Properties p = new Properties();

        p.setProperty(ConsumerConfig.GROUP_ID_CONFIG, groupId);
        p.setProperty(ConsumerConfig.CLIENT_ID_CONFIG, clientId);
        p.setProperty(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "false");
        p.setProperty(KafkaAvroDeserializerConfig.SPECIFIC_AVRO_READER_CONFIG, "true");

        Properties consumerProperties = new Props()
                .schemaRegistrySecurity()
                .brokerSecurity()
                .defaultConsumerProps()
                .customProps(p)
                .properties();

        consumer = new KafkaConsumer<>(consumerProperties);
    }

    @Override
    public void run() {
        this.read();
    }

    /**
     *
     */
    public void shutdown() {
        consumer.wakeup();
    }

    @Override
    public Collection<WikiEditSourceEvent> read() {
        Map<TopicPartition, OffsetAndMetadata> currentOffsets = new HashMap<>();

        // subscribe
        consumer.subscribe(Collections.singletonList("wikipedia.parsed"), new ConsumerRebalanceListener() {
            @Override
            public void onPartitionsRevoked(Collection<TopicPartition> partitions) {

                System.err.println(String.format("%s: Rebalance. Committing current offsets: %s", clientId, currentOffsets));
                logger.info(String.format("%S: Rebalance. Committing current offsets: %s", clientId, currentOffsets));

                consumer.commitSync(currentOffsets);
            }

            @Override
            public void onPartitionsAssigned(Collection<TopicPartition> partitions) {

                System.err.println(String.format("%s: Newly assigned partitions\n Current offset: %s", clientId, currentOffsets));
                logger.warn(String.format("%s: Newly assigned partitions\n Current offset: %s", clientId, currentOffsets));

                System.err.println(String.format("%s Partitions:", clientId));
                logger.info(String.format("%s Partitions:", clientId));
                for (TopicPartition partition: partitions) {
                    System.err.println(String.format("%s: (Topic, Partition) = (%s, %s)", clientId, partition.topic(), partition.partition()));
                    logger.warn(String.format("%s: (Topic, Partition) = (%s, %s)", clientId, partition.topic(), partition.partition()));
                }

                if (fromBeginning) consumer.seekToBeginning(partitions);
            }
        });

        // fetch
        int cpt = 0;

        // FIXME handle errors on processing
        try {
            while (true) {
                ConsumerRecords<String, WikiEdit> records = consumer.poll(Duration.ofMillis(100));

                if (! records.isEmpty()) {
                    for (ConsumerRecord<String, WikiEdit> record : records) {

                        logger.info("Key: " + record.key() + ", Value: " + record.value());
                        logger.info("Partition: " + record.partition() + ", Offset:" + record.offset());

                        WikiEdit w = record.value();
                        logger.info(String.format("Commit message: %s", w.getCommitmessage()));

                        currentOffsets.put(new TopicPartition(record.topic(), record.partition()),
                                new OffsetAndMetadata(record.offset()+1, "no metadata"));

                        // wikiedit to WikiEditSourceEvent
                        WikiEditSourceEvent sourceWikiEditEvent = WikiEditSourceEvent.of(w.getCreatedat(),
                                w.getWikipage().toString(),
                                w.getChannel().toString(),
                                w.getUsername().toString(),
                                w.getCommitmessage().toString(),
                                w.getBytechange(),
                                w.getDiffurl().toString(),
                                w.getIsnew(),
                                w.getIsminor(),
                                w.getIsbot(),
                                w.getIsunpatrolled());

                        // business processes
                        WikiEventService service = new WikiEventService();
                        processors.forEach(p -> p.process(sourceWikiEditEvent, service::transform));

                        cpt++;
                    }

                    try {

                        System.err.println(String.format("%s committing current offsets: %s", clientId, currentOffsets));
                        consumer.commitSync(currentOffsets);
                    } catch (CommitFailedException cfe) {
                        logger.error(String.format("%s: Commit failed", clientId), cfe);
                    }
                }
            }

        } catch (WakeupException e) {
            logger.info("Received shutdown signal!");
        } catch (Exception e) {
            logger.error("", e);
        }
        finally {
            logger.info("Finally");
            consumer.close();
        }

        System.err.println(String.format("%s has processed %d events", clientId, cpt));
        return null;
    }

    @Override
    public void registerProcessors(List<Processor> processors) {
        this.processors = processors;
    }

}
