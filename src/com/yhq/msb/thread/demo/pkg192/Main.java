package com.yhq.msb.thread.demo.pkg192;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Main {

    public static void main(String[] args) throws Exception {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, () -> {
            System.out.println("all arrive");
        });
        new Thread(() -> {
            try {
                System.out.println("2222222222");
                cyclicBarrier.await();
                System.out.println("3333333333333");
            } catch (Exception e) {
                System.out.println("interrupt 2");
            }
        }).start();
        Thread jack = new Thread(() -> {
            try {
                System.out.println("444444444");
                cyclicBarrier.await();
                System.out.println("5555555555");
            } catch (Exception e) {
                System.out.println("interrupt 1");
            }
        });
        jack.start();
        jack.interrupt();

        System.out.println("0000000000");
    }
}
