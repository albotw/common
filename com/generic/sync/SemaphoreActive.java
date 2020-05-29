package com.generic.sync;

public class SemaphoreActive {
    private volatile int tokens;

    public SemaphoreActive(int tokens) {
        this.tokens = tokens;
    }

    public void getToken(Thread thr) {
        if (tokens != 0) {
            tokens--;
        } else {
            while (tokens == 0) {
                thr.yield();
            }
        }
    }

    public void releaseToken() {
        tokens++;
    }
}