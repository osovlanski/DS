package com.bgu.workground.assignment2.MemoryManagement;

/**
 * 
 * @author ADD YOUR NAME & ID
 */
public class Page {
    // ADD YOUR CODE HERE
    //key = a unique number for the current page
    //value = page data
    public int key;
    public String value;

    public Page(int key, String value) {
        this.key = key;
        this.value = value;
    }

    public void addData(char c){
        value+=c;
    }

    public void addData(String s){
        value+=s;
    }

    public void clear(){
       value = "";
    }

}
