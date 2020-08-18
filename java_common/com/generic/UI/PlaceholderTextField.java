package com.generic.UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class PlaceholderTextField extends JTextField {
    private String placeholder;

    public PlaceholderTextField(String ph) {
        super();
        this.placeholder = ph;
        this.setForeground(Color.GRAY);
        this.setText(ph);

        addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (getText().equals(placeholder)) {
                    setText("");
                    setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (getText().isEmpty()) {
                    setForeground(Color.GRAY);
                    setText(placeholder);
                }
            }
        });
    }

    public void flush() {
        setForeground(Color.GRAY);
        setText(placeholder);
    }

    public String getPHText() {
        return this.placeholder;
    }
}
