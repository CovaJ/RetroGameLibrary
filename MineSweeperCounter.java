import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Counts the number of remaining bombs in a minesweeper game by subtracting the number
 * of flagged squares from the original number of bombs on the board
 * 
 * @author Marco
 * @version 1
 */
public class MineSweeperCounter extends Actor
{
    int bombs;
    int flags = 0;
    /*
     * Makes a counter
     * @param bombs is the initial counter number
     * @param height is the side length of the counter
     */
    public MineSweeperCounter(int bombs, int height){
        super();
        this.bombs = bombs;
        GreenfootImage image = getImage();
        image.scale(height,height);
    }
    /*
     * This only displays the remaining amoung of unflagged bombs according to the user's flags
     */
    public void act(){
        MinesweeperBoard board = (MinesweeperBoard) getWorld();
        board.showText(Integer.toString(bombs-flags),getX(),getY());
    }
    /*
     * Increments the amount of flagged squares by 1 in either direction
     * @param add is true if a flag is being added, false if a flag is being removed
     */
    public void changeFlag(boolean add){
        flags += add ? 1 : -1;
    }
}
