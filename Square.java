import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A square on the minesweeper board that may/may not have a bomb behind it and that can
 * be flagged and clicked
 * 
 * All the code for revealing and flagging the squares is stored here with some information
 * back and forth with the MinesweeperBoard() class
 * 
 * @author Marco
 * @version 2
 */
public class Square extends Button
{
    private GreenfootImage image;
    private boolean bomb;
    //Both the flag status and revealed status are set to false because squares start unflagged and unrevealed
    //the reveal
    private boolean flag = false, revealed = false;
    //The index of this square in the larger board
    private int[] index = new int[2];
    /*
     * Creates a square on the minesweeper board
     * @param length is the side length of the square
     * @param bomb holds whether or not the square hides a bomb
     * @param index holds two numbers holding the position of this particular square in the larger squares array of the board
     */
    public Square(int length, boolean bomb, int[] index){
        super(length,length);
        this.length = length;
        this.bomb = bomb;
        //Adds the numbers to the index array 1 by 1. doing it all at once caused me problems
        for(int i = 0; i<index.length; i++){
            this.index[i] = index[i];
        }
    }
    /*
     * Will either flag/unflag the square or reveal its contents using the Reveal() method
     */
    public void Clicked(){
        MinesweeperBoard board = (MinesweeperBoard) getWorld();
        MouseInfo mouse = Greenfoot.getMouseInfo();
        //If it's a rightclick, the square will switch to a flag
        if(mouse.getButton() == 3 && !revealed){
            //Switches the flag status and increments the counter
            flag = !flag;
            board.getCounter().changeFlag(flag);
            //Changes the image to flagged or unflagged
            if(flag){
                image = new GreenfootImage("GridFlag.png");
            }else{
                image = new GreenfootImage("Grid.png");
            }
            this.setImage(image);
            image.scale(length,length);
            //Play Flag Sound Effect
            Greenfoot.playSound("Flag.mp3");
        //Leftclick
        }else if(mouse.getButton() == 1 && !flag){
            //This if statement runs the first time a square has clicked and it then assigns random bomb values to all squares except this one
            if(!board.getGameStarted()){
                board.setGameStarted(true);
                board.assignBombs(this);
            }
            if(bomb)/*Sends the game to the endscreen if they click on a bomb*/{
                //Stops background music - Matteus
                MinesweeperBoard.stopSound2();
                Greenfoot.setWorld(new MinesweeperEndScreen(false));
            }else/*reveals the number of adjacent bombs*/{
                //Play reveal sound effect - Matteus
                Greenfoot.playSound("Reveal.mp3");
                Reveal();
            }
        }
    }
    /*
     * Counts the amount of bombs adjacent to the revealed square, then either:
     * displays the number (i.e. 3)
     * if there are no adjacent bombs, it will not display a number and instead Reveal() all its adjacent squares
     * then it will replace the square image with a new revealed square image
     */
    public void Reveal(){
        if(!revealed){
            revealed = true;
            image = new GreenfootImage("Grid2.png");
            MinesweeperBoard board = (MinesweeperBoard) getWorld();
            Square[][] squares = board.getSquares();
            int adjacentBombs = 0;
            this.setImage(image);
            image.scale(length,length);
            //Will simultaneously reduce the amount of non bomb squares on the board and check if there are any left
            if(board.clearSquare() <= 0){
                Greenfoot.setWorld(new MinesweeperEndScreen(true));
            }
            //gets the bomb array from the board and counts each of the adjacent bombs by adding 1 to a counter if the square has a bomb
            //The if statements check if the square is on the edge of the board and the ternary statements actually increment the counter
            if(index[0] > 0 && index[1] > 0){
                adjacentBombs += squares[index[0]-1][index[1]-1].getBomb() ? 1 : 0;
            }if(index[0] > 0){
                adjacentBombs += squares[index[0]-1][index[1]].getBomb() ? 1 : 0;
            }if(index[0] > 0 && index[1] < squares[0].length-1){
                adjacentBombs += squares[index[0]-1][index[1]+1].getBomb() ? 1 : 0;
            }if(index[1] > 0){
                adjacentBombs += squares[index[0]][index[1]-1].getBomb() ? 1 : 0;
            }if(index[1] < squares[0].length-1){
                adjacentBombs += squares[index[0]][index[1]+1].getBomb() ? 1 : 0;
            }if(index[0] < squares.length-1 && index[1] > 0){
                adjacentBombs += squares[index[0]+1][index[1]-1].getBomb() ? 1 : 0;
            }if(index[0] < squares.length-1){
                adjacentBombs += squares[index[0]+1][index[1]].getBomb() ? 1 : 0;
            }if(index[0] < squares.length-1 && index[1] < squares[0].length-1){
                adjacentBombs += squares[index[0]+1][index[1]+1].getBomb() ? 1 : 0;
            }
            //If the square has no adjacent bombs, it will reveal all its adjacent squares automatically
            if(adjacentBombs == 0){
                if(index[0] > 0 && index[1] > 0){
                    squares[index[0]-1][index[1]-1].Reveal();
                }if(index[0] > 0){
                    squares[index[0]-1][index[1]].Reveal();
                }if(index[0] > 0 && index[1] < squares[0].length-1){
                    squares[index[0]-1][index[1]+1].Reveal();
                }if(index[1] > 0){
                    squares[index[0]][index[1]-1].Reveal();
                }if(index[1] < squares[0].length-1){
                    squares[index[0]][index[1]+1].Reveal();
                }if(index[0] < squares.length-1 && index[1] > 0){
                    squares[index[0]+1][index[1]-1].Reveal();
                }if(index[0] < squares.length-1){
                    squares[index[0]+1][index[1]].Reveal();
                }if(index[0] < squares.length-1 && index[1] < squares[0].length-1){
                    squares[index[0]+1][index[1]+1].Reveal();
                }
            }else{//Otherwise it will just display the number of adjacent bombs
                board.showText(Integer.toString(adjacentBombs),getX(),getY());
            }
        }
    }
    /*
     * Returns bomb status
     */
    public boolean getBomb(){
        return bomb;
    }
    /*
     * Sets the bomb status
     * @param bomb is the new bomb status
     */
    public void setBomb(boolean bomb){
        this.bomb = bomb;
    }
}
