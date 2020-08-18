package com.generic.graphics.render;

import com.generic.graphics.sprites.SpriteManager;

import java.awt.*;
import static com.generic.graphics.CONFIG.*;

public class RenderThread extends Thread {

    private boolean continueDrawing;
    private long currTime;

    private SpriteManager sm = SpriteManager.createSpriteManager();
    private FPSCounter fps;
    private Window w;
    private RenderPanel rp;

    public RenderThread(Window w) {
        this.w = w;
        fps = new FPSCounter();

        rp = new RenderPanel();
        w.setLayout(new BorderLayout());
        w.add(rp, BorderLayout.CENTER);

        continueDrawing = true;
        currTime = 0;
    }

    public void run() {
        System.out.println("--- RenderThread started ---");
        fps.start();
        while (continueDrawing) {
            sm.updateAnimations(TICK);
            //System.out.println("" + currTime);
            fps.frame();
            w.setTitle(WINDOW_TITLE + " | FPS: " + fps.get());
            // w.revalidate();
            rp.repaint();

            try {
                sleep(TICK);
                currTime += TICK;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("--- Arrêt RenderThread ---");
        SpriteManager.instance.flushSprites();
        w.setVisible(false);
        w.dispose();
    }

    public void stopRendering() {
        continueDrawing = false;
        fps.stop();
    }

    public Window getWindow() {
        return this.w;
    }
}