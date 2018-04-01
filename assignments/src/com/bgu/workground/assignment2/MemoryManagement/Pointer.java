package com.bgu.workground.assignment2.MemoryManagement;

public class Pointer<T> {
    public Node<T> pointTo;

    Pointer(Node<T> pointTo) {
        this.pointTo = pointTo;
    }
}
