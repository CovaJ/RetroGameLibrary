import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Displays the Snake game's 'menu' screen
 * 
 * @author Jesus Cova 
 * @version 1
 */
public class SnakeMenu extends World
{
    GreenfootImage menu = new GreenfootImage("snakeMenu.jpg");
    
    //Creates background music - Matteus
    static GreenfootSound sound4 = new GreenfootSound("Snake.mp3");
    /**
     * Constructor for objects of class SnakeMenu, creates world, and adds
     * the play button to the screen
     */
    public SnakeMenu()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(300, 300, 2);
        setBackground(menu);
        addObject(new PlaySnake(), 150, 180);
        
    }public static void startSound4(){
        sound4.playLoop();
    }
    public static void stopSound4(){
        sound4.stop();
    }
}
