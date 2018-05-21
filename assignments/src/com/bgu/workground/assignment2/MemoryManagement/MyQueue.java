package com.bgu.workground.assignment2.MemoryManagement;/**
 *
 * @author
 * Itay osovlanski	 3111292974
 * Aslan aslan 302962493

 */

public interface MyQueue<T> {
    //add new item to the list O(1)
    public void append(T item);
    //check if the queue is full
    public boolean isFull();
    //check if the queue is empty
    public boolean isEmpty();
    //remove the first item from the queue
    public T removeFirst();
}
