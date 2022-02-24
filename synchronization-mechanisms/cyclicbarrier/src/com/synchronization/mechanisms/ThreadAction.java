package com.synchronization.mechanisms;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class ThreadAction implements Runnable {
    private CyclicBarrier barrier;

    public ThreadAction(CyclicBarrier barrier) {
        this.barrier = barrier;
    }

    @Override
    public void run() {
        try {
            System.out.println("Thread " + Thread.currentThread().getName() + " waiting at the barrier.");
            barrier.await();

            Thread.sleep(400);
            System.out.println("Thread " + Thread.currentThread().getName() + " released.");
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}

