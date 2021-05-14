package com.TETOSOFT.tilegame;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.*;

import com.TETOSOFT.graphics.ScreenManager;

public class MenuDrawer 
{   

    private static final int BUTTON_WIDTH = 10;
    private static final int BUTTON_HEIGHT = 10;
    public ScreenManager sc;
    public Rectangle playButton = new Rectangle(50,50,120,120);


    public void update()
    {
        //UPDATE THE START SCREEN
    }


    public void draw(Graphics2D g)
    {    


        Font font = new Font("arial",Font.BOLD,50);
        g.setFont(font);
        g.setColor(Color.white);
        g.drawString("Super Mario",200,100);
        g.draw(playButton);
        // JButton playButton = new JButton("Play");
        // JButton changeButton = new JButton("Change player");
        // JButton exitButton = new JButton("EXIT");
        // playButton.setPreferredSize(new Dimension(100,100));
        // exitButton.setPreferredSize(new Dimension(100,100));
        // JFrame frame = new JFrame();
        // JPanel panel = new JPanel(new GridLayout(6,1));
        // frame.setTitle("SUPER MARIO -- MENU");
        
        // playButton.setBackground(Color.BLUE);
        // changeButton.setBackground(Color.BLUE);
        // exitButton.setBackground(Color.BLUE);
        // frame.setLayout(new FlowLayout());
        // panel.add(playButton);
        // panel.add(changeButton);
        // panel.add(exitButton);
        // frame.add(panel);

        // frame.setSize(new Dimension(800,400));
        // frame.setLocationRelativeTo(null);
        // frame.setResizable(false);
        // frame.setVisible(true);
        // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
    }

    public void handleInput()
    {
        //CHECK FOR INPUT, TRANSITION TO THE RUNNING SCREEN WHEN THE USER CLICKS START
    }

}

