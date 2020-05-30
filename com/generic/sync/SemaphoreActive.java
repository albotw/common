package com.generic.sync;

/**
 * Fonctionnel, donne l'accès a la ressource sans prendre en compte l'ordre
 * d'appel à la fonction.
 */
public class SemaphoreActive {
    private volatile int tokens;

    public SemaphoreActive(int tokens) {
        this.tokens = tokens;
    }

    public synchronized void getToken(Thread thr) {
        while (tokens == 0) {
            thr.yield();
        }

        if (tokens != 0) {
            tokens--;
            System.out.println("Token pris, reste " + tokens);
        }
    }

    public void releaseToken() {
        tokens++;
    }
}