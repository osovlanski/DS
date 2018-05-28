package com.bgu.workground.assignment4.src;



/**
 * Class DataPair
 * @author itay
 */
public class DataPair implements Comparable<DataPair>
{
    protected String left;
    protected String right;

    public DataPair(String left, String right) {
        this.left = left.trim();
        this.right = right.trim();
    }

    public void flip(){

        String temp = left;
        left = right;
        right = temp;
    }

    @Override
    public String toString() {
        return left+"&"+right;
    }

    @Override
    public int compareTo(DataPair o) {
        if (o == null) return 1;
        //o.sort();
        int ans = left.compareTo(o.left);
        if (ans == 0)
            ans = right.compareTo(o.right);
        return ans;
    }
}
