package com.yhq.msb.thread.demo.pkg74;

import java.util.Arrays;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

public class Main {

    private Object lock = new Object();

    static ArrayBlockingQueue<Object> blockingQueue = new ArrayBlockingQueue<Object>(3);

    public static void main(String[] args) throws InterruptedException {

        blockingQueue.add("1");
        blockingQueue.add("2");
        blockingQueue.add("3");

        System.out.println(blockingQueue.offer("4"));

        System.out.println(blockingQueue.offer("5", 3000, TimeUnit.MILLISECONDS));
        try {
            blockingQueue.add("4");
        } catch (Exception e) {
            e.printStackTrace();
        }

//        blockingQueue.put("6");
        System.out.println("==============main end===============");

        Thread thread = new Thread(() -> {
            System.out.println(blockingQueue.remove());
            System.out.println("size=" + blockingQueue.size());
            System.out.println(blockingQueue.poll());
            try {
                System.out.println(blockingQueue.poll(3000, TimeUnit.MILLISECONDS));
            } catch (InterruptedException e) {
                System.out.println("6666666666666");
                System.out.println("kkkk=" + e.getMessage());
                System.out.println("777777777777");
            }
            System.out.println("88888888888888");
            try {
                System.out.println(blockingQueue.take());
//                System.out.println(blockingQueue.take());
            } catch (InterruptedException e) {
                System.out.println("999999999999");
                e.printStackTrace();
                System.out.println("22222222444444");
            }
            System.out.println("===============sub end============");
        });
        thread.start();
        thread.interrupt();

        System.out.println("ffffffff");
        Thread.sleep(5000);
        System.out.println("fffffjjjjjjjj");
//        thread.interrupt();
        System.out.println("fffffjjjjjjjjppppppppp");

        new Main().testInterrupt();
        Thread.sleep(1000);
        Thread.currentThread().interrupt();
    }

    public void testInterrupt() throws InterruptedException {
        System.out.println("fdsfdsf");
        synchronized (lock) {
            lock.wait();
        }
        System.out.println("testInterrupt");
    }
}
