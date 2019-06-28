package com.github.pchalcol.wikiedit.pipeline.infrastructure.kafka;

import com.github.pchalcol.wikiedit.pipeline.domain.model.repositories.WikiEditEventSink;
import com.github.pchalcol.wikiedit.pipeline.domain.model.WikiEditSinkEvent;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

public class KafkaWikiEventSink implements WikiEditEventSink {
    private static Logger logger = LoggerFactory.getLogger(KafkaWikiEventSink.class);

    private final String clientId;
    private final String topic;

    private KafkaProducer<String, WikiEditEventRecord> producer;

    public KafkaWikiEventSink(String clientId, String topic) {
        this.clientId = clientId;
        this.topic = topic;

        Properties p = new Properties();
        p.setProperty(ProducerConfig.CLIENT_ID_CONFIG, clientId);
        p.setProperty(ProducerConfig.ENABLE_IDEMPOTENCE_CONFIG, "true");
        p.setProperty(ProducerConfig.ACKS_CONFIG, "all");
        p.setProperty(ProducerConfig.MAX_IN_FLIGHT_REQUESTS_PER_CONNECTION, "1");
        //p.setProperty(ProducerConfig.BATCH_SIZE_CONFIG, "0"); // disable batch
        p.setProperty(ProducerConfig.BATCH_SIZE_CONFIG, "16384"); // small batch size  => reduce throughput
        //p.setProperty(ProducerConfig.LINGER_MS_CONFIG, "0"); // Don't wait before sending message

        Properties props = new Props()
                .schemaRegistrySecurity()
                .brokerSecurity()
                .defaultProducerProps()
                .customProps(p)
                .properties();

        producer = new KafkaProducer<>(props);
    }

    public void shutdown() {
        producer.close();
    }

    @Override
    public void append(WikiEditSinkEvent wikiEditEvent) {

        WikiEditEventRecord wikiEdit = WikiEditEventFactory.of(
                wikiEditEvent.getUsername(),
                wikiEditEvent.getChannel(),
                wikiEditEvent.getCommitMessage(),
                wikiEditEvent.getWikiPage(),
                wikiEditEvent.getDiffurl(),
                wikiEditEvent.getCreatedAt());

        ProducerRecord<String, WikiEditEventRecord> record = new ProducerRecord<>(topic, wikiEdit);

        producer.send(record, ((metadata, exception) -> {
            if (exception == null) {
                // success
                logger.info(clientId + ": Received new metadata. \n" +
                        "Topic:" + metadata.topic() + "\n" +
                        "Partition: " + metadata.partition() + "\n" +
                        "Offset: " + metadata.offset() + "\n" +
                        "Timestamp: " + metadata.timestamp());

                System.out.println(clientId + ": Received new metadata. \n" +
                        "Topic:" + metadata.topic() + "\n" +
                        "Partition: " + metadata.partition() + "\n" +
                        "Offset: " + metadata.offset() + "\n" +
                        "Timestamp: " + metadata.timestamp());
            } else {
                // error
                logger.error(clientId + "Unrecovered produce error", exception);

                System.err.println(clientId + "Unrecovered produce error");
                exception.printStackTrace();
            }
        }));

    }
}
