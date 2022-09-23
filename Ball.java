import greenfoot.*;
/**
 * Ball for the pong game that interacts with paddles and world
 * 
 * @author Jesus Cova
 * @version 1
 */
public class Ball extends Actor
{   
    int ballSpeed;
    public static int ballX, ballY;
    GreenfootImage ball = new GreenfootImage("ball.png");
    
    /**
     * Constructor for objects of class Ball, sets ball speed
     */
    public Ball()
    {   
        ballSpeed = 6;
        setImage(ball);
    }
    
    /**
     * This method is called whenever the 'Act' or 'Run' button gets pressed.
     */
    public void act() 
    {
        ballX = getX();
        ballY = getY();
        waitForTimer();
        scorePoint();
        bounce();
        endGame();
    }    
    
    /**
     * The ball moves once timer hits 0
     */
    public void waitForTimer()
    {
        if (Timer.counter == 0)
        move(ballSpeed);
    }
    
    /**
     * Determines if ball has reached left edge
     */
    public boolean isAtLeftEdge()
    {
        if (getX() <= 0)
            return true;
        else 
            return false;
    }
    
    /**
     * Determines if ball has reached right edge
     */
    public boolean isAtRightEdge()
    {
        if (getX() >= getWorld().getWidth()-1)
            return true;
        else
            return false;
    }
    
    /**
     * Determines if ball has reached upper edge
     */
    public boolean isAtUpperEdge()
    {
        if (getY() <= 1)
            return true;
        else
            return false;
    }   
    
    /**
     * Determines if ball has reached lower edge
     */
    public boolean isAtLowerEdge()
    {
        if (getY() >= getWorld().getHeight()- 1)
            return true;
        else
            return false;
    }
    
    /**
     * Makes ball bounce of paddles and edges of world
     */
    public void bounce()
    {
        //inverts ball direction if it touches left paddle
        if (isTouching(PlayerLeft.class))
        {   
            ballSpeed = ballSpeed * -1;
            
            Actor PlayerLeft = getOneIntersectingObject(PlayerLeft.class);
            
            //Plays ball hit sound - Matteus
            Greenfoot.playSound("BallHit.mp3");
            
            //Rotates the ball when ball hits different parts of paddle
            if (getY() - PlayerLeft.getY() > 0 && PlayerLeft.getX() - getX() <= 2)
                setRotation(360 - getRotation() + 10); 
            if (getY() - PlayerLeft.getY() < 0 && PlayerLeft.getX() - getX() <= 2)
                setRotation(360 - getRotation() - 10);
            if (getY() - PlayerLeft.getY() == 0 && PlayerLeft.getX() - getX() <= 2)
                setRotation(360 - getRotation());
        }
        
        //inverts ball direction if it touches right paddle
        if (isTouching(PlayerRight.class))
        {
            ballSpeed = ballSpeed * -1;
            
            Actor PlayerRight = getOneIntersectingObject(PlayerRight.class);
            
            //Plays ball hit sound - Matteus
            Greenfoot.playSound("BallHit.mp3");
            
            //Rotates the ball when ball hits different parts of paddle
            if (getY() - PlayerRight.getY() > 0 && getX() - PlayerRight.getX() <= 2) 
                setRotation(360 - getRotation() - 10); 
            if (getY() - PlayerRight.getY() < 0 && getX() - PlayerRight.getX() <= 2)
                setRotation(360 - getRotation() + 10);
            if (getY() - PlayerRight.getY() == 0 && getX() - PlayerRight.getX() <= 2)
                setRotation(360 - getRotation());            
        }
        
        //Inverts direction if it touches an upper/lower bound of world and rotates ball
        if (isAtUpperEdge() || isAtLowerEdge())
        {
            ballSpeed = ballSpeed * -1;
            setRotation(360 - (getRotation() - 180));
        }
    }
    
    /**
     * Adds point depending on which edge ball hits
     */
    public void scorePoint()
    {
        if (isAtLeftEdge() || isAtRightEdge())
        {   
            //Adds score to appropiate side
            if (isAtLeftEdge())
                ScoreRight.scoreRight++;
            if (isAtRightEdge())
                ScoreLeft.scoreLeft++;
            
            //Resets ball and players
            setLocation(350, 200);
            setRotation(0);
            PlayerLeft PlayerLeft = getWorld().getObjects(PlayerLeft.class).get(0);
            PlayerLeft.setLocation(35, 200);
            PlayerRight PlayerRight = getWorld().getObjects(PlayerRight.class).get(0);
            PlayerRight.setLocation(665, 200);
            Players.leftSpeed = 5;
            Players.rightSpeed = 5;
        }
    }
    
    /**
     * Ends game when the max score has been reached
     */
    public void endGame()
    {
        if (ScoreRight.scoreRight == STW.STW || ScoreLeft.scoreLeft == STW.STW)
        {  
            Greenfoot.setWorld(new GameOver());
        }
    }
}
