package view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class mainMenu {
    
    private JFrame frame;

    public mainMenu() {
        showMainMenu();

    }

    public void showMainMenu() {

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();

        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;

        final int FRAME_WIDTH = 300;
        final int FRAME_HEIGHT = 400;

        int start_x = screenWidth / 2 - (FRAME_WIDTH / 2);
        int start_y = screenHeight / 2 - (FRAME_HEIGHT / 2);
        
        frame = new JFrame("Main Menu");
        frame.setBounds(start_x, start_y, FRAME_WIDTH, FRAME_HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0, 0, FRAME_WIDTH, FRAME_HEIGHT);

        JLabel title = new JLabel("PEREKAMAN DATA");
        title.setBounds(30, 10, 300, 50);
        title.setFont(new Font("SansSerif", Font.BOLD, 24));
        panel.add(title);

        JLabel title2 = new JLabel("E-KTP");
        title2.setBounds(105, 50, 100, 50);
        title2.setFont(new Font("SansSerif", Font.BOLD, 24));
        panel.add(title2);

        JButton perekamanBtn = new JButton("PEREKAMAN");
        perekamanBtn.setBounds(10, 130, 260, 50);
        panel.add(perekamanBtn);

        perekamanBtn.addActionListener(e -> {
            frame.dispose();
            new View(1, null);
        });

        JButton pencarianBtn = new JButton("PENCARIAN");
        pencarianBtn.setBounds(10, 200, 260, 50);
        panel.add(pencarianBtn);

        pencarianBtn.addActionListener(e -> {
            frame.dispose();
            new pencarianForm();
        });

        JButton exitBtn = new JButton("EXIT");
        exitBtn.setBounds(10, 270, 260, 50);
        panel.add(exitBtn);

        exitBtn.addActionListener(e -> {
            frame.dispose();
        });

        frame.add(panel);
        frame.setVisible(true);

    }

}