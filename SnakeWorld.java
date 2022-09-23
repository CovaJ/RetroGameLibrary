import greenfoot.*;
import java.util.Random;

/**
 * World of the game Snake
 * 
 * @author Jesus Cova 
 * @version 1
 */

public class SnakeWorld extends World
{
    Random r = new Random();
    
    /**
     * Constructor for objects of class SnakeWorld, sets world, grid, and adds
     * objects to the world
     */
    public SnakeWorld()
    {    
        super(30, 30, 20, false); 
        GreenfootImage img = new GreenfootImage(20,20); 
        img.setColor(Color.LIGHT_GRAY); 
        img.drawRect(0,0,20,20); 
        setBackground(img); 
        addObject(new Counter(), 5, 5);
        addObject(new Head(), 15, 15);
        addObject(new Food(), r.nextInt(30), r.nextInt(30));
        setPaintOrder(Counter.class, Head.class, Body.class, Food.class);
    }    
}