import greenfoot.*;

/**
 * Sets the score to win to a value from 1-5
 * 
 * @author Jesus Cova
 * @version 1
 */

public class STW extends Score
{   
    GreenfootImage stw1 = new GreenfootImage("score1.png");
    GreenfootImage stw2 = new GreenfootImage("score2.png");
    GreenfootImage stw3 = new GreenfootImage("score3.png");
    GreenfootImage stw4 = new GreenfootImage("score4.png");
    GreenfootImage stw5 = new GreenfootImage("score5.png");
    GreenfootImage stw;                                     
    static int STW;                                         
    
    /**
     * Constructor for objects of class STW, sets default image and
     * score to win to 3
     */
    public STW()
    {
        setImage(stw3); 
        STW = 3;
    }
    
    /**
     * This method is called whenever the 'Act' or 'Run' button gets pressed
     */
    public void act() 
    {
        changeSTW();
    }    
    
    /**
     * Changes value for the score to win as buttons to increase or decrease
     * score to win are pressed
     */
    public void changeSTW()
    {
        //Checks which value the score to win has been set to
        switch (STW)
        {
            case 1: stw = stw1;
                    break;
            case 2: stw = stw2;
                    break;
            case 3: stw = stw3;
                    break;
            case 4: stw = stw4;
                    break;
            case 5: stw = stw5;
                    break;
        }
        
        //Prevents the value to go below 1 or above 5
        if (STW > 5)
        STW = 5;
        if (STW < 1)
        STW = 1;
        
        //Sets image of score to win to apporiate value
        setImage(stw);
    }
}