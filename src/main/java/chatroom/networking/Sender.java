package src.main.java.chatroom.networking;

import javax.swing.JTextArea;

import src.main.java.chatroom.Duplexer;

public class Sender{
    private Duplexer duplexer;
    private String name;
    private JTextArea currentArea;


    public Sender(Duplexer duplexer, String name, JTextArea currentArea) {
        this.duplexer = duplexer;
        this.name = name;
        this.currentArea = currentArea;

    }

    public void send(String msg) {
        if(msg != "\u2665") {
            System.out.println(name + ": " + msg); //print into output screen
            currentArea.append(name + ": " + msg + "\n");
            duplexer.send(msg);
        }
        
    }

}
