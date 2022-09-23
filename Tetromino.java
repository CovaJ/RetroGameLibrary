import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A set of four TetrisBlock that move together until they hit the ground
 * 
 * @author Marco Calabretta
 * @version 2
 * Note** there's a bug where tetrominos dont move the right amount sideways/rotating idk if the bug is here or in the TetrisBlock class file
 */
public class Tetromino extends Actor
{
    //The list of tetromino types. they're defined individually here for clarity
    //Each tetromino is a set of four number pairs, which is the amount of spaces the 
    //block is right and down from the central spawn square. ex {-1,1} is 1 left and down
    static int[][] L = {{0,0},{-1,0},{1,0},{-1,1}};
    static int[][] S = {{0,0},{1,0},{-1,1},{0,1}};
    static int[][] J = {{0,0},{-1,0},{1,0},{1,1}};
    static int[][] I = {{0,0},{-1,0},{1,0},{2,0}};
    static int[][] Z = {{0,0},{-1,0},{0,1},{1,1}};
    static int[][] O = {{0,0},{1,0},{0,1},{1,1}};
    static int[][] T = {{0,0},{-1,1},{0,1},{1,1}};
    //The list of the tetromino types in one array
    public static int[][][] blockList = {L,S,J,I,Z,O,T};
    TetrisBoard board;
    //The type is the index of the blockList
    int type;
    //Position of the {0,0} block of the tetromino, even if there is no block there
    //Used as the coordinates of the whole tetromino
    int[] position = new int[2];
    //Whether or not the whole tetromino is moving
    boolean moving = true;
    //The set of blocks in the tetromino
    TetrisBlock[] blocks = new TetrisBlock[4];
    /*
     * makes a set of four blocks in a specific shape at the top of the screen
     * @param type is the index of the type of tetromino it is from the blocklist. I.E. 0 is L, 6 is T, etc
     * @param world is the board that the tetromino is on in order to allow the tetromino to add blocks to that world
     */
    public Tetromino(int type, TetrisBoard board){
        super();
        this.board = board;
        //Declares and initializes the string for the colour image of the blocks
        String imageName;
        switch(type){
            case 0:
                imageName = "L.png";
                break;
            case 1:
                imageName = "S.png";
                break;
            case 2:
                imageName = "J.png";
                break;
            case 3:
                imageName = "I.png";
                break;
            case 4:
                imageName = "Z.png";
                break;
            case 5:
                imageName = "O.png";
                break;
            case 6:
                imageName = "T.png";
                break;
            default:
                imageName = "I.png";
        }
        //The coordinates for the position of the 0,0 block to spawn
        this.position[0] = TetrisBlock.size/2+(TetrisBlock.size*TetrisBlock.blocksWide/2);
        this.position[1] = TetrisBlock.size/2;
        //Holds the coordinates of the block to be spawned for clarity
        int[] currentPosition = new int[2];
        //Initializes a block then adds it to the world at the right coordinates
        for(int i = 0; i<blocks.length;i++){
            blocks[i] = new TetrisBlock(this,board,imageName);
            currentPosition[0] = position[0]+blockList[type][i][0]*TetrisBlock.size;
            currentPosition[1] = position[1]+blockList[type][i][1]*TetrisBlock.size;
            board.addObject(blocks[i],currentPosition[0],currentPosition[1]);
        }
    }
    /*
     * Will run the stop method on all blocks contained in the tetromino, then will
     * remove itself from the world
     */
    public void stopAll(){
        moving = false;
        for(int i = 0; i<blocks.length; i++){
            //Will only stop the block if it is already moving to prevent infinite looping
            if(blocks[i].getMoving()){
                blocks[i].stop();
            }
        }
        //Adds 100 to the score
        board.getCounter().addScore(100);
        board.removeTetromino();
        //resets block array to be empty so that the blocks don't act as a unit anymore
        //effectively destroys the tetromino, which was really only a set of blocks anyway
        blocks = new TetrisBlock[blocks.length];
    }
    /*
     * returns whether or not the tetromino is moving
     * @returns the tetromino's moving status
     */
    public boolean getMoving(){
        return moving;
    }
    /*
     * returns list of blocks
     * @return the list of blocks
     */
    public TetrisBlock[] getBlocks(){
        return blocks;
    }
    /*
     * makes the tetromino fall the same amount as its blocks
     * (int) and +0.5 is to round it
     */
    public void move(){
        position[0] = blocks[0].getX();
        position[1] = blocks[0].getY();
    }
    /*
     * This method controls player movement. If it is activated it will move the tetromino 1 square either left or right
     * @param direction is true for moving right, false for moving left
     */
    public void shift(boolean direction){
        boolean canMove = true;
        //Turns the boolean direction into a numerical shift value
        int moveMultiplier = direction ? 1 : -1;
        int[][] newPositions = new int[blocks.length][2];
        //The for loop checks if each block can move
        for(int i = 0; i<blocks.length; i++){
            newPositions[i] = new int[]{blocks[i].getX()+TetrisBlock.size*moveMultiplier,blocks[i].getY()};
            canMove = blocks[i].canShiftTo(newPositions[i]) ? canMove : false;
        }
        //If all the blocks can move, it will move all blocks
        if(canMove){
            for(int i = 0; i<blocks.length; i++){
                blocks[i].setLocation(newPositions[i][0],newPositions[i][1]);
            }
        }
    }
    /*
     * rotates the tetromino 90 degrees clockwise about its {0,0} point
     */
    public void rotate(){
        //x and y distance of a block's centre from the tetromino's {0,0} block
        int[] distanceFromCentre = new int[2];
        //The position the block moves to
        int[] newDistanceFromCentre;
        //The set of new positions for all the blocks
        int[][] newPositions = new int[blocks.length][2];
        boolean canMove = true;
        //Checks if all blocks can rotate without hitting something or going off the world
        //Also stores the places they are supposed to move to
        for(int i = 0; i<blocks.length; i++){
            distanceFromCentre[0] = position[0]-blocks[i].getX();
            distanceFromCentre[1] = position[1]-blocks[i].getY();
            newDistanceFromCentre = new int[]{distanceFromCentre[1],-distanceFromCentre[0]};
            newPositions[i] = new int[]{position[0]+newDistanceFromCentre[0],position[1]+newDistanceFromCentre[1]};
            canMove = blocks[i].canShiftTo(newPositions[i]) ? canMove : false;
        }
        //If the blocks can all move, it moves all the blocks to the new position
        if(canMove){
            for(int i = 0; i<blocks.length; i++){
                blocks[i].setLocation(newPositions[i][0],newPositions[i][1]);
            }
        }
    }
}
