package ru.pushkariuss.playground.concurrent.queues;

import com.lolka.common.PackFactory;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

class Transmitter<T> implements Runnable {
    private final BlockingQueue<T> queue;
    private final PackFactory<T> factory;
    private final Random random = new Random();

    Transmitter(BlockingQueue<T> queue, PackFactory<T> f) {
        this.queue = queue;
        this.factory = f;
    }

    public void run() {
        while (!Thread.interrupted()) {
            try {
                int millis = random.nextInt(5000);
                T pack = factory.newPack();
                Thread.sleep(millis);
                queue.put(pack);
                System.out.println(Thread.currentThread().getName() + ": Transmitted " + pack + " in " + millis + "ms");
            } catch (InterruptedException e) {
                e.printStackTrace();
                return;
            }
        }

    }
}
