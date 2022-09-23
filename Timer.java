import greenfoot.*; 

/**
 * A countdown from 3 to 0, which starts the game as it hits 0
 * 
 * @author Jesus Cova
 * @version 1
 */

public class Timer extends Actor
{   
    GreenfootImage timer3 = new GreenfootImage("timer3.png");
    GreenfootImage timer2 = new GreenfootImage("timer2.png");
    GreenfootImage timer1 = new GreenfootImage("timer1.png"); 
    static int counter = 0; 
    
    /**
     * This method is called whenever the 'Act' or 'Run' button gets pressed
     */
    public void act() 
    {
        counter++;
        countDown();
    }    
    
    /**
     * Counts down from three to zero
     */
    public void countDown()
    {
        if (counter == 1)
        setImage(timer3);
        
        if (counter == 70)
        setImage(timer2);
        
        if (counter == 140)
        setImage(timer1);
        
        if (counter > 210)
        {
            getWorld().removeObject(this);
            counter = 0;
        }
    }
}
