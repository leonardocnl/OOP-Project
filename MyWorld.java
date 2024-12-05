import greenfoot.*;

public class MyWorld extends World{
    private int treeSpawnTimer;
    private int rockSpawnTimer;
    private int randomX;
    
    public MyWorld(){    
        super(800, 600, 1); 
        prepare();
        treeSpawnTimer = 0;
        rockSpawnTimer = 0;
    }
    
    public void act(){
        treeSpawn();
        rockSpawn();
    }
    
    public void prepare(){
        Character character = new Character();
        addObject(character,400,100);
    }
    
    private void treeSpawn(){
        treeSpawnTimer += 1;
        
        if (treeSpawnTimer >= 25){
            randomX = Greenfoot.getRandomNumber(getWidth());
            Tree tree = new Tree();
            addObject(tree, randomX, getHeight() - 10);
            treeSpawnTimer = 0;
        }
    }
    
    private void rockSpawn(){
        rockSpawnTimer += 1;
        
        if (rockSpawnTimer >= 25){
            randomX = Greenfoot.getRandomNumber(getWidth());
            Rock rock = new Rock();
            addObject(rock, randomX, getHeight() - 10);
            rockSpawnTimer = 0;
        }
    }
}
