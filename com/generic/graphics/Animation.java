package com.generic.graphics;

import java.util.ArrayList;
import java.awt.*;
import javax.swing.*;

public class Animation {
    private ArrayList<AnimationFrame> frames;
    private int currFrameIndex;
    private long animTime;
    private int totalDuration;
    private boolean loop;

    private boolean continuer;
    private boolean clear;

    public Animation(boolean loop, boolean clear) {
        this.totalDuration = 0;
        this.loop = loop;
        this.clear = clear;

        this.frames = new ArrayList<AnimationFrame>();

        if (clear) {
            addFrame("src/textures/clear.png", 1); // ? utilité ? ajoute une frame de 1 contenant un carré de 1px noir.
        }

        start();
    }

    public void start() {
        animTime = 0;
        currFrameIndex = 0;
        this.continuer = false;
    }

    public void addFrame(String dir, long duration) {
        totalDuration += duration;
        ImageIcon ii = new ImageIcon(dir);
        Image img = ii.getImage();
        frames.add(new AnimationFrame(img, totalDuration));
    }

    public void update(long elapsedTime) {
        if (frames.size() > 1) {
            if (currFrameIndex != frames.size()) {
                animTime += elapsedTime;
                if (animTime >= totalDuration) {
                    if (loop) // * on reboucle sur le début de l'animation
                    {
                        animTime = animTime % totalDuration;
                        currFrameIndex = 0;
                        continuer = true;
                    } else // * on arrête l'animation
                    {
                        animTime = 0;
                        currFrameIndex = 0; // ? A voir si a la fin de l'animation, reste bloqué sur 1ere ou dernière
                                            // image.
                        continuer = false;
                    }

                    /**
                     * * c'était dans le code, aucune idée pourquoi. if (continuer) {while(animTime
                     * > getFrame(currFrameIndex).endTime) { currFrameIndex++;}}
                     */
                }
            }
        }
    }

    public Image getImage() {
        if (frames.size() == 0) {
            return null;
        } else {
            return getFrame(currFrameIndex).image;
        }
    }

    public AnimationFrame getFrame(int index) {
        return frames.get(index);
    }

    public boolean isClear() {
        return this.clear;
    }
}