package com.generic.graphics.sprites;

import java.util.ArrayList;

//Singleton OK

public class SpriteManager {
    public static SpriteManager instance;

    private ArrayList<Sprite> foreground;
    private ArrayList<Sprite> background;
    private ArrayList<AnimatedSprite> toUpdate;

    private SpriteManager() {
        instance = this;
        foreground = new ArrayList<Sprite>();
        background = new ArrayList<Sprite>();
        toUpdate = new ArrayList<AnimatedSprite>();
    }

    public static SpriteManager createSpriteManager() {
        if (instance == null) {
            instance = new SpriteManager();
        }

        return instance;
    }

    public synchronized void addSprite(Sprite spr, String position) {
        if (position == "foreground") {
            foreground.add(spr);
        } else if (position == "background") {
            background.add(spr);
        }
        System.out.println(foreground.size() + " | " + toUpdate.size());
    }

    public synchronized void addAnimatedSprite(AnimatedSprite spr, String position) {
        toUpdate.add(spr);
        addSprite(spr, position);
    }

    public synchronized void flushSprites() {
        foreground.clear();
        background.clear();
    }

    public synchronized Sprite getSprite(int index, String position) {
        if (position == "foreground" && !foreground.isEmpty()) {
            return foreground.get(index);
        } else if (position == "background" && !background.isEmpty()) {
            return background.get(index);
        } else {
            return null;
        }
    }

    public synchronized void updateAnimations(long elapsedTime) {
        for (int i = 0; i < toUpdate.size(); i++) {
            toUpdate.get(i).updateAnim(elapsedTime);
        }
        System.out.println("updated animations");
    }

    public int getFSize() {
        return foreground.size();
    }

    public int getBSize() {
        return background.size();
    }
}