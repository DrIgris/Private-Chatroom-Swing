package chatroom.GUI;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextArea;

import chatroom.networking.Sender;



public class UserInputFieldListener implements KeyListener{

    private JTextArea textArea;
    private Sender sender;

    public Sender getSender() {
        return sender;
    }

    public void setSender(Sender sender) {
        this.sender = sender;
    }

    public UserInputFieldListener(JTextArea textArea) {
        this.textArea = textArea;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_ENTER) {
            String text = textArea.getText();
            sender.send(text);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_ENTER) {
            textArea.setText("");
            textArea.setCaretPosition(0);
        }
        
        
    }
}