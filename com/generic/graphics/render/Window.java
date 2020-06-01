package com.generic.graphics.render;

import javax.swing.*;

public class Window extends JFrame {
    public Window(int width, int height) {
        this.setSize(width, height);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);
    }
}
