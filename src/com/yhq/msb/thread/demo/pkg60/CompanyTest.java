package com.yhq.msb.thread.demo.pkg60;

import java.util.Date;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class CompanyTest {

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        System.out.println("111111111111");
        new Thread(() -> {
            lock.lock();
            System.out.println(new Date().toString() + "子线程获取锁资源并挂起");
            try {
                Thread.sleep(5000);
                condition.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("被唤醒");
        }).start();

        // ============main============
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lock.lock();
        System.out.println(new Date().toString() + "主线程等待5s拿到资源");
        condition.signal();
        System.out.println("22222222222");
        lock.unlock();
        System.out.println("3333333333");
    }
}
