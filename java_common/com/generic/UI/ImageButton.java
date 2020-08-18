package com.generic.UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
//import java.io.File;

/**
 * Pour utiliser une police spéciale, décommentez toutes les lignes en
 * commentaire.
 */

public class ImageButton extends JButton {
    private Image focus;
    private Image noFocus;
    // private Font police;
    private String text;

    private boolean hasFocus;

    public ImageButton(String text, String focusDir, String noFocusDir, boolean fixed) {
        super();
        this.text = text;

        ImageIcon tmp = new ImageIcon(focusDir);
        focus = tmp.getImage();

        tmp = new ImageIcon(noFocusDir);
        noFocus = tmp.getImage();

        /**
         * try { police = Font.createFont(Font.TRUETYPE_FONT, new
         * File("ressources/police.ttf")); } catch (Exception e) { e.printStackTrace();
         * }
         */

        this.setOpaque(false);
        this.setContentAreaFilled(false);
        this.setBorderPainted(false);
        this.setBorder(null);
        hasFocus = false;

        if (!fixed) {
            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    super.mouseEntered(e);
                    if (!hasFocus) {
                        hasFocus = true;
                    }
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    super.mouseExited(e);
                    if (hasFocus) {
                        hasFocus = false;
                    }
                }
            });
        } else {
            hasFocus = false;
        }
    }

    public static ImageButton createStaticImageButton(String text, String textureDir) {
        return new ImageButton(text, textureDir, textureDir, true);
    }

    public static ImageButton createDynamicImageButton(String text, String focusTextureDir, String noFocusTextureDir) {
        return new ImageButton(text, focusTextureDir, noFocusTextureDir, false);
    }

    public void draw(Graphics g) {
        if (hasFocus) {
            g.drawImage(focus, 0, 0, this);
        } else {
            g.drawImage(noFocus, 0, 0, this);
        }
        g.setColor(Color.WHITE);
        // g.setFont(police.deriveFont(14f));
        g.drawString(text, 16, 23); // ! Paramètre a adapter en fonction de la taille du bouton.
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }
}