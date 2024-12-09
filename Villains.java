import greenfoot.*;

public class Villains extends Actor{
    private int velocity;
    
    public Villains(int velocity){
        this.velocity = velocity;
    }
    
    public void act(){
        MyWorld world = (MyWorld)getWorld();
        if(world.gameStillRunning()){
            moveUp();
            checkCollision();
            getOutOfScreen();
        }
    }
    
    private void moveUp(){
        setLocation(getX(),getY() - velocity);
    }
    
    private void checkCollision(){
        Actor character = getOneIntersectingObject(Character.class);
        if(character != null){
            ((Character) character).die();
        }
    }
    
    private void getOutOfScreen(){
        if(getY() < 5){
            getWorld().removeObject(this);        
        }
    }
}