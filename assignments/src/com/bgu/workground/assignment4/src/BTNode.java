package com.bgu.workground.assignment4.src;


import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Class BTNode
 * @author itay
 */
public class BTNode
{
    public  static int DEGREE;

    protected boolean mIsLeaf; // is node a leaf or not
    protected int mCurrentKeyNum; // current key number
    protected int mCurrentChildrenNum; // current number of children
    protected DataPair mKeys[]; // array of keys
    protected BTNode mChildren[]; // array of children

    //dedault constructor for new node
    public BTNode() {
        mIsLeaf = true;
        mCurrentKeyNum = 0;
        mCurrentChildrenNum=0;
        mKeys =  new DataPair[2*DEGREE-1];
        mChildren = new BTNode[2*DEGREE];
    }


    @Override
    public String toString() {
        String ans="";
        for (int i = 0; i < mCurrentKeyNum; i++) {
            ans+=mKeys[i].toString();
            if (i < mCurrentKeyNum - 1)
                ans+=",";
        }
        return ans;
    }
}
