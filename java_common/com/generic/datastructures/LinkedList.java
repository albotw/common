package com.generic.datastructures;

public class LinkedList<T> {
    private LinkedList next;
    private T value;

    public LinkedList()
    {
        this(null, null);
    }

    public LinkedList(T value)
    {
        this( null, value);
    }

    public LinkedList(LinkedList next)
    {
        this(next, null);
    }

    public LinkedList(LinkedList next, T value)
    {
        this.value = value;
        this.next = next;
    }

    public void setNext(LinkedList next)
    {
        this.next = next;
    }

    public void setValue(T val)
    {
        this.value = val;
    }

    public LinkedList getNext()
    {
        return this.next;
    }

    public T getValue()
    {
        return this.value;
    }

    public static int length(LinkedList l)
    {
        if (l.getNext() == null)
        {
            return 1;
        }
        else
        {
            return 1 + length(l.getNext());
        }
    }

    public static void deleteList(LinkedList l)
    {
        if (l != null)
        {
            deleteList(l.getNext());
            l = null;
        }
    }

    public static void pushBack(LinkedList l, LinkedList next)
    {
        if (l.getNext() != null)
        {
            pushBack(l.getNext(), next);
        }
        else
        {
            l.setNext(next);
        }
    }

    public static Object popFront(LinkedList l)
    {
        Object out = l.getValue();
        LinkedList toDelete = l.getNext();

        l.setNext(toDelete.getNext());
        l.setValue(toDelete.getValue());

        toDelete = null;

        return out;
    }

    public static void insert(LinkedList l, LinkedList add, int index)
    {
        if (index != 0)
        {
            insert(l.getNext(), add, --index);
        }
        else
        {
            add.setNext(l.getNext());
            l.setNext(add);
        }
    }
}
