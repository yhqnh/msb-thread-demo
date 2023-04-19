package com.yhq.msb.thread.demo.pkg66;

import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Main {

    public static void main(String[] args) {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        ReentrantReadWriteLock.ReadLock readLock = reentrantReadWriteLock.readLock();
        ReentrantReadWriteLock.ReadLock readLock2 = reentrantReadWriteLock.readLock();
        ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();

        new Thread(() -> {
            try {
                readLock.lock();
                System.out.println("1111111111111");
                Thread.sleep(3000);
                System.out.println("333333333");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                readLock.unlock();
            }

        }).start();

        try {
            Thread.sleep(1000);
            readLock2.lock();
            System.out.println("222222222222");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readLock2.unlock();
        }
    }
}
