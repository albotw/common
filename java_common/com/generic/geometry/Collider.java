package com.generic.geometry;

public class Collider {
    public static boolean pointInRect(Point p, Rectangle r)
    {
        return (p.x >= r.x && p.y >= r.y && p.x < r.x + r.width && p.y < r.y + r.height);
    }

    public static boolean RectInRect(Rectangle r1, Rectangle r2)
    {
        return (r1.x < r2.x);
    }
}
