package com.yhq.msb.thread.demo.pkg185;

import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) {
        FutureTask<String> futureTask = new FutureTask<String>(() -> {
            System.out.println("111111111");
            Thread.sleep(1000);
            System.out.println("2222222222");
            return "ok";
        });

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 2, 3, TimeUnit.SECONDS, new ArrayBlockingQueue<>(3));
        threadPoolExecutor.execute(futureTask);
        String result = null;
        try {
            result = futureTask.get(500, TimeUnit.MILLISECONDS);
        } catch (Exception e) {
            System.out.println("result=" + result);
        }

        try {
            Thread.sleep(1000);
            System.out.println("3333333333=" + futureTask.isDone());
            Thread.sleep(1000);
            System.out.println("3333333333=" + futureTask.isDone());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            result = futureTask.get();
            System.out.println("result=" + result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        // 如果任务已经执行，通过中断方式取消
        futureTask.cancel(true);
    }
}
