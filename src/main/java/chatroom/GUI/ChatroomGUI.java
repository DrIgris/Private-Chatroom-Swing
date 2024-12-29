package src.main.java.chatroom.GUI;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;


public class ChatroomGUI {
    private JFrame mainFrame;
    private JPanel firstPanel;
    private JPanel secondPanel;
    private JPanel thirdPanel;
    private JPanel logoPanel;




    public ChatroomGUI() {
        try {
            prepareGUI();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ChatroomGUI chatroom = new ChatroomGUI();
    }

    private void prepareGUI() throws IOException {
        mainFrame = new JFrame("Testing");
        mainFrame.setSize(1400, 800);
        mainFrame.setLayout(new GridBagLayout());
        mainFrame.setBackground(new Color(130, 40, 80));
        mainFrame.setLocationRelativeTo(null);

        // JPanel mainPanel = new JPanel();
        // mainPanel.setLayout(new GridBagLayout());
        // mainPanel.setBackground(new Color(10, 50, 30));

        firstPanel = new JPanel();
        secondPanel = new JPanel();
        thirdPanel = new JPanel();
        logoPanel = new JPanel();

        firstPanel.setBackground(new Color(20, 20, 20));
        secondPanel.setBackground(new Color(90, 40, 20));
        thirdPanel.setBackground(new Color(50, 30, 100));

        //logo
        BufferedImage img = ImageIO.read(new File("logoProto.png"));
        logoPanel.setSize(new Dimension(260, 170));    
        Image scaledImg = img.getScaledInstance(logoPanel.getWidth(), logoPanel.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledLogo = new ImageIcon(scaledImg);
        JLabel logo = new JLabel(scaledLogo);
        logoPanel.setLayout(new CardLayout());       
        logoPanel.add(logo);
        
        firstPanel.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx=0;
        gbc.gridy=0;
        gbc.weightx = 1;
        gbc.ipady = 20;
      
        firstPanel.add(new Button("Friend 1"), gbc);
        gbc.gridx=0;
        gbc.gridy=1;
        firstPanel.add(new Button("Friend 2"), gbc);
        gbc.gridx=0;
        gbc.gridy=2;
        firstPanel.add(new Button("Friend 3"), gbc);
        gbc.gridx=0;
        gbc.gridy=3;
        firstPanel.add(new Button("Friend 4"), gbc);

        
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx=0;
        gbc.gridy=0;
        gbc.weighty = 120;
        gbc.weightx = 2.5;
        mainFrame.add(firstPanel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weighty = 1;
        gbc.weightx = 1;
        mainFrame.add(logoPanel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weighty = 3;
        gbc.weightx = 120;
        mainFrame.add(secondPanel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weighty = 1;
        mainFrame.add(thirdPanel, gbc);





        

        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);

            }
        });
        

        // mainFrame.add(mainPanel);
        logo.setSize(logoPanel.getWidth(), logoPanel.getHeight());
        mainFrame.setVisible(true);
    }

}
