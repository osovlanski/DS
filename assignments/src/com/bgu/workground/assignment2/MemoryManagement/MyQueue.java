package com.bgu.workground.assignment2.MemoryManagement;

public interface MyQueue<T> {
    //add new item to the list
    public void append(T item);
    public void pushToStart(T item);
    public boolean isFull();
    public boolean isEmpty();
    public T removeFirst();
}
