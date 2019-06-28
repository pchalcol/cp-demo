package com.github.pchalcol.wikiedit.standalone.schemaregistry;

import io.confluent.kafka.schemaregistry.client.CachedSchemaRegistryClient;
import org.apache.avro.Schema;

import java.io.File;

public class SchemaWriter {

    public static void main(String[] args) {

        initSystemProperties();

        try {
            String schemaRegistry = "https://localhost:8085";
            CachedSchemaRegistryClient schemaProxy = new CachedSchemaRegistryClient(schemaRegistry, Integer.MAX_VALUE);

            Schema.Parser parser = new Schema.Parser();
            Schema enriched = parser.parse(new File("/home/pchalcol/Documents/pro/BNPP/kafka-formation/kafka-exemples/src/main/avro/enriched-wikiedit.avsc"));
            Schema transformed = parser.parse(new File("/home/pchalcol/Documents/pro/BNPP/kafka-formation/kafka-exemples/src/main/avro/transformed-wikiedit-sink.avsc"));

            if (! schemaProxy.getAllSubjects().contains("enriched-wikiedit-value") ||
                    schemaProxy.getAllVersions("enriched-wikiedit-value").isEmpty())
                schemaProxy.register("enriched-wikiedit-value", enriched);

            if (! schemaProxy.getAllSubjects().contains("transformed-wikiedit-sink-value") ||
                    schemaProxy.getAllVersions("transformed-wikiedit-sink-value").isEmpty())
                schemaProxy.register("transformed-wikiedit-sink-value", enriched);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static void initSystemProperties() {
        System.setProperty("javax.net.debug", "ssl,handshake");
        System.setProperty("javax.net.ssl.keyStore", "security/kafka.schemaregistry.keystore.jks");
        System.setProperty("javax.net.ssl.keyStorePassword", "confluent");
        System.setProperty("javax.net.ssl.trustStore", "security/kafka.schemaregistry.truststore.jks");
        System.setProperty("javax.net.ssl.trustStorePassword", "confluent");
    }
}
