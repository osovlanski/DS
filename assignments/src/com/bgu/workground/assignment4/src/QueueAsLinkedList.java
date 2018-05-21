package com.bgu.workground.assignment4.src;

import java.util.NoSuchElementException;

public class QueueAsLinkedList <T> implements Queue<T>{

    private List<T> list;

    public QueueAsLinkedList() {
        this.list = new LinkedList<>();
    }

    public int size(){
        return list.size();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public void enqueue(T element) {
        if(element == null)
            throw new NullPointerException();
        list.add(element);
    }


    public T dequeue() {
        if(isEmpty())
            throw new NoSuchElementException();
        T output = peek();
        list.remove(output);
        return output;
    }

    public T peek() {
        if(isEmpty())
            throw new NoSuchElementException();
        return list.get(0);
    }

}
