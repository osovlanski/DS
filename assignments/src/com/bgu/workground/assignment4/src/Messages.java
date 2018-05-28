package com.bgu.workground.assignment4.src;

import com.bgu.workground.assignment2.MemoryManagement.Node;

import javax.swing.text.html.HTMLDocument;
import java.io.*;
import java.util.Scanner;


public class Messages implements Iterable {
    private Message[]allMessages;
    private HashTable[] tables;
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

    public String findSpams(String s, BTree btree) {
        String out="";
        Iterator it = iterator();
        int index = 0;
        while (it.hasNext()){
            Message m = (Message)it.next();
            DataPair dp = new DataPair(m.getSender(),m.getReceiver());
            if (btree.search(dp)==null){
                out = getSpamOutput(s, out, index);
            }
            index++;
        }
        return out.substring(0,out.length()-1);
    }

    private String getSpamOutput(String s, String out, int index) {
        Spams spams = new Spams();
        spams.generateMessages(s);
        Iterator it2 = spams.iterator();
        while (it2.hasNext()){
            Spam sp = (Spam) it2.next();
            if(tables[index].get(sp.getWords()) == sp.getRate()) {
                out += index + ",";
                break;
            }
        }
        return out;
    }

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
            System.out.println("Error \"" + e.toString() + "\" on file " + s);
            System.exit(-1); // brutally exit the program
        }
        return queue;
    }

    private void addMessagesToQueue(Queue<Message> queue, BufferedReader ibr) throws IOException {
        String line = "";
        Message message = new Message();
        while (line != null) {
            line = ibr.readLine();
            if (line != null) {
                if (line.startsWith("From:")) message.setSender(line.replace("From:","").trim());
                else if (line.startsWith("To:")) message.setReceiver(line.replace("To:","").trim());
                else if (!line.isEmpty() & !line.equals("#")) message.setWords(line);
                else if (line.equals("#")) {
                    queue.enqueue(message);
                    message = new Message();
                }
            }
        }
    }

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
