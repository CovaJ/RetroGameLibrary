import greenfoot.*;  

/**
 * Class for Right player's paddle
 * 
 * @author Jesus Cova
 * @version 1
 */

public class PlayerRight extends Players
{
    boolean computer;
    Ball ball = new Ball();
    
    /**
     * This method is called whenever the 'Act' or 'Run' button gets pressed.
     */
    public void act() 
    {
        //Gives computer or player controls depending if 1 or 2 players was chosen
        computer = Computer.comp;
        if (computer){
            moveComputer();
        }else{
            moveVertically();
        }
        
        stopAtEdge();
    }   
    
    /**
     * Allows player to move up and down depending on key pressed
     */
    public void moveVertically()
    {   
        if (Greenfoot.isKeyDown("up"))
        {   
            setLocation(getX(), getY() - rightSpeed);
        }
        if (Greenfoot.isKeyDown("down"))
        {
            setLocation(getX(), getY() + rightSpeed);
        }
    }
    
    /**
     * Prevents player from crossing world boundaries
     */
    public void stopAtEdge()
    {
        //Stops player movements if it reaches upper edge
        if (isAtUpperEdge())
        {
            rightSpeed = 0;
            if (Greenfoot.isKeyDown("down"))
            {
                rightSpeed = 5;
            }
        }
        
        //Stops player movements if it reaches lower edge
        if (isAtLowerEdge())
        {
            rightSpeed = 0;
            if (Greenfoot.isKeyDown("up"))
            {
                rightSpeed = 5;
            }            
        }
    }
    
    /**
     * Computer follows position of ball
     */
    public void moveComputer()
    {
        if(getY() > Ball.ballY && !isAtUpperEdge())
        setLocation(getX(), getY() - 5);
        if(getY() < Ball.ballY && !isAtLowerEdge())
        setLocation(getX(), getY() + 5);
    }
}
