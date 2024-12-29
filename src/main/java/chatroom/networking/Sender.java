package src.main.java.chatroom.networking;


import java.util.Scanner;

import src.main.java.chatroom.Duplexer;

public class Sender implements Runnable{
    //private GUI Screen for input
    //Private GUi Screen for output
    private Duplexer duplexer;
    private String name;
    private boolean on;


    public Sender(Duplexer duplexer, String name) {
        this.duplexer = duplexer;
        this.name = name;
        on = true;
    }

    @Override
    public void run() {
        // Scanner scan = new Scanner(System.in);
        // while (on) {
        //     String msg = scan.nextLine();
        //     System.out.println(name + ": " + msg); //print into output screen
        //     duplexer.send(msg);
        // }
        // scan.close();
    }

    public void send(String msg) {
        System.out.println(name + ": " + msg); //print into output screen
        duplexer.send(msg);
    }

    public void quit() {
        on = false;
    }
}
