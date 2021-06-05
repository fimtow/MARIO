package com.TETOSOFT.tilegame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import com.TETOSOFT.graphics.ScreenManager;

public class GameOver {

    private static final int BUTTON_WIDTH = 10;
    private static final int BUTTON_HEIGHT = 10;
    public ScreenManager sc;
    public Rectangle exitButton,rejouerButton;
    
    public int score;
    
    public GameOver(int score) {
    	this.score = score;
    }


    public void update()
    {
        //UPDATE THE START SCREEN
    }


    public void draw(Graphics2D g,int screenWidth,int screenHeight)
    {    
        Font titleFont = new Font("arial",Font.BOLD,50);
        Font buttonFont = new Font("arial",Font.BOLD,20);
        Font scoreFont = new Font("arial", Font.PLAIN , 30);
        
        exitButton = new Rectangle(screenWidth / 2 - 90 ,200,200,50);
        rejouerButton = new Rectangle(screenWidth / 2 - 90 ,300,200,50);
       
        //Title
        g.setFont(titleFont);
        g.setColor(Color.red);
        g.drawString("GameOver",screenWidth / 2 - 120 ,120); 
        
        //Score
        g.setFont(scoreFont);
        g.setColor(Color.white);
        g.drawString("Score: " + this.score, screenWidth - 170 , 60);
        
        // Setting the font of the button's labels
        g.setFont(buttonFont);
        g.setColor(Color.RED);
         // Title of play button 
        g.drawString("Exit", exitButton.x+70,exitButton.y+35);
        // title of help button 
        g.drawString("Rejouer", rejouerButton.x+60,rejouerButton.y+35);
        
        g.draw(rejouerButton);
        g.draw(exitButton);
        
    }

    public void handleInput()
    {
        //CHECK FOR INPUT, TRANSITION TO THE RUNNING SCREEN WHEN THE USER CLICKS START
    }

}
