package src.main.java.chatroom.data_handlers;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import src.main.java.chatroom.networking.User;

public class AddFriendParser {    

    public void parseUser(User currentUser) throws FileNotFoundException {
        File file = new File("src/main/java/chatroom/data/friends.csv");
        Scanner s = new Scanner(file);
        s.nextLine();
        while (s.hasNext()) {
            String[] tokens = s.nextLine().split(",");
            User friend = new User(tokens[0], Integer.parseInt(tokens[1]), tokens[2]);
            currentUser.addFriend(friend);
        }
        s.close();
    }
}
