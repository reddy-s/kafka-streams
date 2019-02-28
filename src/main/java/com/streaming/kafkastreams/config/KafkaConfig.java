package com.streaming.kafkastreams.config;

import org.apache.kafka.streams.StreamsConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

@Configuration
public class KafkaConfig {

    @Value("${spring.application.name}")
    private String application;

    @Value("${kafka.bootstrap-servers}")
    private String bootstrapServers;

    private Properties settings;

    @Bean
    public Properties getSettings() {
        settings = new Properties();
        settings.put(StreamsConfig.APPLICATION_ID_CONFIG, application);
        settings.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        return settings;
    }
}
