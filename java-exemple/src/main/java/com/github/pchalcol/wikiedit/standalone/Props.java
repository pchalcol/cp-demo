package com.github.pchalcol.wikiedit.standalone;

import io.confluent.kafka.serializers.KafkaAvroDeserializer;
import io.confluent.kafka.serializers.KafkaAvroSerializer;
import org.apache.kafka.clients.CommonClientConfigs;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.config.SaslConfigs;
import org.apache.kafka.common.config.SslConfigs;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

public class Props {

    private final Properties p;
    private final String bootstrapServers = "localhost:29091,localhost:29092";
    private final String srUrl = "https://localhost:8085";

    public Props() {

        // Default properties
        p = new Properties();
        p.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        p.setProperty("schema.registry.url", srUrl);
    }

    /**
     *
     * @return
     */
    public Props brokerSecurity() {
        // protocol
        p.put(CommonClientConfigs.SECURITY_PROTOCOL_CONFIG, "SASL_SSL");

        // truststore
        p.put(SslConfigs.SSL_TRUSTSTORE_LOCATION_CONFIG, String.format("%s/../scripts/security/kafka.kafka1.truststore.jks", System.getProperty("user.dir")));
        p.put(SslConfigs.SSL_TRUSTSTORE_PASSWORD_CONFIG,  "confluent");

        // keystore
        p.put(SslConfigs.SSL_KEYSTORE_LOCATION_CONFIG, String.format("%s/../scripts/security/kafka.kafka1.keystore.jks", System.getProperty("user.dir")));
        p.put(SslConfigs.SSL_KEYSTORE_PASSWORD_CONFIG, "confluent");
        p.put(SslConfigs.SSL_KEY_PASSWORD_CONFIG, "confluent");

        // sasl
        p.put(SaslConfigs.SASL_MECHANISM, "PLAIN");
        p.put(SaslConfigs.SASL_JAAS_CONFIG, "org.apache.kafka.common.security.plain.PlainLoginModule required  username=\"client\" password=\"client-secret\";");

        return this;
    }

    public Props schemaRegistrySecurity() {

        //System.setProperty("javax.net.debug", "ssl,handshake");
        System.setProperty("javax.net.ssl.keyStore", String.format("%s/../scripts/security/kafka.schemaregistry.keystore.jks", System.getProperty("user.dir")));
        System.setProperty("javax.net.ssl.keyStorePassword", "confluent");
        System.setProperty("javax.net.ssl.trustStore", String.format("%s/../scripts/security/kafka.schemaregistry.truststore.jks", System.getProperty("user.dir")));
        System.setProperty("javax.net.ssl.trustStorePassword", "confluent");

        return this;
    }

    public Props defaultConsumerProps() {
        p.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        p.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, KafkaAvroDeserializer.class.getName());
        p.setProperty(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        return this;
    }

    public Props defaultProducerProps() {
        p.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        p.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, KafkaAvroSerializer.class.getName());
        return this;
    }

    /**
     *
     * @return
     */
    public Props customProps(Properties props) {
        p.putAll(props);
        return this;
    }

    public Properties properties() {
        return p;
    }
}
