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
    public Rectangle playButton,helpButton,changeButton,exitButton;


    public void update()
    {
        //UPDATE THE START SCREEN
    }


    public void draw(Graphics2D g,int screenWidth,int screenHeight)
    {    
        Font titleFont = new Font("arial",Font.BOLD,50);
        Font buttonFont = new Font("arial",Font.BOLD,20);
        
        playButton = new Rectangle(screenWidth / 2 - 90 ,200,200,50);
        helpButton = new Rectangle(screenWidth / 2 - 90 ,300,200,50);
        changeButton = new Rectangle(screenWidth / 2 - 90 ,400,200,50);
        exitButton = new Rectangle(screenWidth / 2 - 90 ,500,200,50);
        g.setFont(titleFont);
        g.setColor(Color.white);
        g.drawString("Super Mario",screenWidth / 2 - 150 ,100);
        // Setting the font of the button's labels
        g.setFont(buttonFont);
        g.setColor(Color.RED);
         // Title of play button 
        g.drawString("Play", playButton.x+70,playButton.y+35);
        // title of help button 
        g.drawString("Change the player", changeButton.x+10,changeButton.y+35);
        // title of help button 
        g.drawString("Help", helpButton.x+70,helpButton.y+35);
        // title of exit button
        g.drawString("Exit", exitButton.x+70,exitButton.y+35);

        g.draw(playButton);
        g.draw(changeButton);
        g.draw(helpButton);
        g.draw(exitButton);
        
    }

    public void handleInput()
    {
        //CHECK FOR INPUT, TRANSITION TO THE RUNNING SCREEN WHEN THE USER CLICKS START
    }

}

