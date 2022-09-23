import greenfoot.*;
/**
 * Body of the snake
 * 
 * @author Jesus Cova 
 * @version 1
 */

public class Body extends Actor
{
    int length;
    public static Body body;
    
    /**
     * Constructor for body class
     * 
     * @param pLength integer value for player length
     * @param rotation integer value for player's rotation
     * @param next body object for body
     */
    public Body(int pLength, int rotation, Body nextNode)
    {
        length = pLength;
        setRotation(rotation);
        body = nextNode;
    }
    
    
    /**
     * Called whenever the 'Act' or 'Run' button gets pressed
     */
    public void act() 
    {
        //Removes body once game starts
        if(0==length--&&Head.getAlive())
        getWorld().removeObject(this);
    }
    
    /**
     * Increases body length
     */
    public void increase()
    {
        length += Head.getScale();
    }
}