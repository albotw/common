package com.generic.datastructures;

import java.util.ArrayList;
import java.util.Queue;

/**
 * premier entré premier sorti
 *
 * @param <T>
 */
public class File<T>{
    private ArrayList<T> file;

    public File()
    {
        file = new ArrayList<T>();
    }

    public synchronized T pull()
    {
        if (!isEmpty())
        {
            T tmp = file.get(0);
            file.remove(0);
            return tmp;
        }
        else
        {
            return null;
        }
    }

    public synchronized void push(T elm)
    {
        file.add(0, elm);
    }

    public T peek()
    {
        if (!isEmpty())
        {
            return file.get(0);
        }
        else
        {
            return null;
        }
    }

    public int size() {return file.size();}

    public boolean contains(T elm) {return file.contains(elm);}

    public boolean isEmpty() {return file.isEmpty();}
}
