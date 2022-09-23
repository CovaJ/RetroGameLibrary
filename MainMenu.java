import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MainMenu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MainMenu extends World
{
//Music for menu - matteus
        static GreenfootSound menu = new GreenfootSound("mainmenu.mp3");
    /**
     * Constructor for objects of class MainMenu.
     * 
     */
    public MainMenu()
    {    
        // Create a new world with 960x720 cells with a cell size of 1x1 pixels.
        super(700,576, 1);
        
        //Start Music - Matteus
        menu.playLoop();
        
        // Creates buttons to access the games
        tetrismenubutton tetrisButton = new tetrismenubutton("tetris.png", new TetrisBoard());
        addObject(tetrisButton, 250, 175);
        
        snakemenubutton snakeButton = new snakemenubutton("snake.png", new SnakeMenu());
        addObject(snakeButton, 450, 175);
        
        pongmenubutton pongButton = new pongmenubutton("pong.png", new Menu());
        addObject(pongButton, 250, 250);
        
        minemenubutton minesweeperButton = new minemenubutton("minesweeper.png", new MinesweeperBoard(30, 16, 99));
        addObject(minesweeperButton, 450, 250);
        
        TetrisBoard.sound.stop();
        MinesweeperBoard.sound2.stop();
        Menu.sound3.stop();
        SnakeMenu.sound4.stop();
    }
    public static void stopMenu() {
        menu.stop();
    }
}
