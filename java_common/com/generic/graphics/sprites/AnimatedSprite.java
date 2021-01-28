package com.generic.graphics.sprites;

import java.awt.*;

public class AnimatedSprite extends Sprite {
    protected Animation anim;

    public AnimatedSprite(int x, int y, boolean loop, boolean clear) {
        super(x, y);
        this.anim = new Animation(loop, clear);
    }

    @Override
    public Image getTexture() {
        return this.anim.getImage();
    }

    public void loadImage(String dir, long duration) {
        this.anim.addFrame(dir, duration);
    }

    public void loadImage(String dir) {
        loadImage(dir, 100);
    }

    public void updateAnim(long elapsedTime) {
        this.anim.update(elapsedTime);
    }
}