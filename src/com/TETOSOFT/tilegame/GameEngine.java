package com.TETOSOFT.tilegame;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JTextField;
import java.util.Iterator;


import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.TETOSOFT.graphics.*;
import com.TETOSOFT.input.*;
import com.TETOSOFT.test.Background;
import com.TETOSOFT.test.GameCore;
import com.TETOSOFT.tilegame.sprites.*;


import com.TETOSOFT.graphics.Sprite;
import com.TETOSOFT.input.GameAction;
import com.TETOSOFT.input.InputManager;
import com.TETOSOFT.test.GameCore;
import com.TETOSOFT.tilegame.sprites.Creature;
import com.TETOSOFT.tilegame.sprites.Player;
import com.TETOSOFT.tilegame.sprites.PowerUp;

/**
 * GameManager manages all parts of the game.
 */
public class GameEngine extends GameCore 
{
    
    public static void main(String[] args) 

    {
        new GameEngine().run();
    }
    
    
    public static final float GRAVITY = 0.002f;
    private Point pointCache = new Point();
    private TileMap map;
    private MapLoader mapLoader;
    private InputManager inputManager;
    private TileMapDrawer drawer;

    
    private GameAction restart;


    private GameAction moveLeft;
    private GameAction moveRight;
    private GameAction jump;
    private GameAction exit;
    private GameAction pause;
    private GameAction start;
    private GameAction change_backg;
    private GameAction mouseClicked;
    private GameAction back1;
    private GameAction back2;
    private GameAction back3;
    private GameAction back4;
    private int collectedStars=0;
    private int numLives=6;
    private int numPauses = 0;
    private boolean isPausedPressed = false;
    private String background="background.jpg";

    public void init()
    {
        super.init();
        
        //set up input manager
        initInput();
        
        // start resource manager
        mapLoader = new MapLoader(screen.getFullScreenWindow().getGraphicsConfiguration());
        
        // load resources
        drawer = new TileMapDrawer();
        drawer.setBackground(mapLoader.loadImage(background));
        
        // load first map
        map = mapLoader.loadNextMap();


    }
    
    
    /**
     * Closes any resurces used by the GameManager.
     */
    public void stop() {
        super.stop();
        
    }
    
    public void pause() {
        super.pause();
        isPausedPressed = true;
        
    }
    
