package com.yhq.msb.thread.demo.pkg215;

import java.util.UUID;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReadWriteLock;

public class Main {

    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 1, TimeUnit.SECONDS, new ArrayBlockingQueue<>(3));

//        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
//            System.out.println("11111");
//            return "ok";
//        });
//
//        String result1 = null;
//        try {
//            result1 = completableFuture.get();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }
//        String result2 = completableFuture.join();
//
//        System.out.println(result1);
//        System.out.println(result2);

//        CompletableFuture.runAsync(() -> {
//            System.out.println("11111");
//        });
//
//        CompletableFuture<String> completableFuture1 = CompletableFuture.supplyAsync(() -> {
//            System.out.println(Thread.currentThread().getName());
//            UUID uuid = UUID.randomUUID();
//            return uuid.toString();
//        });
//
//        CompletableFuture<String> completableFuture2 = completableFuture1.thenApplyAsync((result) -> {
//            String result2 = result + "hhh";
//            System.out.println(Thread.currentThread().getName());
//            return result2;
//        }, threadPoolExecutor);
//
//        String result = completableFuture2.join();
//        System.out.println(result);


        CompletableFuture<Integer> integerCompletableFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println("任务1");
            return 1;
        }).thenCombine(CompletableFuture.supplyAsync(() -> {
            System.out.println("任务2");
            return 2;
        }), (result1, result2) -> {
            return result1 + result2;
        });

        System.out.println(integerCompletableFuture.join());
    }
}
