package com.bgu.workground.assignment4.src;



/**
 * Class DataPair
 * @author itay
 */
public class DataPair implements Comparable<DataPair>
{
    private String left;
    private String right;

    public DataPair(String left, String right) {
        this.left = left;
        this.right = right;
    }

    public void flip(){
        String temp = left;
        left = right;
        right = temp;
    }

    @Override
    public String toString() {
        if (left.isEmpty()) return right;
        else if (right.isEmpty()) return left;
        return left+" & "+right;
    }

    //using regular string compare
    @Override
    public int compareTo(DataPair o) {
        if (o == null) return 1;
        int ans = left.compareTo(o.left);
        if (ans == 0)
            ans = right.compareTo(o.right);
        return ans;
    }
}
