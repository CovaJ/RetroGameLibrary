import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EndScreen here.
 * 
 * @author Marco
 * @version 1
 */
public class MinesweeperEndScreen extends World
{

    /**
     * Constructor for objects of class EndScreen.
     * 
     */
    public MinesweeperEndScreen(boolean win)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        
        //Play game over sound - Matteus
        Greenfoot.playSound("GameOver.mp3");
        
        //Doesn't work, but it's supposed to print a win or loss message depending on whether the player won
        GreenfootImage textbox = new GreenfootImage(200,100);
        if(win){
            showText("You win", 300, 200);
        }else{
            showText("You lose", 300, 200);
        }
    }
}
