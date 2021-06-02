package com.TETOSOFT.tilegame;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.*;

import com.TETOSOFT.graphics.ScreenManager;
// for displaying the documentation
public class DocDrawer 
{   

    private static final int BUTTON_WIDTH = 10;
    private static final int BUTTON_HEIGHT = 10;
    public ScreenManager sc;
    public Rectangle docplayButton,dochomeButton,docexitButton;


    public void update()
    {
        //UPDATE THE START SCREEN
    }


    public void draw(Graphics2D g,int screenWidth,int screenHeight)
    {    
        Font titleFont = new Font("arial",Font.BOLD,50);
        Font buttonFont = new Font("arial",Font.BOLD,20);
        docplayButton = new Rectangle(screenWidth / 2 - 90 ,350,200,50);
        dochomeButton = new Rectangle(screenWidth / 2 - 90 ,420,200,50);
        docexitButton = new Rectangle(screenWidth / 2 - 90 ,490,200,50);
        g.setFont(titleFont);
        g.setColor(Color.white);
        g.clearRect(0,0, screenWidth, screenHeight);
        g.setBackground(Color.white);
        g.drawString("HOW TO PLAY ?",screenWidth / 2 - 195 ,100);
        

        // Setting the font of the button's labels
        g.setFont(buttonFont);
        g.setColor(Color.RED);
        g.drawString("----     Press SPACE to jump     ----",screenWidth / 2 - 160 ,170);
        g.drawString("---- Press RIGHT to move right ----",screenWidth / 2 - 160 ,220);
        g.drawString("----   Press LEFT to move left   ----",screenWidth / 2 - 160 ,270);
        g.drawString("----         Press P to pause        ----",screenWidth / 2 - 160 ,320);
         // Title of play button 
        g.drawString("Play", docplayButton.x+70,docplayButton.y+35);
         // Title of back-to-home button
        g.drawString("Back To Home", dochomeButton.x+30,dochomeButton.y+35);
        // title of exit button
        g.drawString("Exit", docexitButton.x+70,docexitButton.y+35);
        g.draw(docplayButton);
        g.draw(dochomeButton);
        g.draw(docexitButton);
        
    }

    public void handleInput()
    {
        //CHECK FOR INPUT, TRANSITION TO THE RUNNING SCREEN WHEN THE USER CLICKS START
    }

}

