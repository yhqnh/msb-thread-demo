package com.yhq.msb.thread.demo.pkg214;

import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);

        integers.add(1, 4);
        integers.forEach(integer -> {
            System.out.println(integer);
        });

        CopyOnWriteArrayList<Integer> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        copyOnWriteArrayList.add(1);
        copyOnWriteArrayList.add(2);
        copyOnWriteArrayList.add(3);

        copyOnWriteArrayList.add(1, 4);
        copyOnWriteArrayList.forEach(integer -> {
            System.out.println(integer);
        });
    }
}
