package com.bgu.workground.assignment4.src;

import java.util.Hashtable;

public class HashTable {

    // store array of chains
    private HashList[] mChainesArray;

    // Current capacity of array list
    private int mCapacity;

    // Current size of array list
    private int mCurrentNumItems;

    public HashTable(int M){
        if (M < 1)
            throw new IllegalArgumentException("number is lower then 1");

        mChainesArray = new HashList[M];
        mCapacity = M;
        mCurrentNumItems = 0;
    }

    public int size() { return mCurrentNumItems; }
    public boolean isEmpty() { return size() == 0; }

    // Returns value for a key
    public int get(String key)
    {
        // Find head of chain for given key
        int index = hashFunction(key,mCapacity);
        HashList head = mChainesArray[index];

        if (head == null){
           return -1;
        }
        //returns value
        return head.get(key);
    }

    // Adds a key value pair to hash
    public void add(String key){
        int index = hashFunction(key,mCapacity);
        if (mChainesArray[index] == null){
            mChainesArray[index] = new HashList(key,1);
        }else {
            mChainesArray[index].put(key);
        }
        mCurrentNumItems++;
    }

    // hash function using a prime number the decrease the collisions
    public int hashFunction(String s, int M){
        int hash = 7;
        for (int i = 0; i < s.length(); i++) {
            hash = hash*31 + s.charAt(i);
        }
        return  (Math.abs(hash) % M);
    }


}
