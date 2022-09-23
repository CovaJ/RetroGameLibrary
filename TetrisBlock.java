import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A tetris block that falls automatically, stops when it hits something
 * 
 * @author Marco Calabretta
 * @version 2
 * Note** there's a bug where tetrominos dont move the right amount sideways/rotating idk if the bug is here or in the tetromino class file
 */
public class TetrisBlock extends Actor
{
    //The amount of blocks that can fit horizontally across the board
    public static int blocksWide = 10;
    //Fits the block size to the board
    public static int size = TetrisBoard.width/blocksWide;
    //The falling velocity of the block, set in the resetVelocity() method in this class
    static double velocity;
    //Controls whether or not the block is currently falling
    boolean moving = true;
    //The tetromino and tetris board that this block is a part of
    Tetromino parent;
    TetrisBoard board;
    //This is a niche variable that stores the y position of the block right before it is
    //removed from the world
    int y;
    
    /*
     * Makes a new block
     * @param parent is the tetromino the block's a part of
     * @param board is the world the block's a part of
     * @param imageName is the string for the image file that will colour this block
     */
    public TetrisBlock(Tetromino parent, TetrisBoard board, String imageName){
        super();
        this.parent = parent;
        this.board = board;
        GreenfootImage image = new GreenfootImage(imageName);
        setImage(image);
        image.scale(size,size);
    }
    /*
     * This will make the block move, then checks whether it should stop or end the game
     * It will also check whether the block is part of a completed line, which it will then clear
     */
    public void act(){
        if(moving){
            //adds velocity to the y coordinate and rounds it
            setLocation(getX(),(int)(getY()+velocity+0.5));
            //Makes the parent's position fall with the blocks. it will only run it this
            //block is the first from the parent to prevent double counting
            if(this == parent.getBlocks()[0]){
                parent.move();
            }
            TetrisBlock otherBlock = (TetrisBlock) getOneIntersectingObject(TetrisBlock.class);
            //Checks if the block has hit either the bottom of the board or another stopped block, then stops it if it has
            if(getY()>=board.height-size/2 || (otherBlock != null && !otherBlock.getMoving())){
                Greenfoot.playSound("BlockStop.mp3");
                stop();
            }
            
        }
        //Ends the game if a block stops too high
        if(!moving && getY()<size*3/2){
            TetrisBoard.stopSound();
            Greenfoot.setWorld(new TetrisEndScreen(board.getCounter().getScore()));
        }
        //This will check if the block is on the far left, if it is it will check to clear the line
        if(!moving && getX()<=size){
            if(clearLine()){
                board.dropBlocks(y);
            }
        }
    }
    /*
     * will stop it's parent tetromino if it hasn't already, then stop the block's movement
     * and round its y position back to the nearest block position
     */
    public void stop(){
        moving = false;
        if(parent.getMoving()){
            parent.stopAll();
        }
        //Calculates the amount that the block has overshot
        double yError = getY()%size;
        //Subtracts
        setLocation(getX(),(int)(getY()-yError+size/2));
    }
    /*
     * gets the moving status of the block
     * @return the current moving status
     */
    public boolean getMoving(){
        return moving;
    }
    /*
     * sets the moving status of the block
     * @param moving new moving status
     */
    public void setMoving(boolean moving){
        this.moving = moving;
    }
    /*
     * returns the block's parent tetromino
     * @return the parent tetromino
     */
    public Tetromino getParent(){
        return parent;
    }
    /*
     * This method checks whether a block can move to a certain position
     * @param newPosition is of the form [x,y] describing the new coordinates of the block if it were to move
     * @return whether the block can move
     */
    public boolean canShiftTo(int[] newPosition){
        boolean canMove = true;
        //This is the list of the objects that are present in the block's future position
        java.util.List adjacentObjects;
        //Checks if the block would move partly out of the world
        if(newPosition[0] <size/2 || newPosition[0]>board.width-size/2 || newPosition[1]<size/2 || newPosition[1]>board.height-size/2){
            canMove = false;
        }
        //Checks if the block would move into another block that ISNT PART OF ITS OWN TETROMINO
        adjacentObjects = board.getObjectsAt(newPosition[0],newPosition[1],TetrisBlock.class);
        if(adjacentObjects.size()>0){
            TetrisBlock adjacentBlock = (TetrisBlock) adjacentObjects.get(0);
            if(adjacentBlock != null && adjacentBlock.getParent() != parent){
                canMove = false;
            }
        }
        return canMove;
    }
    /*
     * Recursive function that will check if the line is full from left to right,
     * then clear it from right to left
     * @return whether or not the line (from the current block rightwards) is full and should be cleared.
     */
    public boolean clearLine(){
        //Base case 1: the default is that the line is not full
        boolean isClear = false;
        //Base case 2: the block is on the far right, in which case the line is full
        if(getX()+size>=board.width){
            isClear = true;
        }
        //Recursive case: the line is full if there is a block to the right who's line is full
        else{
            java.util.List rightObjects;
            rightObjects = board.getObjectsAt(getX()+size,getY(),TetrisBlock.class);
            if(rightObjects.size()>0){
                TetrisBlock rightBlock = (TetrisBlock) rightObjects.get(0);
                if(rightBlock != null && !rightBlock.getMoving()){
                    isClear = rightBlock.clearLine();
                }
            }
        }
        //This increments the score and stores the current y value of the cleared line, then removes the block
        if(isClear){
            board.getCounter().addScore(100);
            y = getY();
            board.removeObject(this);
        }
        return isClear;
    }
    /*
     * Still a clunky function, but it's supposed to increase the block's velocity in some
     * way that is repeatable without causing problems
     */
    public static void fallFaster(){
        double velocityLeft = (size/2-1)-velocity;
        velocity += velocityLeft/2;
    }
    /*
     * resets the velocity of all tetris blocks
     */
    public static void resetVelocity(){
        velocity = size/4;
    }
}
