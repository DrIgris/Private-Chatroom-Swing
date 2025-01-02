package src.main.java.chatroom.GUI;


public class PopupHandler implements Runnable{
    private ConnectionPopup popup;
    private String name;

    public PopupHandler(ConnectionPopup popup, String name) {
        this.popup = popup;
        this.name = name;
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
