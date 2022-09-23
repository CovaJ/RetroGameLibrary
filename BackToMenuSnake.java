import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Button to return to the menu screen
 * 
 * @author Jesus Cova 
 * @version 1
 */
public class BackToMenuSnake extends ButtonSnake
{
    GreenfootImage backtomenu = new GreenfootImage("backtomenu.png"); // The image for the class BACKTOMENU.
    
    /**
     * Constructor for objects of class BackToMenu and sets its image
     */
    public BackToMenuSnake()
    {
        setImage(backtomenu);
    }
    
    /**
     * Called whenever the 'Act' or 'Run' button gets pressed
     */
    public void act() 
    {
        clicked();
    }    
    
    /**
     * If the button is being clicked, it will set the world to the menu screen
     */
    public void clicked()
    {
        if (Greenfoot.mouseClicked(this))
        {
            Greenfoot.setWorld(new SnakeMenu());
        }
    }    
}
