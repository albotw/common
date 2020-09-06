package com.generic.datastructures;

public class BTree <T>{
    private BTree<T> left;
    private BTree<T> right;

    private T value;

    public BTree()
    {
        this(null, null, null);
    }

    public BTree(BTree left, BTree right)
    {
        this(left, right, null);
    }

    public BTree(T value)
    {
        this(null, null, value);
    }

    public BTree(BTree left, BTree right, T value)
    {
        this.left = left;
        this.right = right;
        this.value = value;
    }

    public boolean isLeaf()
    {
        return left == null && right == null;
    }
    
}
