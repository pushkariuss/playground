package ru.pushkariuss.playground.concurrent.queues;


import ru.pushkariuss.playground.concurrent.common.Pack;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicLong;

public class PriorityHandler {

    private static final AtomicLong counter = new AtomicLong(0L);
    private static final Random random = new Random();

    public static void main(String[] args) {
        // unbounded!!!
        BlockingQueue<PriorityPack> p = new PriorityBlockingQueue<>();
        for (int i = 0; i < 1; ++i) {
            Receiver<PriorityPack> receiver = new Receiver<>(p);
            new Thread(receiver, Receiver.class.getSimpleName() + "-" + i).start();
        }
        for (int i = 0; i < 20; ++i) {
            Transmitter<PriorityPack> transmitter = new Transmitter<>(p, () -> new PriorityPack("pack-" + counter.getAndIncrement(), random.nextInt(10)));
            new Thread(transmitter, Transmitter.class.getSimpleName() + "-" + i).start();
        }
    }

    static class PriorityPack extends Pack implements Comparable<PriorityPack> {
        final int p;

        PriorityPack(String payload, int priority) {
            super(payload);
            p = priority;
        }

        @Override
        public int compareTo(PriorityPack o) {
            return -Integer.compare(p, o.p);
        }

        @Override
        public String toString() {
            return "PriorityPack{" + payload + "," + p + '}';
        }
    }
}
