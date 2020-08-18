package com.generic.UI;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.JButton;

public class TransparentButton extends JButton {

    private Color transparant = new Color(0, 0, 0, 0.2f);
    private String name;
    private Image img;

    public TransparentButton(String str) {
        super(str);
        this.name = str;
    }

    public void paintComponent(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;

        GradientPaint gp = new GradientPaint(0, 0, Color.black, 0, 20, transparant, true);
        g2d.setPaint(gp);
        g2d.fillRect(0, 0, this.getWidth(), this.getHeight());
        g2d.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);

        g2d.setColor(Color.white);
        g2d.drawString(this.name, this.getWidth() / 3 - (this.getWidth() / 2 / 4), (this.getHeight() / 2) + 5);

    }

}