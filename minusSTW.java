import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Button where user can decrease score to win value
 * 
 * @author Jesus Cova
 * @version 1
 */
public class minusSTW extends Buttons
{   
    GreenfootImage minusstw = new GreenfootImage("minusstw.png"); // The image for the class minusSTW.
    
    /**
     * Constructor for objects of class minusSTW, sets button image
     */
    public minusSTW()
    {
        setImage(minusstw);        
    }
    
    /**
     * This method is called whenever the 'Act' or 'Run' button gets pressed
     */
    public void act() 
    {
        clicked();
    }    
    
    /**
     * If the button is being clicked, it decreases the score to win by 1
     */
    public void clicked()
    {
        if (Greenfoot.mouseClicked(this))
        {
            STW.STW = STW.STW - 1;
        }
    }
}
