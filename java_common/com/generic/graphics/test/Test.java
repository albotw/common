package com.generic.graphics.test;

import javax.swing.JFrame;

import com.generic.graphics.render.RenderThread;
import com.generic.graphics.render.Window;
import com.generic.graphics.sprites.AnimatedSprite;
import com.generic.graphics.sprites.Sprite;
import com.generic.graphics.sprites.SpriteFactory;
import com.generic.graphics.sprites.SpriteManager;

public class Test {
    public static void main(String[] args) {
        SpriteManager sm = SpriteManager.createSpriteManager();
        Window w = new Window(800, 600);
        w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        RenderThread rt = new RenderThread(w);
        AnimatedSprite as1 = new AnimatedSprite(400, 300, true, false);
        as1.loadImage("src/com/generic/graphics/test/textures/character/perso1_2.png", 500);
        as1.loadImage("src/com/generic/graphics/test/textures/character/perso1_1.png", 500);
        as1.loadImage("src/com/generic/graphics/test/textures/character/perso1_3.png", 500);
        as1.loadImage("src/com/generic/graphics/test/textures/character/perso1_1.png", 500);

        AnimatedSprite as2 = new AnimatedSprite(400, 300, false, false);
        as2.loadImage("src/com/generic/graphics/test/textures/effects/Hit1_1.png", 500);
        as2.loadImage("src/com/generic/graphics/test/textures/effects/Hit1_2.png", 500);
        as2.loadImage("src/com/generic/graphics/test/textures/effects/Hit1_3.png", 500);
        as2.loadImage("src/com/generic/graphics/test/textures/effects/Hit1_4.png", 500);

        Sprite bg1 = new Sprite(0, 0, "src/com/generic/graphics/test/textures/background/bg_bottom.png");
        Sprite bg2 = new Sprite(0, 0, "src/com/generic/graphics/test/textures/background/bg_top.png");

        SpriteFactory.createLoopAnimation(200, 200, "src/com/generic/graphics/test/textures/effects/Hit1_", 4, 2000);

        sm.addAnimatedSprite(as1, "foreground");
        sm.addAnimatedSprite(as2, "foreground");
        sm.addSprite(bg1, "background");
        sm.addSprite(bg2, "background");
        rt.start();
    }
}