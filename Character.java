import greenfoot.*;

public class Character extends Actor{
    private int velocity; //velocidade de movimento do personagem
    private boolean stillAlive; //indica se o personagem está vivo
    private static GreenfootSound deathAudio; //som tocado quando o personagem morre
    private String characterDirection; //direção atual do personagem "left" ou "right"
    
    /**garante que os atributos vão ser inicializados corretamente*/
    public Character(){
        velocity = 6;
        deathAudio = new GreenfootSound("deathGTA.wav");
        deathAudio.setVolume(50);
        initialize();
        characterDirection = "right";
        setImage("Character right.png");
    }

    /**verifica se o personagem está vivo. Permite a movimentação e interação com outros atores*/
    public void act(){
        if (stillAlive && ((MyWorld)getWorld()).gameStillRunning()){
            characterMovement();
            checkItemColision();
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
    
    /**controla o movimento do personagem*/
    private void characterMovement(){
        if(Greenfoot.isKeyDown("left")){
            moveLeft();
        } else if(Greenfoot.isKeyDown("right")){
            moveRight();
        }
    }
    
    /**move o personagem para a direita*/
    private void moveRight(){
        if(stillAlive){
            setLocation(getX() + velocity, getY());
            if (!characterDirection.equals("right")){
                setImage("Character right.png");
                characterDirection = "right";
            }
        }
    }
    
    /**move o personagem para a esquerda*/
    private void moveLeft(){
        if(stillAlive){
            setLocation(getX() - velocity, getY());
            if (!characterDirection.equals("left")){
                setImage("Character left.png");
                characterDirection = "left";
            }
        }
    }
    
    /**Verifica colisão com intens e altera o placar*/
    private void checkItemColision(){
        Item item = (Item) getOneIntersectingObject(Item.class);
        if(item != null){
            getWorld().removeObject(item);
            ((MyWorld)getWorld()).addPoints(50);
        }
    }
    
    /**mata o personagem*/
    public void die(){
        if (stillAlive){
            stillAlive = false;
            //troca a imagem, acho que não temos
            deathAudio.play();
            ((MyWorld)getWorld()).endGame();
        }
    }
}
