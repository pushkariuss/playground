package ru.pushkariuss.playground.concurrent.locks;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class OldPlainJavaLocks {

    private static Object sharedObject;
    private final static Object lock = new Object();
    private final static AtomicInteger counter = new AtomicInteger(0);
    private static final Random random = new Random();

    public static void main(String[] args) {
        new Thread(new Consumer(), Consumer.class.getSimpleName()).start();
        new Thread(new Producer(), Producer.class.getSimpleName()).start();
    }

    private static class Consumer implements Runnable {
        @Override
        public void run() {
            while (true) {
                int millis = random.nextInt(5000);
                try {
                    Thread.sleep(millis);
                    synchronized (lock) {
                        if (sharedObject == null) {
                            lock.wait();
                            consume(sharedObject, millis);
                        } else {
                            consume(sharedObject, millis);
                        }
                    }
                } catch (InterruptedException e) {
                    return;
                }
            }
        }

        private void consume(Object o, int millis) {
            System.out.println(Thread.currentThread().getName() + " consumed: " + o + " after " + millis + "ms");
            sharedObject = null;
            lock.notify();
        }
    }

    private static class Producer implements Runnable {
        @Override
        public void run() {
            while (true) {
                int millis = random.nextInt(5000);
                try {
                    Thread.sleep(millis);
                    synchronized (lock) {
                        if (sharedObject != null) {
                            lock.wait();
                            produce(millis);
                        } else {
                            produce(millis);
                        }
                    }
                } catch (InterruptedException e) {
                    return;
                }
            }
        }

        private void produce(int millis) {
            Object o = "info-" + counter.getAndIncrement();
            System.out.println(Thread.currentThread().getName() + " produced: " + o + " after " + millis + "ms");
            sharedObject = o;
            lock.notify();
        }
    }
}
