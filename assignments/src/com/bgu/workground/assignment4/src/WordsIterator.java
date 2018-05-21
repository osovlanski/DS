package com.bgu.workground.assignment4.src;

public class WordsIterator implements Iterator{
    private int index;
    private Words[] words;
    private int mSize;

    public WordsIterator(Words[] w) {
        index = 0;
        words = w;
        mSize = w.length;
    }

    @Override
    public boolean hasNext() {
        return index < mSize;
    }

    @Override
    public Words next() {
        if (!hasNext())
            throw new RuntimeException("there is no next message");

        index++;
        return words[index-1];
    }
}

