package com.streaming.kafkastreams.processors.impl;

import com.streaming.kafkastreams.config.KafkaConfig;
import com.streaming.kafkastreams.processors.KSProcessor;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.Properties;

@Service
public class ReTweetConter implements KSProcessor {

    @Value("${processor.retweet-count.input-topic}")
    String inputTopic;

    @Value("${processor.retweet-count.output-topic}")
    String outputTopic;

    @Value("${processor.retweet-count.app-id}")
    String applicationId;

    KafkaConfig kafkaConfig;

    Properties properties;

    public ReTweetConter(KafkaConfig kafkaConfig) {
        this.properties = kafkaConfig.getSettings();
        this.properties.put(StreamsConfig.APPLICATION_ID_CONFIG, applicationId);
    }

    @Bean("ReTweetCountProcessor")
    @ConditionalOnProperty(name = "processor.retweet-count.enabled")
    public void processor() {
        StreamsBuilder builder = new StreamsBuilder();
    }

}
