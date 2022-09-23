import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Play button for menu screen
 * 
 * @author Jesus Cova 
 * @version 1
 */
public class PlaySnake extends ButtonSnake
{
    GreenfootImage play = new GreenfootImage("play.png"); // The image for the class PLAY.
    
    /**
     * Constructor for objects of class PLAY.
     */
    public PlaySnake()
    {   
        setImage(play);
    }
    
    /**
     * This method is called whenever the 'Act' or 'Run' button gets pressed.
     */
    public void act() 
    {
        clicked();
        Greenfoot.setSpeed(31);
    }
    
    /**
     * If the button is being clicked, it starts the game.
     */
    public void clicked()
    {
        if (Greenfoot.mouseClicked(this))
        {
            Greenfoot.setWorld(new SnakeWorld());
        }
    }  
}
