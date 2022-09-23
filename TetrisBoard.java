import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Random;
/**
 * The board that tetris is played on. contains blocks organized in tetrominos and a counter
 * 
 * @author Marco Calabretta 
 * @version 2
 */
public class TetrisBoard extends World
{
    public static int width = 400;
    //Adding 1 to the height prevents rounding errors that caused some blocks to disappear upon hitting the bottom of the screen
    public static int height = (int)(1.5*width)+1;
    //Stores the current moving tetromino
    Tetromino tetromino;
    TetrisCounter counter;
    //Inserts Background Music into the game - Matteus
    static GreenfootSound sound = new GreenfootSound("Tetris.mp3");
    /*
     * makes a new tetris board with a counter
     */
    public TetrisBoard()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(width,height,1);
        //resets the velocity of blocks so players don't start a new game with a faster speed
        TetrisBlock.resetVelocity();
        int counterSize = 60;
        counter = new TetrisCounter(counterSize);
        addObject(counter,counterSize/2,counterSize/2);
        //Stop all previous music and start playing Tetris music - Matteus
    }
    /*
     * This adds a tetromino if there is none and controls player movement
     */
    public void act(){
        //This will run every time a tetromino stops and spawns a new one
        if(tetromino == null){
            addTetromino();
        }
        //Shifts the tetromino
        if(Greenfoot.isKeyDown("left")){
            tetromino.shift(false);
        }else if(Greenfoot.isKeyDown("right")){
            tetromino.shift(true);
        }else if(Greenfoot.isKeyDown("up")){
            tetromino.rotate();
        }
    }
    /*
     * this will spawn a new random tetromino
     */
    public void addTetromino(){
        Random rand = new Random();
        tetromino = new Tetromino(rand.nextInt(Tetromino.blockList.length),this);
    }
    /*
     * sets the tetromino to null so the board spawns a new tetromino automatically
     */
    public void removeTetromino(){
        tetromino = null;
    }
    public TetrisCounter getCounter(){
        return counter;
    }
    /*
     * Runs every time a line is fully cleared
     * Drops all blocks by 1 block, unless they are part of the current tetromino or are below the cleared line
     * @param bottomY is the y coordinate of the line that was just cleared
     */
    public void dropBlocks(int bottomY){
        java.util.List blocks = getObjects(TetrisBlock.class);
        TetrisBlock block;
        //Runs through every single block in the world
        for(int i = 0; i<blocks.size(); i++){
            block = (TetrisBlock) blocks.get(i);
            //Checks if the block is eligible to be dropped
            if(block.getParent() != tetromino && block.getY()<bottomY){
                block.setLocation(block.getX(),block.getY()+TetrisBlock.size);
            }
        }
    }
    public static void startSound(){
        sound.playLoop();
    }
    public static void stopSound(){
        sound.stop();
    }
}
