package com.TETOSOFT.tilegame;

import jdk.internal.org.jline.terminal.MouseEvent;

public class MouseInput implements MouseListener{

    public void mousePressed(java.awt.event.MouseEvent e)
    {
        int px = e.getX();
        int py = e.getY();
        /*
        playButton = new Rectangle(screenWidth / 2 - 90 ,200,200,50);
        helpButton = new Rectangle(screenWidth / 2 - 90 ,300,200,50);
        changeButton = new Rectangle(screenWidth / 2 - 90 ,400,200,50);
        exitButton = new Rectangle(screenWidth / 2 - 90 ,500,200,50);
        */
        if(mx >= screenWidth / 2 - 90 && mx <= screenWidth / 2 - 290)
        {
            if(my >= 200 && mx <= 250 )
            {
                
            }
            if(my >= 300 && mx <= 350)
            { 

            }
            if(my >= 400 && mx <= 450)
            { 

            }
            if(my >= 500 && mx <= 550)
            {

            }

        }
        
    }

    
}
