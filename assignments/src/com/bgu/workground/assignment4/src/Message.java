package com.bgu.workground.assignment4.src;

public class Message extends Words {
    private String sender;
    private String receiver;

    public Message(String sender, String receiver, String text) {
        super(text);
        this.sender = sender;
        this.receiver = receiver;
    }

    public Message(){
        super();
        new Message(null,null,null);
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

}
