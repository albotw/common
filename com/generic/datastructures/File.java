package com.generic.datastructures;

import java.util.ArrayList;

/**
 * Premier entré premier sorti.
 * 
 * @param <T>
 */
public class File<T> {
    private ArrayList<T> file;

    public File() {
        file = new ArrayList<T>();
    }

    public synchronized T pull() {
        return null;
    }

    public void push(T o) {

    }

    public int size() {
        return file.size();
    }
}