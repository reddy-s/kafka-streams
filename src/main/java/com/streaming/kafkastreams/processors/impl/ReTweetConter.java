package com.streaming.kafkastreams.processors.impl;

import com.streaming.avro.messages.tweets.Key;
import com.streaming.kafkastreams.config.KafkaStreamsCustomConfig;
import com.streaming.kafkastreams.processors.KSProcessor;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.Topology;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.Printed;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.Properties;

@Service
public class ReTweetConter implements KSProcessor {

    private Logger log = LoggerFactory.getLogger(ReTweetConter.class);

    @Value("${processor.retweet-count.input-topic}")
    String inputTopic;

    @Value("${processor.retweet-count.output-topic}")
    String outputTopic;

    @Value("${processor.retweet-count.app-id}")
    String applicationId;

    private Properties properties;

    public ReTweetConter(KafkaStreamsCustomConfig config) {
        this.properties = config.getSettings();
    }

    @Bean("ReTweetCountProcessor")
    @ConditionalOnProperty(name = "processor.retweet-count.enabled")
    public void processor() {
        // adding applicationId property
        this.properties.put(StreamsConfig.APPLICATION_ID_CONFIG, applicationId);
        // building a stream
        StreamsBuilder builder = new StreamsBuilder();
        KStream<Key, com.streaming.avro.messages.tweets.Value> inputStream = builder.stream(inputTopic);
        inputStream.print(Printed.toSysOut());
        Topology topology = builder.build();
        KafkaStreams streams = new KafkaStreams(topology, this.properties);
        streams.start();
    }

}
