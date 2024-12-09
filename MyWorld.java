import greenfoot.*;

public class MyWorld extends World{
    private int treeSpawnTimer;
    private int treeVelocity;
    private int treeSpawnVelocity;
    private int rockSpawnTimer;
    private int rockVelocity;
    private int rockSpawnVelocity;
    private int itemSpawnTimer;
    private int itemVelocity;
    private int itemSpawnVelocity;
    private int randomX;
    private Score score;
    private boolean gameStillRunning;
    
    public MyWorld(){    
        super(800, 600, 1); 
        initialize();
    }
    
    public void act(){

        if (gameStillRunning()){
            if (score.wonTheGame()){
                win();
            } else {
                treeSpawn();
                rockSpawn();
                itemSpawn();
            }
        } else {
            restartCheck();
        }
    }
    
    private void initialize(){
        treeSpawnTimer = 0;
        treeVelocity = 6;
        treeSpawnVelocity = 30;
        rockSpawnTimer = 0;
        rockVelocity = 6;
        rockSpawnVelocity = 30;
        itemSpawnTimer = 0;
        itemVelocity = 0;
        itemSpawnVelocity = 125;
        gameStillRunning = true;
        prepare();
    }
    
    public void prepare(){
        score = new Score();
        addObject(score,40,20);
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
    
    private void itemSpawn(){
        itemSpawnTimer += 1;
        if (itemSpawnTimer >= itemSpawnVelocity){
            randomX = Greenfoot.getRandomNumber(getWidth());
            Item strawberry = new Item();
            addObject(strawberry, randomX, getHeight() - itemVelocity);
            itemSpawnTimer = 0;
        }
    }
    
    public boolean gameStillRunning(){
        return gameStillRunning;
    }
    
    public Score getScore(){
        return score;
    }
    
    public void win(){
        gameStillRunning = false;
        showText("Parabéns, você venceu! Pressione 'R' para reiniciar o jogo", 400,300);
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
