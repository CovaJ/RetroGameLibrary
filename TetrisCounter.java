import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Displays the current score of the tetris game
 * 
 * @author (Marco Calabretta) 
 * @version (1)
 */
public class TetrisCounter extends Actor
{
    int score = 0;
    /*
     * Makes a counter
     * @param height is the side length of the counter
     */
    public TetrisCounter(int height){
        super();
        GreenfootImage image = getImage();
        image.scale(height,height);
    }
    /*
     * Displays the score
     */
    public void act(){
        getWorld().showText(Integer.toString(score),getX(),getY());
    }
    /*
     * Increments the score
     * @param increment is the amount that the score changes by
     */
    public void addScore(int increment){
        score += increment;
        if(score%10000 == 0){
            TetrisBlock.fallFaster();
        }
    }
    /*
     * Returns the current score
     */
    public int getScore(){
        return score;
    }
}
