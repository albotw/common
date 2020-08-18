package com.generic.graphics.sprites;

import java.awt.*;

public class AnimationFrame {
    Image image;
    long endTime;

    public AnimationFrame(Image img, long endTime) {
        this.image = img;
        this.endTime = endTime;
    }

    public void setImage(Image img) {
        this.image = img;
    }

    public Image getImage() {
        return this.image;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }
}