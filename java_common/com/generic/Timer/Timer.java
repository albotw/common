package com.generic.Timer;

public class Timer extends Thread {
    private boolean stop;
    private boolean chrono;
    // ? true = chrono | false = décompte

    private int tick;
    // ? Compte toutes les [interval]. (ms)
    private int tMax;
    // ? Valeur d'origine du décompte (-1 si chrono) (ms)
    private int currT;
    // ? temps actuellement écoulé. (ms)

    private TimerLink tl;

    public Timer(boolean chrono, int tick, int tMax, TimerLink tl) {
        this.chrono = chrono;
        this.tick = tick;
        this.tMax = tMax;
        this.tl = tl;
    }

    public static Timer createChrono(int tick) {
        return new Timer(true, tick, -1, null);
    }

    public static Timer createCounter(int val, int tick, TimerLink tl) {
        return new Timer(false, tick, val, tl);
    }

    public void run() {
        try {
            while (!stop) {
                currT += tick;
                if (currT >= tMax && !chrono) {
                    stop = false;
                    tl.timerEnded();
                }

                sleep(tick);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void stopTimer() {
        stop = true;
    }

    public int getCurrentTime() {
        return this.currT;
    }
}