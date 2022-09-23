import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Tetris loss screen that displays the final score
 * 
 * @author (Marco Calabretta)
 * @version (1)
 */
public class TetrisEndScreen extends World
{
    public TetrisEndScreen(int score)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        
        //Play Game Over Sound - Matteus
        Greenfoot.playSound("GameOver.mp3");
        
        //Doesn't work, but it's supposed to print a win or loss message depending on whether the player won
        GreenfootImage textbox = new GreenfootImage(200,100);
        showText("You lost with a score of", 300, 150);
        showText(String.valueOf(score), 300, 250);
    }
}
