package com.streaming.kafkastreams.processors;

import com.streaming.kafkastreams.config.KafkaConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Properties;

@Service
public class ReTweetConter {

    @Value("${processor.retweet-count.input-topic}")
    String inputTopic;

    @Value("${processor.retweet-count.output-topic}")
    String outputTopic;

    KafkaConfig kafkaConfig;

    Properties properties;

    public ReTweetConter(KafkaConfig kafkaConfig) {
        this.properties = kafkaConfig.getSettings();
    }


}
