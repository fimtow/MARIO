package com.TETOSOFT.tilegame;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.*;

import com.TETOSOFT.graphics.ScreenManager;

public class MenuDrawer {

    private static final int BUTTON_WIDTH = 10;
    private static final int BUTTON_HEIGHT = 10;
    public ScreenManager sc;

    //private static final Color BACKGROUND_COLOR = Color.WHITE;

    public void draw()
    {
        JButton playButton = new JButton("Play");
        JButton exitButton = new JButton("EXIT");
        JFrame frame = new JFrame();
        JPanel panel = new JPanel(new GridLayout(2,1));
        frame.setLayout(new FlowLayout());
        panel.add(playButton);
        panel.add(exitButton);
        frame.add(panel);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
    }


    
}
