package com.generic.graphics;

import java.awt.*;

import javax.swing.ImageIcon;

public class Sprite extends AbstractSprite {
    public Sprite(int x, int y) {
        super(x, y);
    }

    public Sprite(int x, int y, String dir) {
        super(x, y);
        loadImage(dir);
    }

    public Image getTexture() {
        return this.texture;
    }

    public void loadImage(String dir) {
        ImageIcon ii = new ImageIcon(dir);
        this.texture = ii.getImage();
        getImageDimensions();
    }
}
