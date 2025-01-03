package src.main.java.chatroom.networking;

import java.io.IOException;

import javax.swing.JTextArea;

import src.main.java.chatroom.Duplexer;
import src.main.java.chatroom.GUI.ChatroomGUI;
import src.main.java.chatroom.GUI.PopupHandler;

public class Receiver implements Runnable{
    private JTextArea friendArea;
    private String name;
    private Duplexer duplexer;
    private ChatroomGUI chat;

    public Receiver(Duplexer duplexer, User friend, JTextArea friendArea, ChatroomGUI chat) throws IOException {
        name = friend.getName(); 
        this.duplexer = duplexer;
        this.friendArea = friendArea;
        this.chat = chat;

    }

    @Override
    public void run() {
        while (true) {
            String msg = duplexer.receive();
            if(msg.equals("CONNECTED")) {
                PopupHandler handle = new PopupHandler(chat, name);
                Thread t = new Thread(handle);
                t.start();
            } 
                friendArea.append(name + ": " + msg + "\n");
                friendArea.setCaretPosition(friendArea.getDocument().getLength());
            
        }
    }

}
