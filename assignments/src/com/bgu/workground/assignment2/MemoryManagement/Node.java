package com.bgu.workground.assignment2.MemoryManagement;/**
 *
 * @author
 * Itay osovlanski	 3111292974
 * Aslan aslan 302962493

 */

//Declare a node for 2D-linekd
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