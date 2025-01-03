package src.main.java.chatroom.product;

import java.io.IOException;

import src.main.java.chatroom.GUI.ChatroomGUI;
import src.main.java.chatroom.data_handlers.AddFriendParser;
import src.main.java.chatroom.networking.User;

public class Application {
    private User currentUser;
    private ChatroomGUI chat;
    //Normally have UserList for friends

    public Application(User currentUser) throws IOException {
        this.currentUser = currentUser;
        setup();
    }
    

    public void setup() throws IOException{
        AddFriendParser friendParser = new AddFriendParser();
        friendParser.parseUser(currentUser);
        chat = new ChatroomGUI(currentUser.getName(), this);
        Thread t = new Thread(currentUser);
        t.start();
        currentUser.setTextAreas(chat.getFriendAreas());
        currentUser.setChat(chat);
        
        
    }

    public void connect(String name) throws IOException {
        User friend = currentUser.getFriends().get(name);
        currentUser.createConnection(friend);
        chat.getListener().setSender(currentUser.getSender());
        chat.setCurrentArea(currentUser.getTextAreas().get(friend.getName()));
        currentUser.getSender().send("CONNECTED");
        
    }

    public User getCurrentUser() {
        return currentUser;
    }
    
}
