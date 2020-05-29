package com.generic.sync;

public class Test {
    public static void main(String[] args) {
        CountDownLatch l = new CountDownLatch(3);

        Thread thr1 = new CustomThread(l, "Thr 1");
        Thread thr2 = new CustomThread(l, "Thr 2");
        Thread thr3 = new CustomThread(l, "Thr 3");

        thr1.start();
        thr2.start();
        thr3.start();

        try {
            thr1.join();
            thr2.join();
            thr3.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}