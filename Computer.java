import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Button to set 1 or 2 player(s)
 * 
 * @author Jesus Cova
 * @version 1
 */
public class Computer extends Buttons
{
    GreenfootImage P1 = new GreenfootImage("1Player.png");
    GreenfootImage P2 = new GreenfootImage("2Player.png");
    public static boolean comp;
    
    /**
     * Constructor for objects of class Computer, sets default value to 2 players
     */
    public Computer(){
        setImage(P2);
        comp = false;
    }
    
    /**
     * This method is called whenever the 'Act' or 'Run' button gets pressed
     */
    public void act() 
    {
       clicked();
    }
    
    /**
     * If the button is clicked, it switches the image of the button and
     * changes other player option
     */
    public void clicked()
    {
        if (Greenfoot.mouseClicked(this))
        {
            //switches image and player options
            if (comp){
                setImage(P2); 
                comp = false;
            } else {
                setImage(P1);
                comp = true;
            }
        }
    }
}
