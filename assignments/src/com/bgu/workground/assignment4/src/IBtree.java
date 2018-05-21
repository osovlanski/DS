package com.bgu.workground.assignment4.src;



/**
 * Interface IBtree
 * @author itay
 */
public interface IBtree<T> {
    public int size(); //O(1)
    public void clear(); //O(1)
    public void insert(T item); //O(logn)
    public T delete(T key); //O(logn)
    public BTNode search(T key); //O(logn)

}
