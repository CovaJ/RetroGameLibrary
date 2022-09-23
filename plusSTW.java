import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Button where user can increase score to win value
 * 
 * @author Jesus Cova
 * @version 1
 */
public class plusSTW extends Buttons
{   
    GreenfootImage plusstw = new GreenfootImage("plusstw.png"); // The image for the class plusSTW.
    
    /**
     * Constructor for objects of class plusSTW, sets button image
     */
    public plusSTW()
    {
        setImage(plusstw);            
    }
    
    /**
     * This method is called whenever the 'Act' or 'Run' button gets pressed
     */
    public void act() 
    {
        clicked();
    }  
    
    /**
     * If the button is being clicked, it increases the score to win value by 1
     */
    public void clicked()
    {
        if (Greenfoot.mouseClicked(this))
        {
            STW.STW = STW.STW + 1;
        }
    }
}

