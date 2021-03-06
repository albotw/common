package com.generic.sync;

/**
 * fonctionne, attend le nombre de threads [count] pour les débloquer.
 */

public class CountDownLatch {
    private int count;

    public CountDownLatch(int nThreads) {
        this.count = nThreads;
    }

    public synchronized void countDown() {
        count--;
        if (count == 0) {
            synchronized (this) {
                this.notifyAll();
            }
        } else {
            try {
                synchronized (this) {
                    this.wait();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public int getCount() {
        return this.count;
    }
}