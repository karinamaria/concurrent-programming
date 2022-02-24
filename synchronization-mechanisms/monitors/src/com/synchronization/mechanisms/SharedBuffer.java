package com.synchronization.mechanisms;

import java.util.LinkedList;
import java.util.Queue;

public class SharedBuffer {
    private int capacity;
    private Queue<Integer> buffer;

    public SharedBuffer(int capacity) {
        this.capacity = capacity;
        buffer = new LinkedList<>();
    }

    public synchronized void insert(int item) {
        while (buffer.size() == capacity) {
            System.out.print("Buffer is full. ");
            System.out.println(Thread.currentThread().getName() + " suspended.\n");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        buffer.add(item);
        System.out.println(Thread.currentThread().getName() + " inserted " + item);
        notify();
    }

    public synchronized void remove() {
        while (buffer.size() == 0) {
            System.out.print("Buffer is empty. ");
            System.out.print(Thread.currentThread().getName() + " suspended.\n");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        int item = buffer.remove();
        System.out.println(Thread.currentThread().getName() + " removed " + item);
        notify();
    }
}

