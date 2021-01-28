package com.generic.graphics.sprites;


import org.jetbrains.annotations.NotNull;

/**
 * Règles de chargement de sprites:
 * Tous les sprites doivent être au format png
 * les strings de dossier de base doivent être de la forme suivante:
 * textures/character/.../persoX.png
 * X correspond à la position de l'image dans l'animation.
 */
public class SpriteFactory {
    public static Sprite createSprite(int x, int y, String dir)
    {
        Sprite spr = new Sprite(x, y ,dir);
        SpriteManager.instance.addSprite(spr, "foreground");
        return spr;
    }

    public static Sprite createBackgroundSprite(int x, int y, String dir)
    {
        Sprite spr = new Sprite(x, y, dir);
        SpriteManager.instance.addSprite(spr, "background");
        return spr;
    }

    public static @NotNull
    AnimatedSprite createLoopAnimation(int x, int y, String baseDir, int nFrames, long totalDuration)
    {

        long frameDuration = totalDuration / nFrames;
        AnimatedSprite aspr = new AnimatedSprite(x, y, true, false);
        for (int i = 1; i <= nFrames; i++)
        {
            aspr.loadImage(baseDir +""+ i + ".png", frameDuration);
        }

        SpriteManager.instance.addAnimatedSprite(aspr, "foreground");

        return aspr;
    }

    public static AnimatedSprite createOneshotAnimation(int x, int y, String baseDir, int nFrames, long totalDuration)
    {
        long frameDuration = totalDuration / nFrames;
        AnimatedSprite aspr = new AnimatedSprite(x, y, false, false);
        for (int i = 1; i <= nFrames; i++)
        {
            aspr.loadImage(baseDir + i + ".png", frameDuration);
        }

        SpriteManager.instance.addAnimatedSprite(aspr, "foreground");

        return aspr;
    }
}
