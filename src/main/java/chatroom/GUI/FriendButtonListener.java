package src.main.java.chatroom.GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import src.main.java.chatroom.product.Application;

public class FriendButtonListener implements ActionListener{

    private Application application;

    public FriendButtonListener(Application application) {
        this.application = application;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            application.connect(0);
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }
    
}
