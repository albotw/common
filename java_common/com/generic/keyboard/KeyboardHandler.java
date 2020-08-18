package com.generic.keyboard;

import javax.swing.JFrame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardHandler implements KeyListener {
    public boolean UP;
    public boolean DOWN;
    public boolean LEFT;
    public boolean RIGHT;
    public boolean SPACE;
    public boolean ESCAPE;

    private JFrame w;

    public void flush() {
        UP = false;
        DOWN = false;
        LEFT = false;
        RIGHT = false;
        SPACE = false;
        ESCAPE = false;
    }

    public KeyboardHandler(JFrame w) {
        flush();
        link(w);
        // System.out.println("--- Created Input Listener ---");
    }

    public void link(JFrame w) {
        if (this.w != null) {
            unlink();
        }

        this.w = w;
        w.addKeyListener(this);
    }

    public void unlink() {
        w.removeKeyListener(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getKeyChar() == 'z') {
            // System.out.println("Z");
            UP = true;
        } else if (e.getKeyChar() == 's') {
            // System.out.println("S");
            DOWN = true;
        } else if (e.getKeyChar() == 'q') {
            // System.out.println("Q");
            LEFT = true;
        } else if (e.getKeyChar() == 'd') {
            // System.out.println("D");
            RIGHT = true;
        } else if (e.getKeyChar() == ' ') {
            SPACE = true;
        } else if (e.getKeyCode() == KeyEvent.VK_ESCAPE || e.getKeyChar() == 'b')
        {
            ESCAPE = true;
        }
    }

    public void keyPressed(KeyEvent key) {

    }

    public void keyReleased(KeyEvent key) {

    }
}