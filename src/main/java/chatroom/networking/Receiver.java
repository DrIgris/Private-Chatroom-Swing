package src.main.java.chatroom.networking;

import java.io.IOException;

import javax.swing.JTextArea;
import javax.swing.Popup;

import src.main.java.chatroom.Duplexer;
import src.main.java.chatroom.GUI.ConnectionPopup;
import src.main.java.chatroom.GUI.PopupHandler;

public class Receiver implements Runnable{
    private JTextArea friendArea;
    private String name;
    private Duplexer duplexer;
    private boolean on;
    private ConnectionPopup popup;

    public Receiver(Duplexer duplexer, User friend, JTextArea friendArea, ConnectionPopup popup) throws IOException {
        name = friend.getName(); 
        this.duplexer = duplexer;
        this.friendArea = friendArea;
        this.popup = popup;
        on = true;
    }

    @Override
    public void run() {
        while (on) {
            String msg = duplexer.receive();
            if(msg.equals("CONNECTED")) {
                PopupHandler handle = new PopupHandler(popup, name);
                Thread t = new Thread(handle);
                t.start();
            } 
                friendArea.append(name + ": " + msg + "\n");
                friendArea.setCaretPosition(friendArea.getDocument().getLength());
            
        }
    }

    public void quit(){
        on = false;
    }

}
