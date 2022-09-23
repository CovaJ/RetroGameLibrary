import greenfoot.*; 
/**
 * The world GameOver displays the winner and lets you get back to the menu
 * 
 * @author Jesus Cova 
 * @version 1
 */
public class GameOver extends World
{
    /**
     * Constructor for objects of class GameOver, creates world and shows winner
     */
    public GameOver()
    {  
        super(700, 400, 1);
        showWinner();
        
        //Stop Background Music - Matteus
        Menu.sound3Stop();
        Greenfoot.playSound("GameOver.mp3");
    }
    
    /**
     * Shows the winner's paddle with win message
     */
    public void showWinner()
    {
       //Displays right player's paddle if they win
        if (ScoreRight.scoreRight == STW.STW)
       {
            addObject(new PlayerRight(), 665, 200);
       }
       
       //Displays left player's paddle if they win
       if (ScoreLeft.scoreLeft == STW.STW)
       {
            addObject(new PlayerLeft(), 35, 200);
       }
       
       //Displays winning message and button to return to menu
       addObject(new Winner(), 350, 100);
       addObject(new BackToMenu(), 340, 300);
    }
}
