import greenfoot.*; 

/**
 * Displays the winning message
 * 
 * @author Jesus Cova
 * @version 1
 */

public class Winner extends Actor
{   
    GreenfootImage rightplayerwins = new GreenfootImage("rightplayerwins.png");
    GreenfootImage leftplayerwins = new GreenfootImage("leftplayerwins.png"); 
    
    /**
     * Constructor for objects of class Winner
     */
    public Winner()
    {
        showWinner();
    }
    
    /**
     * The winning message of the winner is shown.
     */
    public void showWinner()
    {
        //Determines the winner and displays their winning message
        if (ScoreRight.scoreRight == STW.STW)
        setImage(rightplayerwins);
        
        if (ScoreLeft.scoreLeft == STW.STW)
        setImage(leftplayerwins);
    }
}
