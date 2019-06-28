package com.github.pchalcol.wikiedit.standalone.schemaregistry;

import io.confluent.kafka.schemaregistry.client.CachedSchemaRegistryClient;

public class SchemaDeleter {

    public static void main(String[] args) {

        initSystemProperties();

        try {
            String schemaRegistry = "https://localhost:8085";
            CachedSchemaRegistryClient schemaProxy = new CachedSchemaRegistryClient(schemaRegistry, Integer.MAX_VALUE);

            if (schemaProxy.getAllSubjects().contains("enriched-wikiedit-value"))
                schemaProxy.deleteSubject("enriched-wikiedit-value");

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
