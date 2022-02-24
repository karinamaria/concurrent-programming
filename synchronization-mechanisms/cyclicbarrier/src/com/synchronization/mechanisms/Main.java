package com.synchronization.mechanisms;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int NUM_THREADS = 2;

    public static void main(String[] args) {
        Runnable barrierAction = () -> System.out.println("Releasing threads at the barrier.");

        CyclicBarrier barrier = new CyclicBarrier(NUM_THREADS, barrierAction);
        //CyclicBarrier barrier = new CyclicBarrier(NUM_THREADS)

        ThreadAction threadA = new ThreadAction(barrier);
        ThreadAction threadB = new ThreadAction(barrier);

        ExecutorService executor = null;

        try {
            executor = Executors.newFixedThreadPool(NUM_THREADS);
            executor.execute(threadA);
            executor.execute(threadB);

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
