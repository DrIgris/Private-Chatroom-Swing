package src.main.java.chatroom.GUI;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.Popup;
import javax.swing.PopupFactory;

public class PopupHandler implements Runnable{
    private PopupFactory pf;
    private JLabel popupLabel;
    private Popup popup;

    public PopupHandler(ChatroomGUI chat, String name) {

        pf = new PopupFactory();

        popupLabel = new JLabel();
        popupLabel.setPreferredSize(new Dimension(220, 70));
        popupLabel.setHorizontalAlignment(JLabel.CENTER);
        popupLabel.setText(name + " CONNECTED");

        popup = pf.getPopup(chat.getMainFrame(), popupLabel, 30, 60);
    }

    @Override
    public void run() {
        popup.show();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        popup.hide();
    }
}
