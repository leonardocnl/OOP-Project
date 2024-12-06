import greenfoot.*;

public class Character extends Actor{
    private int velocity;
    private boolean stillAlive;
    private static GreenfootSound deathAudio;
    private String characterDirection;
    
    public Character(){
        velocity = 6;
        deathAudio = new GreenfootSound("deathGTA.wav");
        initialize();
        characterDirection = "right";
        setImage("Character right.png");
    }

    public void act(){
        if (stillAlive) {
            characterMovement();
            getItem();
        }
    }
    
    public void initialize(){
        stillAlive = true;
    }
    
    public boolean stillAlive() {
        return stillAlive;
    }
    
    public static void stopAudio(){
        deathAudio.stop();
    }
    
    private void characterMovement(){
        if(Greenfoot.isKeyDown("left")){
            moveLeft();
        } else if(Greenfoot.isKeyDown("right")){
            moveRight();
        }
    }
    
    private void moveRight(){
        if(stillAlive){
            setLocation(getX() + velocity, getY());
            if (!characterDirection.equals("right")){
                setImage("Character right.png");
                characterDirection = "right";
            }
        }
    }
    
    private void moveLeft(){
        if(stillAlive){
            setLocation(getX() - velocity, getY());
            if (!characterDirection.equals("left")){
                setImage("Character left.png");
                characterDirection = "left";
            }
        }
    }
    
    private void getItem(){
        Actor strawberry = getOneIntersectingObject(Item.class);
        if (strawberry != null){
            getWorld().removeObject(strawberry);
        }
    }
    
    public void die(){
        if (stillAlive){
            stillAlive = false;
            //troca a imagem, acho que não temos
            deathAudio.play();
            ((MyWorld)getWorld()).endGame();
        }
    }
}
