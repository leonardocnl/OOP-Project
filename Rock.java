import greenfoot.*;

public class Rock extends Actor
{
    public Rock(){
        
    }
    
    public void act(){
        moveUp();
        playerHitRock();
        outOfScreen();
    }
    
    private void moveUp(){
        setLocation(getX(), getY() - 8);
    }
    
    private void playerHitRock(){
        Actor character = getOneIntersectingObject(Character.class);
        if (character != null){
            //tocar trilha sonora
            //parar o jogo
            //dar opção de recomeçar
        }
    }
    
    private void outOfScreen(){
        if (getY() < 10){
            getWorld().removeObject(this);
        }
    }
}