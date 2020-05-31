package com.generic.graphics;

import java.awt.*;
import static com.generic.graphics.CONFIG.*;

public class RenderThread extends Thread {

    private boolean continueDrawing;

    private FPSCounter fps;
    private Window w;
    private RenderPanel rp;

    public RenderThread() {

        fps = new FPSCounter();

        rp = new RenderPanel();
        w.setLayout(new BorderLayout());
        w.add(rp, BorderLayout.CENTER);

        continueDrawing = true;
    }

    public void run() {
        System.out.println("--- RenderThread started ---");
        fps.start();
        while (continueDrawing) {

            fps.frame();
            w.setTitle(WINDOW_TITLE + " | FPS: " + fps.get());
            // w.revalidate();
            rp.repaint();

            try {
                sleep(16);
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