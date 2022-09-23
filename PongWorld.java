import greenfoot.*; 
/**
 * The pong world where the game is played
 * 
 * @author Jesus Cova
 * @version 1
 */

public class PongWorld extends World
{   
    GreenfootImage pongworld = new GreenfootImage("pongworld.jpg"); 
    
    /**
     * Constructor for objects of class PongWorld where world is created and
     * paddles, scores, and ball
     */
    public PongWorld()
    {    
        super(700, 400, 1);
        setBackground(pongworld);
        addObject(new PlayerRight(), 665, 200);
        addObject(new PlayerLeft(), 35, 200);
        addObject(new Ball(), 350, 200);
        addObject(new Timer(), 350, 200);
        addObject(new ScoreLeft(), 300, 25);
        addObject(new ScoreRight(), 400, 25);
    }
}