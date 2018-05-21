package com.bgu.workground.assignment4.src;

public class Words {
    private String Words;

    public Words(String word) {
        this.Words = word;
    }

    public String getWords() {
        return Words;
    }

    public void setWords(String words) {
        Words = words;
    }

    public void appendWords(String words){
        Words+=words;
    }
}
