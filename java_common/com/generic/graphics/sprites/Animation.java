package com.generic.graphics.sprites;

import java.util.ArrayList;
import java.awt.*;
import javax.swing.*;

public class Animation {
    private ArrayList<AnimationFrame> frames;
    private int currFrameIndex;
    private long animTime;
    private int totalDuration;
    private boolean loop;
    private boolean vBlank;
    private boolean ended;

    public Animation(boolean loop, boolean vBlank) {
        this.totalDuration = 0;
        this.loop = loop;
        this.vBlank = vBlank;

        this.frames = new ArrayList<AnimationFrame>();

        if (vBlank) {
            addFrame("src/textures/clear.png", 1); // ? utilité ? ajoute une frame de 1 contenant un carré de 1px noir.
        }

        start();
    }

    public void start() {
        animTime = 0;
        currFrameIndex = 0;
        ended = false;
    }

    public void reset() {
        start();
    }

    public void addFrame(String dir, long duration) {
        totalDuration += duration;
        ImageIcon ii = new ImageIcon(dir);
        Image img = ii.getImage();
        System.out.println("loaded " + dir + " [" + img.getHeight(null) + "x" + img.getWidth(null) + "] for duration " + duration);
        frames.add(new AnimationFrame(img, totalDuration));
    }

    public void update(long elapsedTime) {
        //System.out.println("animation update: " + currFrameIndex + " | " + frames.size() + " | " + animTime + " | " + totalDuration);
        if (frames.size() > 1 && !ended) {
            if (currFrameIndex != frames.size()) {
                animTime += elapsedTime;
                if (animTime > totalDuration) {
                    if (loop) // * on reboucle sur le début de l'animation
                    {
                        animTime = animTime % totalDuration;
                        currFrameIndex = 0;
                    } else // * on arrête l'animation
                    {
                        animTime = 0;
                        currFrameIndex = 0; // ? A voir si a la fin de l'animation, reste bloqué sur 1ere ou dernière
                                            // image.
                        ended = true;
                    }
                }
                while(animTime > getFrame(currFrameIndex).getEndTime())
                {
                    currFrameIndex++;
                }
            }
        }
    }

    public Image getImage() {
        return getFrame(currFrameIndex).image;
    }

    public AnimationFrame getFrame(int index) {
        return frames.get(index);
    }

    public boolean isClear() {
        return this.vBlank;
    }
}