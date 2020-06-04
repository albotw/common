package com.generic.UI;

import javax.swing.*;
import java.awt.*;

public class TransparentPanel extends JPanel {
    private float panelOpacity;
    private float childrenOpacity;

    public TransparentPanel(float panelOpacity, float childrenOpacity) {
        this.panelOpacity = panelOpacity;
        this.childrenOpacity = childrenOpacity;
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, panelOpacity));
        super.paintComponent(g2d);
    }

    @Override
    protected void paintChildren(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(getBackground());
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, childrenOpacity));
        super.paintChildren(g);
    }
}