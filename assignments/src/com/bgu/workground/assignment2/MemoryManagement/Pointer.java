package com.bgu.workground.assignment2.MemoryManagement;
/**
 *
 * @author
 * Itay osovlanski	 3111292974
 * Aslan aslan 302962493

 */

public class Pointer<T> {
    public Node<T> pointTo;

    Pointer(Node<T> pointTo) {
        this.pointTo = pointTo;
    }
}
