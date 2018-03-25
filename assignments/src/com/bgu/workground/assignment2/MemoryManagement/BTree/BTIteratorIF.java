package com.bgu.workground.assignment2.MemoryManagement.BTree;



/**
 * Interface BTIteratorIF
 * @author tnguyen
 */
public interface BTIteratorIF <K extends Comparable, V> {
    public boolean item(K key, V value);
    public BTNode<K, V> getRootNode();
    public long size();
    public void clear();

}
