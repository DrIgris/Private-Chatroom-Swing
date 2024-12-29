package src.main.java.chatroom;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Duplexer implements AutoCloseable {

    private final Socket socket;
    private final PrintWriter writer;
    private final Scanner scanner;

    public Duplexer(Socket socket) throws IOException {
        this.socket = socket;
        this.writer = new PrintWriter(socket.getOutputStream(), true);
        this.scanner = new Scanner(socket.getInputStream());
    }

    public void send(String message) {
        writer.println(message);
    }

    public String receive() {
        String message = scanner.nextLine();
        return message;
    }

    @Override
    public void close() {
        try {
            writer.close();
            scanner.close();
            socket.close();
        } catch (IOException e) {
        }
    }

}

