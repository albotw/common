package com.generic.sync;

public class SemaphorePassive {
    private int tokens;

    public SemaphorePassive(int tokens) {
        this.tokens = tokens;
    }

    public void getToken() {
        if (tokens != 0) {
            tokens--;
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

    public void releaseToken() {
        tokens++;
    }
}