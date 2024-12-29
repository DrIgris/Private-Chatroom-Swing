
/*
 * TEST FILE FOR NETWORKING CONNECTIONS, DO NOT MODIFY
 */





package src.main.java.chatroom.networking;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Scanner;

import src.main.java.chatroom.Duplexer;

public class User2 implements Runnable{
    private String name;
    private int port;
    private String address;
    private HashMap<String, User2> friends;
    private Sender sender;


    
    public User2(String name, int port, String address) {
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

    public HashMap<String, User2> getFriends() {
        return friends;
    }

    public void addFriend(String name, int port, String address) {
        User2 friend = new User2(name, port, address);
        friends.put(name, friend);
    }

    public void addFriend(User2 friend) {
        friends.put(friend.name, friend);
    }

    public void receiveConnections() throws IOException{
        try(ServerSocket server = new ServerSocket(port)) {
            Socket friendSocket = server.accept();
            Duplexer duplexer = new Duplexer(friendSocket);
            String friendName = duplexer.receive();
            System.out.println("::::::::::::: " + friendName + " ::::::::::::::");
            User2 friend = friends.get(friendName);
            System.out.println("NEW CONNECTION RECEIVED FROM :: " + friendName);
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


    public void createConnection(User2 friend) throws IOException{
        Socket friendSocket = new Socket(friend.address, friend.port);
        Duplexer duplexer = new Duplexer(friendSocket);
        duplexer.send(name);
        Sender sender = new Sender(duplexer, name);
        this.sender = sender;
        // Thread s = new Thread(sender);
        // s.start();
    }

    public static void main(String[] args) throws IOException, InterruptedException{
        User2 me = new User2("Ted", 1209, "localhost");
        Thread tM = new Thread(me);
        tM.start();
        User2 f2 = new User2("Bill", 1105, "localhost");
        me.addFriend(f2);
        Thread.sleep(2000);
        me.createConnection(f2);
        Scanner scan = new Scanner(System.in);
        while (true) {
            String msg = scan.nextLine();
            me.sender.send(msg);
        }
    }



 
    
}
