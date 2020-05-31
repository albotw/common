package com.generic.graphics;

import java.awt.*;

public abstract class AbstractSprite {
    protected int x;
    protected int y;
    protected int width;
    protected int height;

    protected Image texture;

    public AbstractSprite(int x, int y) {
        this.x = x;
        this.y = y;
    }

    protected void getImageDimensions() {
        this.width = this.texture.getWidth(null);
        this.height = this.texture.getHeight(null);
    }

    abstract Image getTexture();

    abstract void loadImage(String dir);

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}