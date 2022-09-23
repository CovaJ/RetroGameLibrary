import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Counter/score for the snake game
 * 
 * @author Jesus Cova 
 * @version 1
 */

public class Counter extends Actor
{
    static final Color transparent = new Color(0,0,0,0);
    GreenfootImage background;
    int value;
    static int target;
    String prefix;
    
    /**
     * Constructor for objects of class Counter and creates string object
     */
    public Counter()
    {
        this(new String());
    }

    /**
     * Creates a new counter, initialised to 0
     */
    public Counter(String prefix)
    {
        background = new GreenfootImage(100, 30);
        value = 0;
        target = 3;
        this.prefix = prefix;
        updateImage();
    }
    
    /**
     * Called whenever the 'Act' or 'Run' button gets pressed
     */
    public void act() 
    {
        //Animates counting up and down to the target score value
        if (value < target) {
            value++;
            updateImage();
            //Play fruit sound - Matteus
            Greenfoot.playSound("Fruit.mp3");
        }
        else if (value > target) {
            value--;
            updateImage();
        }
    }

    /**
     * Add a new score to the current counter value
     * 
     * @param score Integer value for score
     */
    public static void add(int score)
    {
        target = score;
    }

    /**
     * Return the current counter value
     * 
     * @return integer value
     */
    public int getValue()
    {
        return target;
    }

    /**
     * Set a new counter value
     * 
     * @param newValue
     */
    public void setValue(int newValue)
    {
        target = newValue;
        value = newValue;
        updateImage();
    }
    
    /**
     * Sets a text prefix that should be displayed before
     * the counter value
     * 
     * @param prefix String value for prefix
     */
    public void setPrefix(String prefix)
    {
        this.prefix = prefix;
        updateImage();
    }

    /**
     * Update the image on screen to show the current value.
     */
    private void updateImage()
    {
        GreenfootImage image = new GreenfootImage(background);
        GreenfootImage text = new GreenfootImage(prefix + value, 22, Color.BLACK, transparent);
        
        image.drawImage(text, 6, 6);
        setImage(image);
    }
}
