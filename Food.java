import greenfoot.*;
import java.util.Random;

/**
 * Food class for the snake game
 * 
 * @author Jesus Cova 
 * @version 1
 */

public class Food extends Actor
{
    Random r = new Random();
    
    /**
     * If body intersects with food, sets random location of food
     */
    public void act()
    {
        while(getOneIntersectingObject(Body.class)!=null){
            setLocation(r.nextInt(40), r.nextInt(25));
        }
    }
}