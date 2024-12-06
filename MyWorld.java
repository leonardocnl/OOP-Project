import greenfoot.*;

public class MyWorld extends World{
    private int treeSpawnTimer;
    private int treeVelocity;
    private int treeSpawnVelocity;
    private int rockSpawnTimer;
    private int rockVelocity;
    private int rockSpawnVelocity;
    private int randomX;
    private boolean gameStillRunning;
    
    public MyWorld(){    
        super(800, 600, 1); 
        initialize();
    }
    
    public void act(){
        if (gameStillRunning()){
            treeSpawn();
            rockSpawn();
        } else {
            restartCheck();
        }
    }
    
    private void initialize(){
        treeSpawnTimer = 0;
        treeVelocity = 8;
        rockSpawnTimer = 0;
        rockVelocity = 8;
        treeSpawnVelocity = 25;
        rockSpawnVelocity = 25;
        gameStillRunning = true;
        prepare();
    }
    
    public void prepare(){
        Character character = new Character();
        addObject(character,400,100);
    }
    
    private void treeSpawn(){
        treeSpawnTimer += 1;
        if (treeSpawnTimer >= treeSpawnVelocity){
            randomX = Greenfoot.getRandomNumber(getWidth());
            Tree tree = new Tree();
            addObject(tree, randomX, getHeight() - treeVelocity);
            treeSpawnTimer = 0;
        }
    }
    
    private void rockSpawn(){
        rockSpawnTimer += 1;
        if (rockSpawnTimer >= rockSpawnVelocity){
            randomX = Greenfoot.getRandomNumber(getWidth());
            Rock rock = new Rock();
            addObject(rock, randomX, getHeight() - rockVelocity);
            rockSpawnTimer = 0;
        }
    }
    
    public boolean gameStillRunning(){
        return gameStillRunning;
    }
    
    public void endGame(){
        gameStillRunning = false;
        showText("Você morreu! Pressione 'R' para reiniciar o jogo.",400,300);
    }
    
    private void clearMessage(){
        showText("",400,300);
    }
    
    private void restartCheck(){
        if (Greenfoot.isKeyDown("r")){
            Character.stopAudio();
            restart();
        }
    }
    
    private void restart(){
        removeObjects(getObjects(null));
        clearMessage();
        initialize();
    }
}
