package com.github.pchalcol.wikiedit.standalone.schemaregistry;

import io.confluent.kafka.schemaregistry.client.CachedSchemaRegistryClient;
import io.confluent.kafka.schemaregistry.client.SchemaMetadata;

import java.util.Collection;

public class SchemaReader {
    public static void main(String[] args) {
        if (args.length < 1) System.exit(1);

        initSystemProperties();

        try {
            String schemaRegistry = args[0];

            CachedSchemaRegistryClient client = new CachedSchemaRegistryClient(schemaRegistry, Integer.MAX_VALUE);
            Collection<String> subjects = client.getAllSubjects();

            subjects.forEach(s -> {
                try {
                    SchemaMetadata schemaMetadata = client.getLatestSchemaMetadata(s);
                    System.out.println();
                    System.out.println("subject : " + s);
                    System.out.println("schema : " + schemaMetadata.getSchema());
                    System.out.println("version : " + schemaMetadata.getVersion());
                    System.out.println("id : " + schemaMetadata.getId());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });

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

