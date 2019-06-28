package com.github.pchalcol.wikiedit.standalone;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

public class StandaloneConsumer {
    private static Logger logger = LoggerFactory.getLogger(StandaloneConsumer.class);

    private static CountDownLatch latch;

    private static WikiEditStandaloneConsumer consumer1;
    private static WikiEditStandaloneConsumer consumer2;
    private static WikiEditStandaloneConsumer consumer3;
    private static ExecutorService executorService;

    public static void main(String[] args) {

        executorService = Executors.newFixedThreadPool(3);

        latch = new CountDownLatch(1);
        Runtime.getRuntime().addShutdownHook(new Thread(StandaloneConsumer::stop));

        // Consumers
        consumer1 = new WikiEditStandaloneConsumer("consumer-1", true);
        executorService.submit(consumer1);

        consumer2 = new WikiEditStandaloneConsumer("consumer-2", true);
        executorService.submit(consumer2);

        consumer3 = new WikiEditStandaloneConsumer("consumer-3", false);
        executorService.submit(consumer3);

        // Stop consumer 2 => trigger rebalance
        sleepThenShutdown(consumer2, 5000);

        try {
            latch.await();
        } catch (InterruptedException e) {
            logger.error("Interrupted...", e);
        } finally {
            logger.info("Closing...");
        }
    }

    private static void sleepThenShutdown(WikiEditStandaloneConsumer consumer, long durationMillis) {

        try {
            Thread.sleep(durationMillis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        consumer.shutdown();
    }

    private static void stop() {
        logger.info("Caught shutdown hook");

        consumer1.shutdown();
        consumer2.shutdown();
        consumer3.shutdown();

        executorService.shutdown();

        try {
            executorService.awaitTermination(2, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        logger.info("Exit");
    }
}
