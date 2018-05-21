package com.bgu.workground.assignment4.src;

public class Spam extends Words {
    private double rate;

    public Spam(String word,double rate) {
        super(word);
        this.rate = rate;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }
}
