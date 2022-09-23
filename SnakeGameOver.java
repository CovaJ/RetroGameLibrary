import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Displays the Snake game's 'game over' screen
 * 
 * @author Jesus Cova 
 * @version 1
 */
public class SnakeGameOver extends World
{
    Counter counter = new Counter();
    /**
     * Constructor for class SnakeGameOver, creates the world, 
     * adds buttons and score to the screen
     * 
     * @param length integer value for the length of snake
     */
    public SnakeGameOver(int length)
    {    
        // Create a new world with 600x600 cells with a cell size of 1x1 pixels.
        super(600, 600, 1);
        addObject(new Counter("Score: "), 300, 300);
        counter.setValue(length + 1);
        addObject(new BackToMenuSnake(), 300, 250);
        
        //stops background music and plays game over sound
        SnakeMenu.stopSound4();
        Greenfoot.playSound("GameOver.mp3");
    }
}
