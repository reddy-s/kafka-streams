package com.streaming.kafkastreams.config;

import io.confluent.kafka.serializers.AbstractKafkaAvroSerDeConfig;
import io.confluent.kafka.streams.serdes.avro.SpecificAvroSerde;
import org.apache.kafka.streams.StreamsConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

@Configuration
public class KafkaStreamsCustomConfig {

    private Logger log = LoggerFactory.getLogger(KafkaStreamsCustomConfig.class);

    @Value("${kafka.bootstrap-servers:localhost}")
    private String bootstrapServers;

    @Value("${kafka.schema-registry}")
    private String schemaRegistry;

    public KafkaStreamsCustomConfig() {
    }

    public String getBootstrapServers() {
        return bootstrapServers;
    }

    public String getSchemaRegistry() {
        return schemaRegistry;
    }

    public Properties getSettings() {
        Properties settings = new Properties();
        settings.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        settings.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, SpecificAvroSerde.class);
        settings.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, SpecificAvroSerde.class);
        settings.put(AbstractKafkaAvroSerDeConfig.SCHEMA_REGISTRY_URL_CONFIG, schemaRegistry);
        return settings;
    }
}
