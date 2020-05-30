package com.generic.sync;

public class Test {
    public static CountDownLatch l = new CountDownLatch(3);
    public static Lock lock = new Lock();
    public static PetersonLock pLock = new PetersonLock();
    public static SemaphoreActive sActive = new SemaphoreActive(1);
    public static SemaphorePassive sPassive = new SemaphorePassive(1);

    public static void main(String[] args) {
        sPassiveTest();
    }

    public static void cdlTest() {
        // * FONCTIONNEL
        Thread thr1 = new CustomThread(0, "Thr 1", -1);
        Thread thr2 = new CustomThread(0, "Thr 2", -1);
        Thread thr3 = new CustomThread(0, "Thr 3", -1);

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

    public static void lockTest() {
        // * fonctionne, dans l'ordre d'accès au verrou
        Thread thr1 = new CustomThread(1, "Thr 1", -1);
        Thread thr2 = new CustomThread(1, "Thr 2", -1);
        Thread thr3 = new CustomThread(1, "Thr 3", -1);

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

    public static void pLockTest() {
        // * fonctionne, dans l'ordre d'accès au verrou
        Thread thr1 = new CustomThread(2, "Thr 1", 0);
        Thread thr2 = new CustomThread(2, "Thr 2", 1);

        thr1.start();
        thr2.start();

        try {
            thr1.join();
            thr2.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void sActiveTest() {
        // * fonctionne, ordre concurrentiel dans l'aquisition des jetons.
        Thread thr1 = new CustomThread(3, "Thr 1", -1);
        Thread thr2 = new CustomThread(3, "Thr 2", -1);
        Thread thr3 = new CustomThread(3, "Thr 3", -1);

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

    public static void sPassiveTest() {
        // * fonctionne, ordre d'accès séquentiel.
        Thread thr1 = new CustomThread(4, "Thr 1", -1);
        Thread thr2 = new CustomThread(4, "Thr 2", -1);
        Thread thr3 = new CustomThread(4, "Thr 3", -1);

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