package com.github.pchalcol.wikiedit.standalone;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class StandaloneProducer {

    private final static Logger logger = LoggerFactory.getLogger(StandaloneProducer.class);
    private static ExecutorService executorService;
    private static WikiEditEventStandaloneKProducer producer;

    public static void main(String[] args) {
        executorService = Executors.newFixedThreadPool(2);

        producer = new WikiEditEventStandaloneKProducer("producer-1", "enriched-wikiedit");
        executorService.submit(producer);

    }

    private static void stop() {
        logger.info("Caught shutdown hook");
        producer.shutdown();
        executorService.shutdown();

        try {
            executorService.awaitTermination(2, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace(); // Quick and dirty
        }

        logger.info("Exit");
    }
}
