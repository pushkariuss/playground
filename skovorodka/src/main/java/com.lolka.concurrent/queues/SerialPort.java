package com.lolka.concurrent.queues;

import com.lolka.common.Package;

import java.util.concurrent.SynchronousQueue;

/**
 * Created by pushkariuss on 12.06.16.
 */
public class SerialPort {
    public static void main(String[] args) {

    }

    private static final SynchronousQueue<Package> port = new SynchronousQueue<>();

    public static class Receiver implements Runnable {
        @Override
        public void run() {
            try {
                Package p = port.take();
                System.out.println("Took "+ p);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static class Transmitter implements Runnable {
        @Override
        public void run() {
            try {
                int i = 0;
                while (true) {
                    Package p = new Package("info-" + i++);
                    System.out.println("Transmitting "+ p);
                    port.put(p)
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
