import greenfoot.*;

/**
 * Class for player paddles
 * 
 * @author Jesus Cova
 * @version 1
 */
public class Players extends Actor
{  
    static int leftSpeed = 5;
    static int rightSpeed = 5;            
    GreenfootImage paddle = new GreenfootImage("paddle.png");
    
    /**
     * Constructor for objects of class Ball, sets player images
     */
    public Players()
    {
        setImage(paddle);
    }
    
    /**
     * Determines if player has reached upper edge of world
     */
    public boolean isAtUpperEdge()
    {
        if (getY() <= 30)
            return true;
        else
            return false;
    }   
    
    /**
     * Determines if player has reached lower edge of world
     */
    public boolean isAtLowerEdge()
    {
        if (getY() >= getWorld().getHeight()- 30)
            return true;
        else
            return false;
    }
}
