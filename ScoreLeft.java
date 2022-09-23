import greenfoot.*;  

/**
 * Displays the left player's score
 * 
 * @author Jesus Cova
 * @version 1
 */

public class ScoreLeft extends Score
{   
    static int scoreLeft;
    
    /**
     * Constructor for objects of class ScoreLeft, sets default to 0
     */
    public ScoreLeft()
    {
        setImage(score0);
        scoreLeft = 0;
    }
    
    /**
     * This method is called whenever the 'Act' or 'Run' button gets pressed
     */
    public void act() 
    {
        changeScoreLeft();
    }
    
    /**
     * Displays the score for the left player
     */
    public void changeScoreLeft()
    {
        //Checks which value the score corresponds to
        switch (scoreLeft)
        {
            case 0: score = score0;
                    break;
            case 1: score = score1;
                    break;
            case 2: score = score2;
                    break;
            case 3: score = score3;
                    break;
            case 4: score = score4;
                    break;
            case 5: score = score5;
                    break;
        }
        
        //Sets score image to appropiate image
        setImage(score);
    }
}
