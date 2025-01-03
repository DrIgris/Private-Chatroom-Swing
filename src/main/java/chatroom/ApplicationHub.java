package src.main.java.chatroom;

import java.io.IOException;

import src.main.java.chatroom.networking.User;
import src.main.java.chatroom.product.Application;

public class ApplicationHub {
    public static void main(String[] args) throws IOException, InterruptedException {
        User persi = new User("Persi", 1100, "localhost");
        User mari = new User("Mari", 1101, "localhost");
        User brennen = new User("Brennen", 1103, "localhost");

        // Application persiApplication = new Application(persi);
        // Application mariApplication = new Application(mari);
        // Application brennenApplication = new Application(brennen);
        
    }
}
