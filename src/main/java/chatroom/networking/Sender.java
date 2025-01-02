package src.main.java.chatroom.networking;

import javax.swing.JTextArea;

import src.main.java.chatroom.Duplexer;

public class Sender{
    private Duplexer duplexer;
    private String name;
    private JTextArea currentArea;
    private boolean on;


    public Sender(Duplexer duplexer, String name, JTextArea currentArea) {
        this.duplexer = duplexer;
        this.name = name;
        this.currentArea = currentArea;
        on = true;
    }

    public void send(String msg) {
        System.out.println(name + ": " + msg); //print into output screen
        currentArea.append(name + ": " + msg + "\n");
        duplexer.send(msg);
    }

    public void quit() {
        on = false;
    }
}
