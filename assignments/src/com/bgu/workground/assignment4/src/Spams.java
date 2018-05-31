package com.bgu.workground.assignment4.src;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Spams implements Iterable {
    private Spam[] allSpams;

    //read the file and create queue of spams
    private Queue<Spam> getMessagesFromFile(String s){
        Queue<Spam> queue = new QueueAsLinkedList<>();
        File inFile = new File(s);
        try {
            FileReader ifr = new FileReader(inFile);
            BufferedReader ibr = new BufferedReader(ifr);
            //get data for each line
            String line = "";
            while (line != null) {
                line = ibr.readLine();
                if (line != null) {
                    String text[] = line.split(" ");
                    queue.enqueue(new Spam(text[0],Double.parseDouble(text[1])));
                }
            }

            ibr.close();
            ifr.close();
        }

        catch (Exception e) {
            throw new RuntimeException("Error \"" + e.toString() + "\" on file " + s);
        }finally {
            return queue;
        }
    }

    public void generateMessages(String s){
        Queue<Spam>list = getMessagesFromFile(s);
        allSpams = new Spam[list.size()];
        for (int i = 0; i < allSpams.length; i++) {
            allSpams[i] = list.dequeue();
        }
    }

    @Override
    public Iterator iterator() {
        return new WordsIterator(allSpams);
    }
}
