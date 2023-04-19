package com.yhq.msb.thread.demo.pkg197;

import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);

        new Thread(() -> {
            try {
                System.out.println("11111111111");
                semaphore.acquire();
                System.out.println("22222222222");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                semaphore.release();
            }
        }).start();
        new Thread(() -> {
            try {
                System.out.println("333333333");
                semaphore.acquire();
                System.out.println("4444444");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                semaphore.release();
            }
        }).start();
        new Thread(() -> {
            try {
                System.out.println("555555555");
                semaphore.acquire();
                System.out.println("66666666");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("gggggggggggggg");
                semaphore.release();
            }
        }).start();

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(() -> {
            try {
                System.out.println("777777777");
                semaphore.acquire();
                System.out.println("888888888");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                semaphore.release();
            }
        }).start();

    }
}
