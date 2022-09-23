import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Button here.
 * 
 * @author mattoe
 * @version 1
 */
public class snakemenubutton extends Actor
{
    /**
     * Act - do whatever the Button wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    private World link;
    public snakemenubutton(String image, World link){
        setImage(new GreenfootImage(image));
        this.link = link;

    }
        
    public void act()
    {
        // Add your action code here.
        if (Greenfoot.mouseClicked(this)){
            Greenfoot.setWorld(this.link);
            SnakeMenu.startSound4();
            MainMenu.stopMenu();
        }
    }
}