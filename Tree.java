import greenfoot.*;

public class Tree extends Actor{
    private static int velocity;
    public Tree(){
        velocity = 8;
    }
    
    public void act(){
        MyWorld world = (MyWorld)getWorld();
        
        if(world.gameStillRunning()){
            moveUp();
            playerHitTree();
            outOfScreen();
        }
    }
    
    private void moveUp(){
        setLocation(getX(), getY() - velocity);
    }
    
    private void playerHitTree(){
        Actor character = getOneIntersectingObject(Character.class);
        if (character != null){
            ((Character) character).die();
        }
    }
    
    private void outOfScreen(){
        if (getY() < 10){
            getWorld().removeObject(this);
        }
    }
}
