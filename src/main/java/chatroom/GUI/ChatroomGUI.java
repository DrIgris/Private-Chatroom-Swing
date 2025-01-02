package src.main.java.chatroom.GUI;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;
import javax.swing.*;

import src.main.java.chatroom.product.Application;


public class ChatroomGUI {
    private final Dimension buttonSize = new Dimension(250, 80);

    private JFrame mainFrame;
    private JPanel friendPanel;
    private JPanel textPanel;
    private JPanel inputPanel;
    private JPanel logoPanel;
    private JTextArea textInput;
    private JTextArea currentArea;
    private UserInputFieldListener senderListener;
    private HashMap<String, JTextArea> friendAreas;
    private GridBagConstraints gbc = new GridBagConstraints();
    private Application application;



    public ChatroomGUI(String name, Application application) {
        this.application = application;
        try {
            prepareGUI(name);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private void prepareGUI(String name) throws IOException {
        mainFrame = new JFrame(name);
        mainFrame.setSize(1400, 800);
        mainFrame.setBackground(new Color(255, 255, 255));
        mainFrame.setLayout(new GridBagLayout());
        mainFrame.setLocationRelativeTo(null);

        // JPanel mainPanel = new JPanel();
        // mainPanel.setLayout(new GridBagLayout());
        // mainPanel.setBackground(new Color(10, 50, 30));

        friendPanel = new JPanel();
        textPanel = new JPanel();
        inputPanel = new JPanel();
        logoPanel = new JPanel();

        friendPanel.setBackground(new Color(255, 255, 255));
        textPanel.setBackground(new Color(255, 255, 255));
        inputPanel.setBackground(new Color(255, 255, 255));
        logoPanel.setBackground(new Color(255, 255, 255));


        //logo
        BufferedImage img = ImageIO.read(new File("logoProto.png"));
        logoPanel.setSize(new Dimension(260, 170));    
        Image scaledImg = img.getScaledInstance(logoPanel.getWidth(), logoPanel.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledLogo = new ImageIcon(scaledImg);
        JLabel logo = new JLabel(scaledLogo);
        logoPanel.setLayout(new CardLayout());       
        logoPanel.add(logo);
        


        friendPanel.setLayout(new BoxLayout(friendPanel, BoxLayout.Y_AXIS));

        
      

        friendAreas = new HashMap<>();
        Button mariButton = new Button("Mari");
        mariButton.setPreferredSize(buttonSize);
        mariButton.setMaximumSize(buttonSize);
        JTextArea mariArea = new JTextArea();
        friendPanel.add(mariButton);
        friendAreas.put("Mari", mariArea);
        
        Button persiButton = new Button("Persi");
        persiButton.setPreferredSize(buttonSize);
        persiButton.setMaximumSize(buttonSize);
        JTextArea persiArea = new JTextArea();
        friendPanel.add(persiButton);
        friendAreas.put("Persi", persiArea);
       
        Button brennenButton = new Button("Brennen");
        brennenButton.setPreferredSize(buttonSize);
        brennenButton.setMaximumSize(buttonSize);
        JTextArea brennenArea = new JTextArea();
        friendPanel.add(brennenButton);
        friendAreas.put("Brennen", brennenArea);

        Button kateButton = new Button("Kate");
        kateButton.setPreferredSize(buttonSize);
        kateButton.setMaximumSize(buttonSize);
        JTextArea kateArea = new JTextArea();
        friendPanel.add(kateButton);
        friendAreas.put("Kate", kateArea);

       

        mariButton.addActionListener(new FriendButtonListener(application));

        persiButton.addActionListener(new FriendButtonListener(application));
        
        brennenButton.addActionListener(new FriendButtonListener(application));

        JScrollPane friendScroll = new JScrollPane(friendPanel);
        
        
        gbc.fill = GridBagConstraints.BOTH;
        gbc.ipady = 0;
        gbc.gridx=0;
        gbc.gridy=0;
        gbc.weighty = 120;
        gbc.weightx = 2.5;
        mainFrame.add(friendScroll, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weighty = 1;
        gbc.weightx = 1;
        mainFrame.add(logoPanel, gbc);

        textPanel.setLayout(new GridBagLayout());

        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weighty = 3;
        gbc.weightx = 120;
        mainFrame.add(textPanel, gbc);

        gbc.insets = new Insets(0, 0, 0, 0);
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weighty = 1;
        gbc.insets = new Insets(5, 5, 5, 5);
        
        mainFrame.add(inputPanel, gbc);


        textInput = new JTextArea();
        textInput.setLineWrap(true);
        textInput.setEditable(true);
        textInput.setWrapStyleWord(true);
        textInput.setFocusable(true);
        senderListener = new UserInputFieldListener(textInput);
        textInput.addKeyListener(senderListener);

        inputPanel.setLayout(new GridBagLayout());
        gbc.insets = new Insets(0, 0, 0, 0);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weighty = 1;
        gbc.weightx = 1;
        inputPanel.add(textInput, gbc);






        

        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);

            }
        });
        

        // mainFrame.add(mainPanel);
        logo.setSize(logoPanel.getWidth(), logoPanel.getHeight());
        mainFrame.setVisible(true);
    }

    public UserInputFieldListener getListener() {   
        return senderListener;
    }

    public HashMap<String, JTextArea> getFriendAreas() {
        return friendAreas;
    }

    public void setCurrentArea(JTextArea currentArea) {
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weighty = 1;
        gbc.weightx = 1;

        textPanel.remove(currentArea);    
        this.currentArea = currentArea;
        textPanel.add(currentArea, gbc);
        currentArea.setEditable(false);
    }

}
