package com.lolka.concurrent.queues;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

class Receiver<T> implements Runnable {
    private final Random random = new Random();
    private final BlockingQueue<T> queue;

    Receiver(BlockingQueue<T> queue) {
        this.queue = queue;
    }

    public void run() {
        while (!Thread.interrupted()) {
            try {
                int millis = random.nextInt(10000);
                T pack = queue.take();
                System.out.println(Thread.currentThread().getName() + ": Received " + pack + ". Processing it for " + millis + "ms");
                Thread.sleep(millis);
            } catch (InterruptedException e) {
                e.printStackTrace();
                return;
            }
        }
    }
}
