package com.lolka.concurrent.locks;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicLong;

public class BulkProcessor {

    private static CyclicBarrier cyclicBarrier = new CyclicBarrier(5, new AfterComplete());
    private static final AtomicLong l = new AtomicLong();
    private static final ConcurrentLinkedQueue<String> q = new ConcurrentLinkedQueue<>();

    public static void main(String[] args) throws IOException {
        ExecutorService exe = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 50; ++i) {
            exe.submit(new Job());
        }
        exe.shutdown();

        try (ServerSocket s = new ServerSocket(61000)) {
            while (true) {
                try (Socket socket = s.accept()) {
                    BufferedInputStream stream = new BufferedInputStream(socket.getInputStream());
                    byte[] buffer = new byte[1024];
                    StringBuilder sb = new StringBuilder();
                    while (stream.read(buffer) > 0) {
                        sb.append(new String(buffer));
                    }
                    System.out.println("Batch done!");
                    System.out.println(sb.toString());
                }
            }
        }
    }

    private static class Job implements Runnable {
        @Override
        public void run() {
            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(1000));
                String e = Thread.currentThread().getName() + "-" + l.getAndIncrement();
                System.out.println("waiting batch...");
                cyclicBarrier.await();
                q.offer(e);
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }

    private static class AfterComplete implements Runnable {
        @Override
        public void run() {
            try (
                    Socket s = new Socket("127.0.0.1", 61000);
                    BufferedOutputStream b = new BufferedOutputStream(s.getOutputStream())
            ) {
                for (String str : q) {
                    b.write(str.getBytes());
                    b.write("\n".getBytes());
                }
                q.clear();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
