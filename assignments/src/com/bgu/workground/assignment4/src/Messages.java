package com.bgu.workground.assignment4.src;

import com.bgu.workground.assignment2.MemoryManagement.Node;

import javax.swing.text.html.HTMLDocument;
import java.io.*;
import java.util.Scanner;


public class Messages implements Iterable {
    private Message[]allMessages;
    private HashTable[] tables;

    //create hashtable for each message, receive the size of the table from user
    public void createHashTables(String arg) {
        tables = new HashTable[allMessages.length];
        Iterator it = iterator();
        int index = 0;
        while (it.hasNext()){
            tables[index] = new HashTable(Integer.parseInt(arg));
            Message m = (Message)it.next();
            String []words = m.getWords().split(" ");
            for (String w: words) {
                tables[index].add(w);
            }
            index++;
        }
    }

    //check if each message the fields [From,To] are not friends and find spams words
    public String findSpams(String s, BTree btree) {
        String out="";
        Iterator it = iterator();
        int index = 0;
        while (it.hasNext()){
            Message m = (Message)it.next();
            DataPair dp = new DataPair(m.getSender(),m.getReceiver());
            if (btree.search(dp)==null){
                out+= getSpamOutput(s, index);
            }
            index++;
        }
        if (out.isEmpty())
            return "";
        return out.substring(0,out.length()-1);
    }

    //check if spam message exist more times then the rate
    private String getSpamOutput(String s, int index) {
        String out="";
        Spams spams = new Spams();
        spams.generateMessages(s);
        Iterator it2 = spams.iterator();
        while (it2.hasNext()){
            Spam sp = (Spam) it2.next();
            if((double)tables[index].get(sp.getWords())/tables[index].size()*100
                    >= sp.getRate()) {
                out += index + ",";
                break;
            }
        }
        return out;
    }

    //read all the messages in the file and insert them to a queue
    private Queue<Message> getMessagesFromFile(String s){
        Queue<Message> queue = new QueueAsLinkedList<>();
        File inFile = new File(s);
        try {
            FileReader ifr = new FileReader(inFile);
            BufferedReader ibr = new BufferedReader(ifr);
            addMessagesToQueue(queue, ibr);
            ibr.close();
            ifr.close();
        }
        catch (Exception e) {
            throw new RuntimeException("Error \"" + e.toString() + "\" on file " + s);
        }
        return queue;
    }

    //read each line in txt and create messages by relevant elements
    private void addMessagesToQueue(Queue<Message> queue, BufferedReader ibr) throws IOException {
        String line = "";
        Message message = new Message();
        while (line != null) {
            line = ibr.readLine();
            if (line != null) {
                if (line.startsWith("From:")) message.setSender(line.replace("From:","").trim());
                else if (line.startsWith("To:")) message.setReceiver(line.replace("To:","").trim());
                else if (!line.isEmpty() & !line.equals("#")) message.appendWords(line);
                else if (line.equals("#")) {
                    queue.enqueue(message);
                    message = new Message();
                }
            }
        }
        if (!message.getWords().isEmpty())
            queue.enqueue(message);
    }

    //get output file and parse it to array
    public void generateMessages(String s){
        Queue<Message>list = getMessagesFromFile(s);
        if (list != null) {
            allMessages = new Message[list.size()];
            for (int i = 0; i < allMessages.length; i++) {
                allMessages[i] = list.dequeue();
            }
        }
    }

    @Override
    public Iterator iterator() {
        return new WordsIterator(allMessages);
    }

}
