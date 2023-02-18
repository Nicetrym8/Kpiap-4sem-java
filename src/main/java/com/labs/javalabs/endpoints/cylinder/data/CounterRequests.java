package com.labs.javalabs.endpoints.cylinder.data;

import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Component;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

@Component
public class CounterRequests {

    private AtomicInteger counter;
    private static final Logger logger = LogManager.getLogger(CounterRequests.class);

    public CounterRequests() {
        counter = new AtomicInteger(0);
    }

    public synchronized void increment() {
        logger.info(String.format("Total requests: %d", counter.incrementAndGet()));
    }

    public synchronized int counter() {
        return counter.get();
    }
}