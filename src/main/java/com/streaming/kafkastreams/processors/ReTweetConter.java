package com.streaming.kafkastreams.processors;

import com.streaming.kafkastreams.config.KafkaConfig;
import org.springframework.stereotype.Service;

import java.util.Properties;

@Service
public class ReTweetConter {

    KafkaConfig kafkaConfig;
    Properties properties;

    public ReTweetConter(KafkaConfig kafkaConfig) {
        this.properties = kafkaConfig.getSettings();
    }



}
