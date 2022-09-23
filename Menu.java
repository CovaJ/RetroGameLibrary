import greenfoot.*; 
/**
 * Menu where player can customize and start the game
 * 
 * @author Jesus Cova
 * @version 1
 */
public class Menu extends World
{   
    GreenfootImage menu = new GreenfootImage("menu.jpg"); 
    
    //Create Background Music
    static GreenfootSound sound3 = new GreenfootSound("Pong.mp3");
    /**
     * Constructor for objects of class Menu where world is created
     * and paddles and buttons are placed
     */
    public Menu()
    {    
        super(700, 400, 1);
        setBackground(menu);
        addObject(new PlayerRight(), 665, 50);
        addObject(new PlayerLeft(), 35, 350);
        addObject(new PLAY(), 160, 300);
        addObject(new minusSTW(), 475, 335);
        addObject(new plusSTW(), 585, 335);
        addObject(new Computer(), 160, 200);
        addObject(new STW(), 530, 335);
        
    }
    public static void sound3start(){
        sound3.playLoop();
    }
    public static void sound3Stop(){
        sound3.stop();
    }
}
