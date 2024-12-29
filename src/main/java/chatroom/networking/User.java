package src.main.java.chatroom.networking;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Scanner;

import src.main.java.chatroom.Duplexer;

public class User implements Runnable{
    private String name;
    private int port;
    private String address;
    private HashMap<String, User> friends;
    private Sender sender;


    
    public User(String name, int port, String address) {
        this.name = name;
        this.port = port;
        this.address = address;
        friends = new HashMap<>();
    }


    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getPort() {
        return port;
    }

    public HashMap<String, User> getFriends() {
        return friends;
    }

    public void addFriend(String name, int port, String address) {
        User friend = new User(name, port, address);
        friends.put(name, friend);
    }

    public void addFriend(User friend) {
        friends.put(friend.name, friend);
    }

    public void receiveConnections() throws IOException{
        try(ServerSocket server = new ServerSocket(port)) {
            Socket friendSocket = server.accept();
            Duplexer duplexer = new Duplexer(friendSocket);
            String friendName = duplexer.receive();
            System.out.println("::::::::::::: " + friendName + " ::::::::::::::");
            User friend = friends.get(friendName);
            System.out.println("NEW CONNECTION RECEIVED FROM :: " + friend.name);
            Receiver receiver = new Receiver(duplexer, friend);
            Thread r = new Thread(receiver);
            r.start();
        }
    }


    @Override
    public void run(){
        while (true) {
            try {
                receiveConnections();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        
    }


    public void createConnection(User friend) throws IOException{
        Socket friendSocket = new Socket(friend.address, friend.port);
        Duplexer duplexer = new Duplexer(friendSocket);
        duplexer.send(name);
        Sender sender = new Sender(duplexer, name);
        this.sender = sender;
        // Thread s = new Thread(sender);
        // s.start();
    }

    public static void main(String[] args) throws IOException, InterruptedException{
        User me = new User("Bill", 1105, "localhost");
        
        Thread tM = new Thread(me);
        tM.start();
        User f2 = new User("Ted", 1209, "localhost");
        me.addFriend(f2);
        Thread.sleep(3000);
        me.createConnection(f2);
        Scanner scan = new Scanner(System.in);
        while (true) {
            String msg = scan.nextLine();
            me.sender.send(msg);
        }
    }



   /*
    * Store friends in JSON file? parse on startup

    Maybe no messages if offline
    */
    
}