    private void initInput() {
        restart = new GameAction("restart");
        moveLeft = new GameAction("moveLeft");
        moveRight = new GameAction("moveRight");
        jump = new GameAction("jump", GameAction.DETECT_INITAL_PRESS_ONLY);
        exit = new GameAction("exit",GameAction.DETECT_INITAL_PRESS_ONLY);
        pause = new GameAction("pause",GameAction.DETECT_INITAL_PRESS_ONLY);
        start = new GameAction("start",GameAction.DETECT_INITAL_PRESS_ONLY);
change_backg =new GameAction("change background",GameAction.DETECT_INITAL_PRESS_ONLY);
back1 =new GameAction("background",GameAction.DETECT_INITAL_PRESS_ONLY);
back2 =new GameAction("background",GameAction.DETECT_INITAL_PRESS_ONLY);
back3 =new GameAction("background",GameAction.DETECT_INITAL_PRESS_ONLY);
back4=new GameAction("background",GameAction.DETECT_INITAL_PRESS_ONLY);
        mouseClicked = new GameAction("mouseClicked",GameAction.DETECT_INITAL_PRESS_ONLY);
        inputManager = new InputManager(screen.getFullScreenWindow());
        //inputManager.setCursor(InputManager.INVISIBLE_CURSOR);
        
        inputManager.mapToKey(moveLeft, KeyEvent.VK_LEFT);
        inputManager.mapToKey(moveRight, KeyEvent.VK_RIGHT);
        inputManager.mapToKey(jump, KeyEvent.VK_SPACE);
        inputManager.mapToKey(exit, KeyEvent.VK_ESCAPE);
        inputManager.mapToKey(pause, KeyEvent.VK_P);
        inputManager.mapToKey(start, KeyEvent.VK_S);
        inputManager.mapToKey(change_backg, KeyEvent.VK_C);
        inputManager.mapToKey(back1, KeyEvent.VK_NUMPAD1);
        inputManager.mapToKey(back2, KeyEvent.VK_NUMPAD2);
        inputManager.mapToKey(back3, KeyEvent.VK_NUMPAD3);
        inputManager.mapToKey(back4, KeyEvent.VK_NUMPAD4);
        inputManager.mapToMouse(mouseClicked, MouseEvent.BUTTON3);
        inputManager.mapToKey(restart, KeyEvent.VK_R);

    }
    
    
    private void checkInput(long elapsedTime) 
    {
        
        if (exit.isPressed()) {
            stop();
        }
        
        if(restart.isPressed()) {
        	setScene(-1);
        	numLives = 6;
        	map = mapLoader.reloadMap();
        } 
        
        if (pause.isPressed()){
        	numPauses++;
            if(isPaused())
                unPause();
            else if(getScene() == -1)
                pause();
        }
        
        if (start.isPressed()){
            if(isPaused())
            	unPause();
            
        }
        if (change_backg.isPressed()){
        	 JFrame f = new JFrame("les background");
			
			    f.getContentPane().add(new Background());
			    f.setSize(1024,758);
			    f.setVisible(true);
			    if(back1.isPressed())
				{background="background1.jpg";
				mapLoader = new MapLoader(screen.getFullScreenWindow().getGraphicsConfiguration());
				drawer = new TileMapDrawer();
				drawer.setBackground(mapLoader.loadImage("background1.jpg"));
				 map = mapLoader.loadNextMap();}
			    if(back2.isPressed())
				{				mapLoader = new MapLoader(screen.getFullScreenWindow().getGraphicsConfiguration());

				drawer = new TileMapDrawer();
				background="background2.jpg";
				 map = mapLoader.loadNextMap();}
				
			if(back3.isPressed())
				{				mapLoader = new MapLoader(screen.getFullScreenWindow().getGraphicsConfiguration());

				drawer = new TileMapDrawer();
				background="background3.jpg";
				 drawer.setBackground(mapLoader.loadImage(background));
				}
			if(back4.isPressed())
				{				mapLoader = new MapLoader(screen.getFullScreenWindow().getGraphicsConfiguration());

				drawer = new TileMapDrawer();
				background="background4.jpg";
				 drawer.setBackground(mapLoader.loadImage(background));
				 map = mapLoader.loadNextMap();}
			
			  
          
        }
        if(back1.isPressed())
		{				mapLoader = new MapLoader(screen.getFullScreenWindow().getGraphicsConfiguration());

		background="background1.jpg";
		drawer = new TileMapDrawer();
		drawer.setBackground(mapLoader.loadImage("background1.jpg"));}
        if(back2.isPressed())
			{				mapLoader = new MapLoader(screen.getFullScreenWindow().getGraphicsConfiguration());

			drawer = new TileMapDrawer();
			background="background2.jpg";
			 map = mapLoader.loadNextMap();}
			
		if(back3.isPressed())
			{				mapLoader = new MapLoader(screen.getFullScreenWindow().getGraphicsConfiguration());

			drawer = new TileMapDrawer();
			background="background3.jpg";
			 drawer.setBackground(mapLoader.loadImage(background));
			 map = mapLoader.loadNextMap();}
		if(back4.isPressed())
			{				mapLoader = new MapLoader(screen.getFullScreenWindow().getGraphicsConfiguration());

			drawer = new TileMapDrawer();
			background="background4.jpg";
			 drawer.setBackground(mapLoader.loadImage(background));
			 map = mapLoader.loadNextMap();}
       
        if(mouseClicked.isPressed())
        {   
        	if(getScene()==2) menuAction(); //if it's displaying the menu
        	else if(getScene()==1)GameOverAction();
        	else if (getScene()==3) docAction(); //if it's displaying the documentation 
        }

        Player player = (Player)map.getPlayer();
        if (player.isAlive()) 
        {
            float velocityX = 0;
            if (moveLeft.isPressed()) 
            {
                velocityX-=player.getMaxSpeed();
            }
            if (moveRight.isPressed()) {
                velocityX+=player.getMaxSpeed();
            }
            if (jump.isPressed()) {
                player.jump(false);
            }
            player.setVelocityX(velocityX);
        }
        
    }
    
    
    public void draw(Graphics2D g) {
        switch (getScene()) {

            case 0:
                // is paused
            	if (isPausedPressed && numPauses == 1) {
            		System.out.println("dialog");
    	        	try {
    					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    				} catch (ClassNotFoundException e) {
    					e.printStackTrace();
    				} catch (InstantiationException e) {
    					e.printStackTrace();
    				} catch (IllegalAccessException e) {
    					e.printStackTrace();
    				} catch (UnsupportedLookAndFeelException e) {
    					e.printStackTrace();
    				}
    	    
    		        ImageIcon icon = new ImageIcon("images/smurf.png");
    		        Image image = icon.getImage();
    	
    		        Image newimg = image.getScaledInstance(100, 100,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
    		        icon = new ImageIcon(newimg); 
    		        JOptionPane.showInternalMessageDialog(
    		                 screen.getFullScreenWindow().getContentPane(),
    		                 "Press P again to unpause and R to restart.\nPress Enter to dismiss the dialog.",
    		                 "Pause Instructions",
    		                 JOptionPane.INFORMATION_MESSAGE,
    		                 icon);
    	
    			}
            	//setScene(7); 
            	//Cannot change the scene because isPaused() tests on value 0
            	isPausedPressed = false;
                break;


            case 3:
            	new DocDrawer().draw(g,screen.getWidth(),screen.getHeight());

                break;
            case 1:
            	//to clear the screen
                 g.clearRect(0, 0, screen.getWidth(), screen.getHeight());
                //GameOver
                 new GameOver(this.collectedStars).draw(g,screen.getWidth(),screen.getHeight());
                break;
            // to add a new scene : add a new case in draw() and update with tha same scene number


            case 2:
            	//to clear the screen
            	g.clearRect(0, 0, screen.getWidth(), screen.getHeight());
            	//to draw the documentation
                new MenuDrawer().draw(g,screen.getWidth(),screen.getHeight());
                break;

            default:
                drawer.draw(g, map, screen.getWidth(), screen.getHeight());
                g.setColor(Color.WHITE);
                g.drawString("Press ESC for EXIT.",10.0f,20.0f);
                g.setColor(Color.GREEN);
                g.drawString("Coins: "+collectedStars,300.0f,20.0f);
                g.setColor(Color.YELLOW);
                g.drawString("Lives: "+(numLives),500.0f,20.0f );
                g.setColor(Color.WHITE);
                g.drawString("Home: "+mapLoader.currentMap,700.0f,20.0f);
                break;
        }
    }
    
    
    /**
     * Gets the current map.
     */
    public TileMap getMap() {
        return map;
    }
    
    /**
     * Gets the tile that a Sprites collides with. Only the
     * Sprite's X or Y should be changed, not both. Returns null
     * if no collision is detected.
     */
    public Point getTileCollision(Sprite sprite, float newX, float newY) 
    {
        float fromX = Math.min(sprite.getX(), newX);
        float fromY = Math.min(sprite.getY(), newY);
        float toX = Math.max(sprite.getX(), newX);
        float toY = Math.max(sprite.getY(), newY);
        
        // get the tile locations
        int fromTileX = TileMapDrawer.pixelsToTiles(fromX);
        int fromTileY = TileMapDrawer.pixelsToTiles(fromY);
        int toTileX = TileMapDrawer.pixelsToTiles(
                toX + sprite.getWidth() - 1);
        int toTileY = TileMapDrawer.pixelsToTiles(
                toY + sprite.getHeight() - 1);
        
        // check each tile for a collision
        for (int x=fromTileX; x<=toTileX; x++) {
            for (int y=fromTileY; y<=toTileY; y++) {
                if (x < 0 || x >= map.getWidth() ||
                        map.getTile(x, y) != null) {
                    // collision found, return the tile
                    pointCache.setLocation(x, y);
                    return pointCache;
                }
            }
        }
        
        // no collision found
        return null;
    }
    
    
    /**
     * Checks if two Sprites collide with one another. Returns
     * false if the two Sprites are the same. Returns false if
     * one of the Sprites is a Creature that is not alive.
     */
    public boolean isCollision(Sprite s1, Sprite s2) {
        // if the Sprites are the same, return false
        if (s1 == s2) {
            return false;
        }
        
        // if one of the Sprites is a dead Creature, return false
        if (s1 instanceof Creature && !((Creature)s1).isAlive()) {
            return false;
        }
        if (s2 instanceof Creature && !((Creature)s2).isAlive()) {
            return false;
        }
        
        // get the pixel location of the Sprites
        int s1x = Math.round(s1.getX());
        int s1y = Math.round(s1.getY());
        int s2x = Math.round(s2.getX());
        int s2y = Math.round(s2.getY());
        
        // check if the two sprites' boundaries intersect
        return (s1x < s2x + s2.getWidth() &&
                s2x < s1x + s1.getWidth() &&
                s1y < s2y + s2.getHeight() &&
                s2y < s1y + s1.getHeight());
    }
    
    
    /**
     * Gets the Sprite that collides with the specified Sprite,
     * or null if no Sprite collides with the specified Sprite.
     */
    public Sprite getSpriteCollision(Sprite sprite) {
        
        // run through the list of Sprites
        Iterator i = map.getSprites();
        while (i.hasNext()) {
            Sprite otherSprite = (Sprite)i.next();
            if (isCollision(sprite, otherSprite)) {
                // collision found, return the Sprite
                return otherSprite;
            }
        }
        
        // no collision found
        return null;
    }
    
    
    /**
     * Updates Animation, position, and velocity of all Sprites
     * in the current map.
     */
    public void update(long elapsedTime) {
        Creature player = (Creature)map.getPlayer();
        
        
        // player is dead! start map over
        if (player.getState() == Creature.STATE_DEAD) {
            map = mapLoader.reloadMap();
            return;
        }
        
        // get keyboard/mouse input
        checkInput(elapsedTime);
        
        switch (getScene()) {
            case 0:
                // is paused
                break;   
                
            case 1:
            	
                break;
            default:
                        // update player
                        updateCreature(player, elapsedTime);
                        player.update(elapsedTime);
                        
                        // update other sprites
                        Iterator i = map.getSprites();
                        while (i.hasNext()) {
                            Sprite sprite = (Sprite)i.next();
                            if (sprite instanceof Creature) {
                                Creature creature = (Creature)sprite;
                                if (creature.getState() == Creature.STATE_DEAD) {
                                    i.remove();
                                } else {
                                    updateCreature(creature, elapsedTime);
                                }
                            }
                            // normal update
                            sprite.update(elapsedTime);
                        }
                break;
        }
    }
    
    
    /**
     * Updates the creature, applying gravity for creatures that
     * aren't flying, and checks collisions.
     */
    private void updateCreature(Creature creature,
            long elapsedTime) {
        
        // apply gravity
        if (!creature.isFlying()) {
            creature.setVelocityY(creature.getVelocityY() +
                    GRAVITY * elapsedTime);
        }
        
        // change x
        float dx = creature.getVelocityX();
        float oldX = creature.getX();
        float newX = oldX + dx * elapsedTime;
        Point tile =
                getTileCollision(creature, newX, creature.getY());
        if (tile == null) {
            creature.setX(newX);
        } else {
            // line up with the tile boundary
            if (dx > 0) {
                creature.setX(
                        TileMapDrawer.tilesToPixels(tile.x) -
                        creature.getWidth());
            } else if (dx < 0) {
                creature.setX(
                        TileMapDrawer.tilesToPixels(tile.x + 1));
            }
            creature.collideHorizontal();
        }
        if (creature instanceof Player) {
            checkPlayerCollision((Player)creature, false);
        }
        
        // change y
        float dy = creature.getVelocityY();
        float oldY = creature.getY();
        float newY = oldY + dy * elapsedTime;
        tile = getTileCollision(creature, creature.getX(), newY);
        if (tile == null) {
            creature.setY(newY);
        } else {
            // line up with the tile boundary
            if (dy > 0) {
                creature.setY(
                        TileMapDrawer.tilesToPixels(tile.y) -
                        creature.getHeight());
            } else if (dy < 0) {
                creature.setY(
                        TileMapDrawer.tilesToPixels(tile.y + 1));
            }
            creature.collideVertical();
        }
        if (creature instanceof Player) {
            boolean canKill = (oldY < creature.getY());
            checkPlayerCollision((Player)creature, canKill);
        }
        
    }
    
    
    /**
     * Checks for Player collision with other Sprites. If
     * canKill is true, collisions with Creatures will kill
     * them.
     */
    public void checkPlayerCollision(Player player,
            boolean canKill) {
        if (!player.isAlive()) {
            return;
        }
        
        // check for player collision with other sprites
        Sprite collisionSprite = getSpriteCollision(player);
        if (collisionSprite instanceof PowerUp) {
            acquirePowerUp((PowerUp)collisionSprite);
        } else if (collisionSprite instanceof Creature) {
            Creature badguy = (Creature)collisionSprite;
            if (canKill) {
                // kill the badguy and make player bounce
                badguy.setState(Creature.STATE_DYING);
                player.setY(badguy.getY() - player.getHeight());
                player.jump(true);
            } else {
                // player dies!
                player.setState(Creature.STATE_DYING);
                numLives--;
                if(numLives==0) {
                    setScene(1);
                }
            }
        }
    }
    
    
    /**
     * Gives the player the speicifed power up and removes it
     * from the map.
     */
    public void acquirePowerUp(PowerUp powerUp) {
        // remove it from the map
        map.removeSprite(powerUp);
        
        if (powerUp instanceof PowerUp.Star) {
            // do something here, like give the player points
            collectedStars++;
            if(collectedStars==100) 
            {
                numLives++;
                collectedStars=0;
            }
            
        } else if (powerUp instanceof PowerUp.Music) {
            // change the music
            
        } else if (powerUp instanceof PowerUp.Goal) {
            // advance to next map      
      
            map = mapLoader.loadNextMap();
            
        }
    }


    public void menuAction()
    {   
        int mx = inputManager.getMouseX();
        int my =  inputManager.getMouseY();
        int screenWidth = screen.getWidth();
        /*
        playButton = new Rectangle(screenWidth / 2 - 90 ,200,200,50);
        helpButton = new Rectangle(screenWidth / 2 - 90 ,300,200,50);
        changeButton = new Rectangle(screenWidth / 2 - 90 ,400,200,50);
        exitButton = new Rectangle(screenWidth / 2 - 90 ,500,200,50);
        */
        if(mx >= screenWidth / 2 - 90 && mx <= screenWidth / 2 +110)
        {
            if(my >= 200 && my <= 250 )
            {
                     setScene(-1);
            }
            
            if(my >= 300 && my <= 350)
            { 
                   //help pressed
                    setScene(3); 
            }
            
            if(my >= 400 && my <= 450)
            { 
                //Change pressed
            }
            if(my >= 500 && my <= 550)
            {
                //Exit pressed
                stop();
            }

        }
        
        
    }
 public void docAction() {
         int mx1 = inputManager.getMouseX();
         int my1 =  inputManager.getMouseY();
         int screenWidth1 = screen.getWidth();     
     if(mx1 >= screenWidth1 / 2 - 90 && mx1 <= screenWidth1 / 2 +110)
     {
     	
         if(my1 >= 350 && my1 <= 400 )
         {
             setScene(-1);
             
         }
         if(my1 >= 420 && my1 <= 470)
         { 
        	 setScene(2);
         }

         if(my1 >= 490 && my1 <= 540)
         {
             //Exit pressed
             stop();
         }

     }
 
 }


 
 
 public void GameOverAction()
 {   
     int mx2 = inputManager.getMouseX();
     int my2 =  inputManager.getMouseY();
     int screenWidth2 = screen.getWidth();
    
     if(mx2 >= screenWidth2 / 2 - 90 && mx2 <= screenWidth2 / 2 +110)
     {
         if(my2 >= 200 && my2 <= 250 )
         {
         		 stop();
         }
         
         if(my2 >= 300 && my2 <= 350)
         { 
         	
                 new GameEngine().run();
         }
     }
     
 }

    
      
}