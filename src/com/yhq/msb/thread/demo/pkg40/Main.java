package com.yhq.msb.thread.demo.pkg40;

public class Main {

    public static void main(String[] args) {
        Test.a();

        Test test = new Test();
        test.b();
    }

}

class Test {
    public static synchronized void a() {
        System.out.println("111");
    }

    public synchronized void b() {
        System.out.println("222");
    }
}
