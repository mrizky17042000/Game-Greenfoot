import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class musuh here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class musuh extends musuhh
{
    /**
     * Act - do whatever the musuh wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int speed = 3;
    private int upTurn = 125;
    private int downTurn = 300;
    private int shootingCounter = 10;
    private int direction = 1; 
    public void act() 
    {
       shootingCounter --;
       shooting();
       setLocation ( getX() , getY() + speed );
       Actor actor = getOneIntersectingObject(null);
       if(actor != null) {
            actor.setLocation ( actor.getX(), actor.getY() + speed );
       }
       if (atTurningPoint()) {
            speed = -speed;
       }
    }
    public boolean shooting()
    {
        if(shootingCounter <= 0 && direction ==1)
        {
            getWorld().addObject(new pelorm1(), getX()+15, getY());
            shootingCounter = 80;
            return true;
        }
        return false;
    }
    
    /**
     * Test if we are at one of the turning points.
     */
    public boolean atTurningPoint()
    {
        return (getY() <= upTurn || getY() >= downTurn);
    }
}