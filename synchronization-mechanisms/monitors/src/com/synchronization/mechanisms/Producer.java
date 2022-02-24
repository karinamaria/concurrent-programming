package com.synchronization.mechanisms;

public class Producer extends Thread {

    private SharedBuffer buffer;

    public Producer(SharedBuffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        int item = (int) (Math.random() * 100) + 1;
        buffer.insert(item);
    }
}