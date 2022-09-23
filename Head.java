import greenfoot.*;
import java.util.Random;

/**
 * Head of the snake that moves around and interacts with surroundings
 * 
 * @author Jesus Cova 
 * @version 1
 */
public class Head extends Actor
{
    static boolean alive = true;
    int direction;
    int length;
    Random r = new Random();
    static final int scale = 3;
    Body body;
    boolean temp1;
    Counter counter = new Counter();
    
    /**
     * Constructor for objects of class Head, sets default values for various 
     * variables
     */
    public Head()
    {
        alive = true;
        direction = 0;
        length = 3;
        body = null;
        temp1 = false;
    }
    
    /**
     * This method is called whenever the 'Act' or 'Run' button gets pressed
     */
    public void act()
    {
        if(alive)
        {
            //Determines the snake's direction based on the key pressed   
            if(Greenfoot.isKeyDown("right")&&direction!=2)
                direction = 0;
            else if(Greenfoot.isKeyDown("down")&&direction!=3)
                direction = 1;
            else if(Greenfoot.isKeyDown("left")&&direction!=0)
                direction = 2;
            else if(Greenfoot.isKeyDown("up")&&direction!=1)
                direction = 3;
            
            //Turns the head and body
            setRotation(direction*90);
            body = new Body(length-1, direction*90, body);
            getWorld().addObject(body, getX(), getY());
            move(1);
            
            //Runs foundFood method if head touches food
            if(getOneIntersectingObject(Food.class)!=null){
                foundFood();
            }
            
            //Runs death method if head touches body or world edge
            if(getOneIntersectingObject(Body.class)!=null||isAtEdge())
                death();
        }
        
    }
    
    /**
     * Increases length of snake and increments counter
     */
    private void foundFood()
    {
        length += scale;
        body.increase();
        getWorld().removeObject(getOneIntersectingObject(Food.class));
        getWorld().addObject(new Food(), r.nextInt(30), r.nextInt(30));
        Counter.add(length);
    }
    
    /**
     * Determines if the head has touched world boundaries
     */
    public boolean isAtEdge()
    {
        if(getX()<0||getX()>=(31)||getY()<0||getY()>=(31)){
            return true;
        }
        return false;
    }
    
    /**
     * Kills snake and displays 'game over' screen
     */
    public void death()
    {
        alive = false;
        Greenfoot.setWorld(new SnakeGameOver(length + 1));        
    }
    
    /**
     * Gets the scale value
     * 
     * @return integer
     */
    public static int getScale()
    {
        return scale;
    }
    
    /**
     * Gets the alive value
     * 
     * @return boolean
     */
    public static boolean getAlive(){
        return alive;
    }
}