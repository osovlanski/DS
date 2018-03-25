package com.bgu.workground.assignment2.MemoryManagement.BTree;



/**
 * Interface BTIteratorIF
 * @author itay
 */
public interface BTIteratorIF <K extends Comparable, V> {
    public boolean item(K key, V value);
    public BTNode<K, V> getRootNode();
    public long size();
    public void clear();
    public BTree insert(K key, V value);
    public V delete(K key);
    public V read(K key);
    public BTree write(K key, V value);

}
