package src.main.java.chatroom.product;

import java.io.IOException;

import src.main.java.chatroom.GUI.ChatroomGUI;
import src.main.java.chatroom.networking.User;

public class Application {
    private User currentUser;
    private User friend;
    private User f2;
    private ChatroomGUI chat;
    //Normally have UserList for friends

    public Application(User currentUser, User friend, User f2) throws IOException {
        this.currentUser = currentUser;
        this.friend = friend;
        this.f2 = f2;
        setup();
    }
    

    public void setup() throws IOException{
        chat = new ChatroomGUI(currentUser.getName(), this);
        Thread t = new Thread(currentUser);
        t.start();
        currentUser.setTextAreas(chat.getFriendAreas());
        currentUser.addFriend(friend);
        currentUser.addFriend(f2);
        currentUser.setPopup(chat.getPopup());
    }

    public void connect(int frn) throws IOException {
        if(frn == 0) {
            currentUser.createConnection(friend);
            chat.getListener().setSender(currentUser.getSender());
            chat.setCurrentArea(currentUser.getTextAreas().get(friend.getName()));
            currentUser.getSender().send("CONNECTED");

        } else {
            currentUser.createConnection(f2);
            chat.getListener().setSender(currentUser.getSender());
            chat.setCurrentArea(currentUser.getTextAreas().get(f2.getName()));
            currentUser.getSender().send("CONNECTED");
        }
        
    }

    public User getCurrentUser() {
        return currentUser;
    }
    
}
