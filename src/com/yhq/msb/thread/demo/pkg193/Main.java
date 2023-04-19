package com.yhq.msb.thread.demo.pkg193;

import java.util.concurrent.CyclicBarrier;

public class Main {

    public static void main(String[] args) throws Exception {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, () -> {
            System.out.println("all arrive");
        });
        new Thread(() -> {
            try {
                System.out.println("1111111111");
                cyclicBarrier.await();
                System.out.println("2222222222");
            } catch (Exception e) {
                System.out.println("interrupt 1");
            }
        }).start();
        new Thread(() -> {
            try {
                System.out.println("3333333333");
                cyclicBarrier.await();
                System.out.println("44444444");
            } catch (Exception e) {
                System.out.println("interrupt 2");
            }
        }).start();
        new Thread(() -> {
            try {
                System.out.println("55555555");
                cyclicBarrier.await();
                System.out.println("66666666");
            } catch (Exception e) {
                System.out.println("interrupt 3");
            }
        }).start();

        Thread.sleep(1000);
        System.out.println("=====================");

        new Thread(() -> {
            try {
                System.out.println("1111111111");
                int count = cyclicBarrier.await();
                System.out.println("2222222222=" + count);
            } catch (Exception e) {
                System.out.println("interrupt 1");
            }
        }).start();
        new Thread(() -> {
            try {
                System.out.println("3333333333");
                cyclicBarrier.await();
                System.out.println("44444444");
            } catch (Exception e) {
                System.out.println("interrupt 2");
            }
        }).start();
        new Thread(() -> {
            try {
                System.out.println("55555555");
                cyclicBarrier.await();
                System.out.println("66666666");
            } catch (Exception e) {
                System.out.println("interrupt 3");
            }
        }).start();
    }
}
