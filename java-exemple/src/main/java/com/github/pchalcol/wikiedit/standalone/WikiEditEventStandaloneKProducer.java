package com.github.pchalcol.wikiedit.standalone;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.fluttercode.datafactory.impl.DataFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.Properties;

public class WikiEditEventStandaloneKProducer implements Runnable {
    private static Logger logger = LoggerFactory.getLogger(WikiEditEventStandaloneKProducer.class);

    private final String clientId;
    private final String topic;

    private KafkaProducer<String, WikiEditEvent> producer;

    public WikiEditEventStandaloneKProducer(String clientId, String topic) {
        this.clientId = clientId;
        this.topic = topic;

        Properties p = new Properties();
        p.setProperty(ProducerConfig.CLIENT_ID_CONFIG, clientId);
        p.setProperty(ProducerConfig.ACKS_CONFIG, "all");
        p.setProperty(ProducerConfig.ENABLE_IDEMPOTENCE_CONFIG, "true");
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

    // TODO gestion exceptions SR (marshalling, ...)
    // TODO Reinit des topics -> un topic pour l'ex. standalone et un autre pour l'ex. pipeline
    public void append(String key, WikiEditEvent wikiEdit) {
        ProducerRecord<String, WikiEditEvent> record = new ProducerRecord<>(topic, key, wikiEdit);

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

    @Override
    public void run() {

        // add a shutdown hook
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            logger.info("Caught shutdown hook");
            // flush data
            producer.flush();
            // flush and close producer
            producer.close();
            logger.info("Application has exited");
        }));

        DataFactory df = new DataFactory();

        Date minDate = df.getDate(2015, 1, 1);
        Date maxDate = new Date();

        String key = df.getRandomWord(10);

        for (int i = 0; i < 100; i++) {
            WikiEditEvent value = WikiEditEventFactory.of(
                    df.getName(),
                    df.getRandomChars(7),
                    df.getRandomWord(),
                    df.getRandomText(10, 20),
                    df.getRandomChars(10),
                    df.getDateBetween(minDate, maxDate));

            append(key, value);
        }
    }

    public void shutdown() {
        producer.close();
    }
}
