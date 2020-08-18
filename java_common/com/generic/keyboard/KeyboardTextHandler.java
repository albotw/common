package com.generic.keyboard;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class KeyboardTextHandler {
    private BufferedReader in;

    public KeyboardTextHandler() {
        InputStreamReader isr = new InputStreamReader(System.in);
        in = new BufferedReader(isr);
    }

    public String getLine() throws Exception {
        return in.readLine();
    }
}