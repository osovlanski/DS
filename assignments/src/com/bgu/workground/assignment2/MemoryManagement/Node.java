package com.bgu.workground.assignment2.MemoryManagement;

public class Node<T> {
    Node previous;
    Node next;
    T element;

    public Node(Node previous, Node next, T element){
        this.previous = previous;
        this.next = next;
        this.element = element;
    }

    public Node(){
        //Node(null,null,null);
    }


}