package com.bgu.workground.assignment4.src;

public class HashList {
    private HashListElement<String,Integer> first;
    private int mSize;

    public HashList(String key,int value) {
        this.first = new HashListElement(key,value);
        this.mSize=1;
    }

    public HashList(){
        this.first = null;
        this.mSize = 0;
    }

    public int size(){
        return mSize;
    }

    // add item to hash. if exist, increase value by one.
    public void put(String key){
        HashListElement curr = first;
        if (curr == null)
            first = new HashListElement<>(key,1);
        else {
            while (curr.next != null && !curr.key.equals(key)) {
                curr = curr.next;
            }
            if (curr.key.equals(key)) {
                curr.value = (int) curr.value + 1;
            }else{
                curr.next = new HashListElement<>(key,1);
            }


        }
        mSize++;
    }


    // get item in hash. if not exist return -1
    public int get(String key){
        HashListElement curr = first;
        if (curr.key.equals(key))
            return (int)curr.value;
        while (curr.next != null && !curr.key.equals(key))
            curr = curr.next;
        if (curr.key.equals(key))
            return (int)curr.value;
        else
            return -1;
    }
}
