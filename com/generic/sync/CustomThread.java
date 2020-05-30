package com.generic.sync;

public class CustomThread extends Thread {
    private CountDownLatch l = Test.l;
    private Lock lock = Test.lock;
    private PetersonLock pLock = Test.pLock;
    private SemaphoreActive sActive = Test.sActive;
    private SemaphorePassive sPassive = Test.sPassive;

    private String name;
    private int testType;
    private int ID;

    public CustomThread(int testType, String name, int ID) {
        this.testType = testType;
        this.name = name;
        this.ID = ID;
    }

    public void run() {
        switch (testType) {
            case 0: {
                testCDL();
                break;
            }

            case 1: {
                testLOCK();
                break;
            }

            case 2: {
                testPLOCK();
                break;
            }

            case 3: {
                testSEMACTIVE();
                break;
            }

            case 4: {
                testSEMPASSIVE();
                break;
            }
        }
    }

    private void testCDL() {
        System.out.println(name + ": En attente de la porte");

        l.countDown();
        System.out.println(name + ": Porte ouverte, fin du traitement.");
    }

    private void testLOCK() {
        System.out.println(name + ": cherche a récupérer le verrou");
        lock.lock();
        System.out.println(name + ": effectue une action protégée par le verrou");
        System.out.println(name + ": va relacher le verrou");
        lock.release();
    }

    private void testPLOCK() {
        System.out.println(name + " [" + ID + "]" + ": cherche a récupérer le verrou (peterson");
        pLock.lock(this.ID);
        System.out.println(name + " [" + ID + "]" + ": effectue une action protégée par le verrou (peterson)");
        System.out.println(name + " [" + ID + "]" + ": va relacher le verrou (peterson)");
        pLock.release(this.ID);
    }

    private void testSEMACTIVE() {
        System.out.println(name + ": cherche a aquérir un jeton");
        sActive.getToken(this);
        System.out.println(name + ": Effectue une action protégée par le sémaphore actif");
        System.out.println(name + ": va rendre le jeton au sémaphore actif");
        sActive.releaseToken();
    }

    private void testSEMPASSIVE() {
        System.out.println(name + ": cherche a aquérir un jeton");
        sPassive.getToken();
        System.out.println(name + ": effectue une action protégée par le sémaphore passif");
        System.out.println(name + ": va rendre le jeton au sémaphore passif");
        sPassive.releaseToken();
    }
}