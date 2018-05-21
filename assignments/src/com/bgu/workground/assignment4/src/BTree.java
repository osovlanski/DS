package com.bgu.workground.assignment4.src;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.StringTokenizer;


/**
 * Class BTree
 * @author itay
 * Description: BTree implementation
 */
public class BTree implements IBtree<DataPair>
{
    private int t;
    private BTNode mRoot = null;
    private int  mSize;

    public BTree(String arg) {
        t = Integer.parseInt(arg);
        BTNode.DEGREE = t;
        mRoot = createNode();
    }

    @Override
    public String toString() {
        return bfs();
    }

    // Function to traverse all nodes in a subtree rooted with this node
    private String bfs(){
        String ans="";
        //Base Case
        if (mRoot == null)
            return "";
        if (mRoot.mIsLeaf)
            return mRoot.toString();

        //create a queue for nodes and a queue for signs
        Queue<BTNode> q = new QueueAsLinkedList<>();
        Queue<Character> s = new QueueAsLinkedList<>();

        BTNode currNode = mRoot;
        q.enqueue(currNode);
        int nodeCount = 1;

        while (true){

            if (currNode.mCurrentChildrenNum == 0)
                return ans.substring(0,ans.length()-1);

            s.enqueue('#');
            int nextCount = 0;

            //enqueue all the nodes/signs in current high. and add the relevant values for ans
            while (nodeCount > 0){
                currNode = q.dequeue();
                ans+=currNode.toString();
                ans+=s.dequeue();
                nextCount += currNode.mCurrentChildrenNum;
                for (int i = 0; i < currNode.mCurrentChildrenNum; i++) {
                    q.enqueue(currNode.mChildren[i]);
                    if (i < currNode.mCurrentChildrenNum - 1)
                        s.enqueue('|');
                    else{
                        if (nodeCount > 1)
                            s.enqueue('^');
                    }

                }

                nodeCount--;
            }
            nodeCount = nextCount;
        }
    }


    //
    // Get the root node
    //
    public BTNode getRootNode() {
        return mRoot;
    }

    //
    // The total number of nodes in the tree
    //
    public int size() {
        return mSize;
    }

    //
    // Clear all the entries in the tree
    //
    public void clear() {
        mSize = 0;
        mRoot = null;
    }


    //
    // Create a node with default values
    //
    private BTNode createNode() {
        BTNode btNode;
        btNode = new <DataPair>BTNode ();
        btNode.mIsLeaf = true;
        btNode.mCurrentKeyNum = 0;
        return btNode;
    }


    public BTNode search(DataPair key){
        return search(mRoot,key);
    }

    //
    // Search value for a specified key of the tree
    //
    private BTNode search(BTNode btNode, DataPair key) {
        int i =0;
        while (i < btNode.mCurrentKeyNum && key.compareTo(btNode.mKeys[i]) > 0)
            i++;

        if (i < btNode.mCurrentKeyNum && key.compareTo(btNode.mKeys[i])==0)
            return btNode;//btNode.mKeys[i];
        if (btNode.mIsLeaf)
            return null;
        return search(btNode.mChildren[0],key);
    }

    public void insert(DataPair item){
        BTNode curr = mRoot;
        // If root is full, then tree grows in height
        if (curr.mCurrentKeyNum == 2*t-1) {
            BTNode s = createNode();
            mRoot = s;
            s.mIsLeaf = false;
            s.mChildren[0] = curr;
            s.mCurrentChildrenNum++;
            splitChild(s,0,curr);
            // New root has two children now.  Decide which of the
            // two children is going to have new key
            int i =0;
            if (item.compareTo(s.mKeys[0]) > 0)
                i++;
            insertNonFull(s.mChildren[i],item);

        }else
            insertNonFull(curr,item);

        mSize++;
    }

    // A utility function to insert a new key in this node
    // The assumption is, the node must be non-full when this
    // function is called
    private void insertNonFull(BTNode x, DataPair k) {
        if (x == null)
            x = createNode();
        int i = x.mCurrentKeyNum - 1;
        if (x.mIsLeaf){

            // The following loop does two things
            // a) Finds the location of new key to be inserted
            // b) Moves all greater keys to one place ahead
            while (i >= 0 && k.compareTo(x.mKeys[i]) < 0){
                x.mKeys[i+1] = x.mKeys[i];
                i--;
            }

            // Insert the new key at found location
            x.mKeys[i+1] = k;
            x.mCurrentKeyNum++;
        }else{
            // Find the child which is going to have the new key
            while (i>= 0 && k.compareTo(x.mKeys[i]) < 0)
                i--;

            i++;
            // See if the found child is full
            if (x.mChildren[i] != null && x.mChildren[i].mCurrentKeyNum == 2*t -1){
                splitChild(x,i,x.mChildren[i]);
                if (k.compareTo(x.mKeys[i]) > 0)
                    i++;
            }
            insertNonFull(x.mChildren[i],k);
        }
    }

    // A utility function to split the child y of this node
    // Note that y must be full when this function is called
    private void splitChild(BTNode x, int i, BTNode y) {
        // Create a new node which is going to store (t-1) keys
        // of y
        BTNode z = createNode();
        z.mIsLeaf = y.mIsLeaf;
        z.mCurrentKeyNum = t-1;
        // Copy the last (t-1) keys of y to z
        for (int j = 0; j < t-1; j++)
            z.mKeys[j]= y.mKeys[j+t];
        if(!y.mIsLeaf) {
            // Copy the last t children of y to z
            for (int j = 0; j < t; j++)
                z.mChildren[j] = y.mChildren[j + t];
            z.mCurrentChildrenNum = t;
        }
        y.mCurrentKeyNum = t-1;

        // Since this node is going to have a new child,
        // create space of new child
        for (int j = x.mCurrentKeyNum; j >= i+1; j--)
            x.mChildren[j+1] = x.mChildren[j];
        x.mChildren[i+1] = z;
        x.mCurrentChildrenNum++;

        // A key of y will move to this node. Find location of
        // new key and move all greater keys one space ahead
        for (int j = x.mCurrentKeyNum-1; j >= i; j--)
            x.mKeys[j+1] = x.mKeys[j];

        // Copy the middle key of y to this node
        x.mKeys[i] = y.mKeys[t-1];
        x.mCurrentKeyNum++;
    }


    //
    // Delete a key from the tree
    // Return value if it finds the key and delete it
    // Return null if it cannot find the key
    //
    public DataPair delete(DataPair key) {
        throw new NotImplementedException();
    }



    public void createFullTree(String s) {
        File inFile = new File(s);
        try {
            FileReader ifr = new FileReader(inFile);
            BufferedReader ibr = new BufferedReader(ifr);

            String line = "";
            while (line != null) {
                line = ibr.readLine();
                if (line != null) {
                    String[] friends = line.split("&");
                    if (friends.length == 2) {
                        DataPair dp = new DataPair(friends[0], friends[1]);
                        if (search(dp) == null)
                            insert(dp);
                    }
                }
            }

            ibr.close();
            ifr.close();
        }

        catch (Exception e) {
            System.out.println("Error \"" + e.toString() + "\" on file "
                    + s);
            e.printStackTrace();
            System.exit(-1); // brutally exit the program
        }

        System.out.println("Done");
    }



}
