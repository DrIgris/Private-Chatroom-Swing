package chatroom.networking;

import java.io.IOException;

import javax.swing.JTextArea;

import chatroom.Duplexer;
import chatroom.GUI.ChatroomGUI;
import chatroom.GUI.PopupHandler;

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
