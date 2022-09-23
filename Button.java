import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Multipurpose button class that makes a rectangle that can be clicked.
 * This button will do nothing when clicked, but its subclasses will have a clicked
 * method rather than an act method to control their behaviour when they are clicked
 * 
 * @author Marco
 * @version 1
 */
public class Button extends Actor
{
    public int length, height;
    /*
     * Creates a rectangle with an image
     * @param length is the horizontal size of the button
     * @param height is the vertical size of the button
     */
    public Button(int length, int height){
        super();
        GreenfootImage image = getImage();
        image.scale(length,height);
    }
    /*
     * This empty abstract method will be full in the subclasses, because buttons can
     * perform different things when they are clicked
     */
    public void Clicked(){
        
    }
    /*
     * Button subclasses will not normally have act methods, because all they can do is be clicked
     */
    public void act()
    {
        if(Greenfoot.mouseClicked(this)){
            Clicked();
        }
    }
}
