package src.main.java.chatroom.networking;

import java.io.IOException;

import javax.swing.JTextArea;

import src.main.java.chatroom.Duplexer;

public class Receiver implements Runnable{
    private JTextArea friendArea;
    private String name;
    private Duplexer duplexer;
    private boolean on;

    public Receiver(Duplexer duplexer, User friend, JTextArea friendArea) throws IOException {
        name = friend.getName(); 
        this.duplexer = duplexer;
        this.friendArea = friendArea;
        on = true;
    }

    @Override
    public void run() {
        while (on) {
            String msg = duplexer.receive();
            if(msg.equals("\u2665")) {

            } else {
                friendArea.append(name + ": " + msg + "\n");
                friendArea.setCaretPosition(friendArea.getDocument().getLength());
            }
            
        }
    }

    public void quit(){
        on = false;
    }

}
