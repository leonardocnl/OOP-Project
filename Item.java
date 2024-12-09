import greenfoot.*;

public class Item extends Actor {
    private static int velocity;

    public Item() {
        velocity = 3;
    }
    
    public void act() {
        MyWorld world = (MyWorld) getWorld();
        
        if (world.gameStillRunning()) {
            moveUp();
            outOfScreen();
        }
    }
    
    private void moveUp() {
        setLocation(getX(), getY() - velocity);
    }
    
    private void outOfScreen() {
        if (getY() < 10) {
            getWorld().removeObject(this);
        }
    }
}
