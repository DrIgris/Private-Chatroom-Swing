package src.main.java.chatroom.networking;

import java.io.IOException;
import java.net.Socket;

import src.main.java.chatroom.Duplexer;

public class Receiver implements Runnable{
    //private GUI Screen for respective friend
    private String name;
    private Duplexer duplexer;
    private boolean on;

    public Receiver(Duplexer duplexer, User friend) throws IOException {
        name = friend.getName(); 
        this.duplexer = duplexer;
        on = true;
    }

    public Receiver(Duplexer duplexer, User2 friend) throws IOException {
        name = friend.getName(); 
        this.duplexer = duplexer;
        on = true;
    }

    @Override
    public void run() {
        while (on) {
            System.out.println(name + ": " + duplexer.receive());
        }
    }

    public void quit(){
        on = false;
    }

}
