package com.bgu.workground.assignment4.src;

public class HashListElement <K, V>
{
    K key;
    V value;

    // Reference to next node
    HashListElement<K, V> next;

    public HashListElement(K key, V value)
    {
        this.key = key;
        this.value = value;
    }
}
