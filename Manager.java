import greenfoot.*;

/**Essa classe serve para gerenciar os atores que são gerados durante a execução do game. [Tree, Rock e Item]*/
public class Manager{
    private MyWorld world;
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
    
    public Manager(MyWorld world){
        this.world = world;
        initialize();
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
    }
    
    public void spawnItems(){
        itemSpawn();
    }
    
    public void spawnVillains(){
        treeSpawn();
        rockSpawn();
    }
    
    private void itemSpawn(){
        itemSpawnTimer++;
        if (itemSpawnTimer >= itemSpawnVelocity) {
            randomX = Greenfoot.getRandomNumber(world.getWidth());
            Item strawberry = new Item();
            world.addObject(strawberry, randomX, world.getHeight() - itemVelocity);
            itemSpawnTimer = 0;
        }
    }
    
    private void treeSpawn(){
        treeSpawnTimer++;
        if (treeSpawnTimer >= treeSpawnVelocity) {
            randomX = Greenfoot.getRandomNumber(world.getWidth());
            Tree tree = new Tree();
            world.addObject(tree, randomX, world.getHeight() - treeVelocity);
            treeSpawnTimer = 0;
        }
    }
    
    private void rockSpawn() {
        rockSpawnTimer++;
        if (rockSpawnTimer >= rockSpawnVelocity) {
            randomX = Greenfoot.getRandomNumber(world.getWidth());
            Rock rock = new Rock();
            world.addObject(rock, randomX, world.getHeight() - rockVelocity);
            rockSpawnTimer = 0;
        }
    }
}