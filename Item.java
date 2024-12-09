import greenfoot.*;

public class Item extends Actor {
    private static int velocity; //velocidade de movimento vertical(pra cima) do item

    public Item() {
        velocity = 3;
    }
    
    /**move o item e verifica se ele já saiu da tela*/
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
