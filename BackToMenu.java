import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Button to return to menu
 * 
 * @author Jesus Cova
 * @version 1
 */
public class BackToMenu extends Buttons
{   
    GreenfootImage backtomenu = new GreenfootImage("backtomenu.png"); // The image for the class BACKTOMENU.
    
    /**
     * Constructor for objects of class BackToMenu, sets image
     */
    public BackToMenu()
    {
        setImage(backtomenu);
    }
    
    /**
     * This method is called whenever the 'Act' or 'Run' button gets pressed
     */
    public void act() 
    {
        clicked();
    }    
    
    /**
     * If the button is being clicked, it gets you back to the menu
     */
    public void clicked()
    {
        if (Greenfoot.mouseClicked(this))
        {
            Greenfoot.setWorld(new Menu());
        }
    }
}
