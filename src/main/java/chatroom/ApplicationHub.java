package src.main.java.chatroom;

import java.io.IOException;

import src.main.java.chatroom.networking.User;
import src.main.java.chatroom.product.Application;

public class ApplicationHub {
    public static void main(String[] args) throws IOException, InterruptedException {
        User persi = new User("Persi", 1105, "localhost");
        User mari = new User("Mari", 1102, "localhost");
        User brennen = new User("Brennen", 1100, "localhost");

        Application persiApplication = new Application(persi, mari, brennen);
        // Application mariApplication = new Application(mari, persi, brennen);
        // Application brennenApplication = new Application(brennen, persi, mari);
        
    }
}
