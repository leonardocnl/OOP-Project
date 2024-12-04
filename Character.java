import greenfoot.*;

public class Character extends Actor{
    private int velocity;
    private boolean stillAlive;

    public Character(){
        velocity = 12;
        initialize();
    }

    public void initialize(){
        stillAlive = true;
    }

    public boolean stillAlive() {
        return stillAlive;
    }
    
    public void moveRight(){
        if(stillAlive){
            setLocation(getX() + velocity, getY());
            setImage("Character right.png");
        }
    }
    public void moveLeft(){
        if(stillAlive){
            setLocation(getX()-velocity, getY());
            setImage("Character left.png");
        }
    }
    
    private void getItem(){
        Actor strawberry = getOneIntersectingObject(Item.class);
        if (strawberry != null){
            getWorld().removeObject(strawberry);
        }
    }
    
    public void act(){
        if(Greenfoot.isKeyDown("left")){
            moveLeft();
        }
        if(Greenfoot.isKeyDown("right")){
            moveRight();
        }
        getItem();
    }
}
