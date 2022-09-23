import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The minesweeper board where all the action takes place! It creates a rectangular grid
 * of squares and a counter
 * 
 * @author Marco
 * @version 2
 */
public class MinesweeperBoard extends World
{
    //The size of each square which determines the gameboard size
    public static int SquareSize = 20;
    //The margin between the game board and the edge of the world
    public static int BoardMargin = 10;
    //The size of the Counter
    public static int CounterHeight = 30;
    //The set of all squares on the board
    private Square[][] squares;
    //The board's bomb counter
    private MineSweeperCounter counter;
    //NumSquares is the amount of non-bomb squares on the board
    private int NumSquares;
    //Controls whether or not the player has clicked their first square yet. false before, true after
    private boolean gameStarted = false;
    //The number of Squares placed horizontally and vertically on the board and NumBombs is the amount of bombs on the board
    private int SquaresWide, SquaresTall, NumBombs;
    //Creates background Music for game - Matteus
    static GreenfootSound sound2 = new GreenfootSound("MineSweeper.mp3");
    /*
     * Creates a board
     * @param SquaresWide is the horizontal NUMBER of squares in the grid
     * @param SquaresTall is the vertical NUMBER of squares in the grid
     * @param NumBombs is the number of bombs in the game
     */
    public MinesweeperBoard(int SquaresWide, int SquaresTall, int NumBombs){    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(SquareSize*SquaresWide+2*BoardMargin, SquareSize*SquaresTall+2*BoardMargin+CounterHeight, 1);
        this.SquaresWide = SquaresWide;
        this.SquaresTall = SquaresTall;
        this.NumBombs = NumBombs;
        //Defines the squaresize as the largest value possible to fit in the board with the margins
        squares = new Square[SquaresTall][SquaresWide];
        NumSquares = SquaresTall*SquaresWide-NumBombs;
        int squareX, squareY;
        int[] index = new int[2];
        //Draws the game squares and makes all the square objects
        for(int i = 0; i<SquaresTall;i++){
            for(int j = 0; j<SquaresWide; j++){
                index[0] = i;
                index[1] = j;
                squareX = BoardMargin+SquareSize/2 + j*SquareSize;
                squareY = CounterHeight+BoardMargin+SquareSize/2 + i*SquareSize;
                squares[i][j] = new Square(SquareSize,false,index);
                addObject(squares[i][j],squareX,squareY);
            }
        }
        //Creates the counter in the top-middle of the screen
        counter = new MineSweeperCounter(NumBombs,CounterHeight);
        addObject(counter,this.getWidth()/2,CounterHeight/2);
    }
    /*
     * Assigns bomb values randomly to all squares except the one that was first clicked, which automatically doesn't contain a bomb
     */
    public void assignBombs(Square clickedSquare){
        //Makes the array of bomb values to assign to squares
        int row, column;
        for(int i = 1; i<=NumBombs; i++){
            do{
                row = Greenfoot.getRandomNumber(SquaresTall);
                column = Greenfoot.getRandomNumber(SquaresWide);
            }while(squares[row][column].getBomb() || squares[row][column] == clickedSquare);
            squares[row][column].setBomb(true);
        }
    }
    /*
     * Returns the squares array
     */
    public Square[][] getSquares(){
        return squares;
    }
    /*
     * Decreases the remaining non-bomb squares
     */
    public int clearSquare(){
        NumSquares --;
        return NumSquares;
    }
    /*
     * Returns the board's counter object
     */
    public MineSweeperCounter getCounter(){
        return counter;
    }
    /*
     * Returns whether or not the game has started
     */
    public boolean getGameStarted(){
        return gameStarted;
    }
    /*
     * Sets whether or not the game has started
     * @param newGameStarted is true when the player has clicked the first square, false beforehand
     */
    public void setGameStarted(boolean newGameStarted){
        this.gameStarted = newGameStarted;
    }
    public static void startSound2(){
        sound2.playLoop();
    }
    public static void stopSound2(){
        sound2.stop();
    }
}
