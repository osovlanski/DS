package com.bgu.workground;

import com.bgu.workground.assignment1.Tasks;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br1 = null;
        BufferedReader br2 = null;
        String sCurrentLine;

        List<String> list1 = new ArrayList<String>();
        List<String> list2 = new ArrayList<String>();
        br1 = new BufferedReader(new FileReader("./resources/output.txt"));
        br2 = new BufferedReader(new FileReader("./resources/output(LRU).txt"));
        while ((sCurrentLine = br1.readLine()) != null) {
            list1.add(sCurrentLine);
        }
        while ((sCurrentLine = br2.readLine()) != null) {
            list2.add(sCurrentLine);
        }
        List<String> tmpList = new ArrayList<String>(list1);
        tmpList.removeAll(list2);
        System.out.println("content from test.txt which is not there in test2.txt");
        for(int i=0;i<tmpList.size();i++){
            System.out.println(tmpList.get(i)); //content from test.txt which is not there in test2.txt
        }

        System.out.println("content from test2.txt which is not there in test.txt");

        tmpList = list2;
        tmpList.removeAll(list1);
        for(int i=0;i<tmpList.size();i++){
            System.out.println(tmpList.get(i)); //content from test2.txt which is not there in test.txt
        }


    }

}
