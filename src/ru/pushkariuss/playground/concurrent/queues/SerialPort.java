package ru.pushkariuss.playground.concurrent.queues;

import com.lolka.common.Pack;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicLong;

public class SerialPort {
    private static final AtomicLong counter = new AtomicLong(0L);

    public static void main(String[] args) {
//        BlockingQueue<Pack> p = new SynchronousQueue<>();
        BlockingQueue<Pack> p = new LinkedBlockingQueue<>(5);
        for (int i = 0; i < 5; ++i) {
            Receiver<Pack> receiver = new Receiver<>(p);
            new Thread(receiver, Receiver.class.getSimpleName() + "-" + i).start();
        }
        for (int i = 0; i < 2; ++i) {
            Transmitter<Pack> transmitter = new Transmitter<>(p, () -> new Pack("pack-" + counter.getAndIncrement()));
            new Thread(transmitter, Transmitter.class.getSimpleName() + "-" + i).start();
        }
    }

}
