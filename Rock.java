import greenfoot.*;

public class Rock extends Actor {
    private static int velocity;

    public Rock() {
        velocity = 6;
    }
    
    public void act() {
        MyWorld world = (MyWorld) getWorld();
        
        if (world.gameStillRunning()) {
            moveUp();
            playerHitRock();
            outOfScreen();
        }
    }
    
    private void moveUp() {
        setLocation(getX(), getY() - velocity);
    }
    
    private void playerHitRock() {
        Actor character = getOneIntersectingObject(Character.class);
        if (character != null) {
            ((Character) character).die();
        }
    }
    
    private void outOfScreen() {
        if (getY() < 10) {
            getWorld().removeObject(this);
        }
    }
}
