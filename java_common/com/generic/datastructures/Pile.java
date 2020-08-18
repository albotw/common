package com.generic.datastructures;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * dernier entré premier sorti
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

    public void push(T o)
    {
        pile.add(o);
    }

    public T peek()
    {
        if (pile.size() != 0)
        {
            return pile.get(pile.size() - 1);
        }
        else
        {
            return null;
        }
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

    public Iterator<T> getIterator()
    {
        return pile.iterator();
    }
}