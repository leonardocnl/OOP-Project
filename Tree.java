import greenfoot.*;

public class Tree extends Actor
{   
    public Tree(){
        
    }
    
    public void act(){
        moveUp();
        playerHitTree();
        outOfScreen();
    }
    
    private void moveUp(){
        setLocation(getX(), getY() - 8);
    }
    
    private void playerHitTree(){
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
