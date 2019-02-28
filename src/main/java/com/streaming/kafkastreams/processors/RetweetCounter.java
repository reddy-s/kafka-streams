package com.streaming.kafkastreams.processors;

import org.springframework.stereotype.Service;

import java.util.Properties;

@Service("RetweetCounter")
public class RetweetCounter {

    private Properties settings;

    public RetweetCounter(Properties settings) {
        this.settings = settings;
    }
}
