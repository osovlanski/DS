package com.bgu.workground.assignment2.MemoryManagement.BTree;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Stack;



/**
 * Class BTree
 * @author itay
 * Description: BTree implementation
 */
public class BTree<K extends Comparable, V>
{
    public final static int     FIFO    =   1;
    public final static int     LRU     =   2;

    private BTNode<K, V> mRoot = null;
    private long  mSize;
    private final Stack<StackInfo> mStackTracer = new Stack<StackInfo>();

    public BTree(long mSize) {
        this.mSize = mSize;
    }

    //
    // Get the root node
    //
    public BTNode<K, V> getRootNode() {
        return mRoot;
    }

    //
    // The total number of nodes in the tree
    //
    public long size() {
        return mSize;
    }

    //
    // Clear all the entries in the tree
    //
    public void clear() {
        mSize = 0L;
        mRoot = null;
    }

    //
    // Create a node with default values
    //
    private BTNode<K, V> createNode() {
        BTNode<K, V> btNode;
        btNode = new BTNode();
        btNode.mIsLeaf = true;
        btNode.mCurrentKeyNum = 0;
        return btNode;
    }

    //
    // Search value for a specified key of the tree
    //
    public V read(K key) {
        throw new NotImplementedException();
    }

    //
    // Insert key and its value into the tree
    //
    public BTree write(K key, V value) {
        throw new NotImplementedException();
    }

    private int searchKey(BTNode<K, V> btNode, K key) {
        throw new NotImplementedException();
    }

    //
    // Delete a key from the tree
    // Return value if it finds the key and delete it
    // Return null if it cannot find the key
    //
    public V delete(K key) {
        throw new NotImplementedException();
    }


    /**
     * Inner class StackInfo for tracing-back purpose
     * Structure contains parent node and node index
     */
    public class StackInfo {
        public BTNode<K, V> mParent = null;
        public BTNode<K, V> mNode = null;
        public int mNodeIdx = -1;

        public StackInfo(BTNode<K, V> parent, BTNode<K, V> node, int nodeIdx) {
            mParent = parent;
            mNode = node;
            mNodeIdx = nodeIdx;
        }
    }
}
