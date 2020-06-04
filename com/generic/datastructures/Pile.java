package com.generic.datastructures;

import java.util.ArrayList;

/**
 * 
 * @param <T>
 */
public class Pile<T> {
    private ArrayList<T> pile;

    public Pile() {
        pile = new ArrayList<T>();
    }

    public synchronized T pull() {
        if (pile.size() != 0) {
            T tmp = pile.get(pile.size() - 1);
            pile.remove(pile.size() - 1);
            return tmp;
        } else {
            return null;
        }
    }

    public void push(T o) {
        pile.add(o);
    }

    public int size() {
        return pile.size();
    }

    public boolean contains(T obj) {
        return pile.contains(obj);
    }

    public boolean isEmpty() {
        return pile.isEmpty();
    }
}