package com.generic.sync;

/**
 * Fonctionnel, Les threads ont accès au verrouillage dans l'ordre ou ils ont
 * appelé la méthode de verrouillage.
 */
public class Lock {
    private boolean locked;

    public Lock() {
        locked = false;
    }

    public void lock() {
        if (!locked) {
            locked = true;
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

    public void release() {
        locked = false;

        synchronized (this) {
            this.notify();
        }
    }
}