package com.generic.sync;

/**
 * Fonctionnel. Donne l'accès dans l'ordre d'appel à getToken();
 */
public class SemaphorePassive {
    private int tokens;

    public SemaphorePassive(int tokens) {
        this.tokens = tokens;
    }

    public synchronized void getToken() {
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
        synchronized (this) {
            this.notify();
        }
    }
}