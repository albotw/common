package com.generic.sync;

public class PetersonLock {
    private volatile int turn;
    boolean[] flag;

    public PetersonLock() {
        turn = 0;
        flag = new boolean[2];

        flag[0] = false;
        flag[1] = false;
    }

    public void lock(int id) {
        while (flag[turn] == true) {
            Thread.yield();
        }

        turn = id;
        flag[turn] = true;
    }

    public void release(int id) {
        flag[id] = false;
    }
}