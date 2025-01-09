package chatroom.GUI;

import javax.swing.JLabel;
import javax.swing.Popup;

public class ConnectionPopup {
    private Popup popup;
    private JLabel text;

    public ConnectionPopup(Popup popup, JLabel text) {
        this.text = text;
        this.popup = popup;
    }

    public void show() {
        popup.show();
    }

    public void hide() {
        popup.hide();
    }

    public void setFriend(String name) {
        text.setText(name + " CONNECTED");
    }
}
