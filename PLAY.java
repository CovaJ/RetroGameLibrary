import greenfoot.*;

/**
 * Button to start game
 * 
 * @author Jesus Cova
 * @version 1
 */
public class PLAY extends Buttons
{   
    GreenfootImage play = new GreenfootImage("play.png"); 
    
    /**
     * Constructor for objects of class PLAY, sets image
     */
    public PLAY()
    {   
        setImage(play);
    }
    
    /**
     * This method is called whenever the 'Act' or 'Run' button gets pressed.
     */
    public void act() 
    {
        clicked();
        Greenfoot.setSpeed(51);
    }
    
    /**
     * If the button is being clicked, it starts the game
     */
    public void clicked()
    {
        if (Greenfoot.mouseClicked(this))
        {
            Greenfoot.setWorld(new PongWorld());
        }
    }
}
