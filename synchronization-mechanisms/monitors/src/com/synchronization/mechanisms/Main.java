package com.synchronization.mechanisms;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int CAPACITY = 100;
    private static final int NUM_THREADS = 3;

    public static void main(String[] args) {
        SharedBuffer buffer = new SharedBuffer(CAPACITY);

        Producer[] producers = new Producer[NUM_THREADS];
        Consumer[] consumers = new Consumer[NUM_THREADS];

        for (int i = 0; i < NUM_THREADS; i++) {
            producers[i] = new Producer(buffer);
            consumers[i] = new Consumer(buffer);
        }

        ExecutorService executor = null;

        try {
            executor = Executors.newFixedThreadPool(NUM_THREADS);
            for(int i=0; i<NUM_THREADS; i++){
                executor.execute(producers[i]);
                executor.execute(consumers[i]);
            }

            executor.shutdown();
            executor.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            System.err.println("Tasks were interrupted.");
        } finally {
            if (!executor.isTerminated()) {
                System.err.println("Tasks will be interrupted.");
            }

            executor.shutdownNow();
            System.out.println("Executor was finished.");
        }
    }
}
