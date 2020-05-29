package com.generic.sync;

public class CustomThread extends Thread {
    private CountDownLatch l;
    private String name;

    public CustomThread(CountDownLatch l, String name) {
        this.l = l;
        this.name = name;
    }

    public void run() {
        System.out.println(name + ": En attente de la porte");

        l.countDown();
        System.out.println(name + ": Porte ouverte, fin du traitement.");
    }
}