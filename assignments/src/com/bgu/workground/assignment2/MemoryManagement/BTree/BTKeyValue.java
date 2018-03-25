package com.bgu.workground.assignment2.MemoryManagement.BTree;



/**
 * Class BTKeyValue
 * @author itay
 */
public class BTKeyValue<K extends Comparable, V>
{
    protected K mKey;
    protected V mValue;

    public BTKeyValue(K key, V value) {
        mKey = key;
        mValue = value;
    }
}
