import greenfoot.*;  

/**
 * Class for left player's paddle
 * 
 * @author Jesus Cova
 * @version 1
 */
public class PlayerLeft extends Players
{
    
    /**
     * This method is called whenever the 'Act' or 'Run' button gets pressed.
     */
    public void act() 
    {
        moveVertically();   
        stopAtEdge();
    }    
    
    /**
     * Makes player move up or down based on pressed key
     */    
    public void moveVertically()
    {
        if (Greenfoot.isKeyDown("w"))
        {   
            setLocation(getX(), getY() - leftSpeed);
        }
        if (Greenfoot.isKeyDown("s"))
        {
            setLocation(getX(), getY() + leftSpeed);
        }
    }

    /**
     * Prevents from player crossing world borders
     */    
    public void stopAtEdge()
    {
        //Stops player movements if it reaches upper edge
        if (isAtUpperEdge())
        {
            leftSpeed = 0;
            if (Greenfoot.isKeyDown("s"))
            {
                leftSpeed = 5;
            }
        }
        
        //Stops player movements if it reaches lower edge
        if (isAtLowerEdge())
        {
            leftSpeed = 0;
            if (Greenfoot.isKeyDown("w"))
            {
                leftSpeed = 5;
            }            
        }
    }
}
