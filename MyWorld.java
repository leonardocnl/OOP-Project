import greenfoot.*;

public class MyWorld extends World{
    private Score score;
    private boolean gameStillRunning;
    private Manager manager;
    
    public MyWorld(){    
        super(800, 600, 1); 
        initialize();
    }
    
    public void act(){

        if (gameStillRunning()){
            if (score.wonTheGame()){
                win();
            } else {
                manager.spawnItems();
                manager.spawnVillains();
            }
        } else {
            restartCheck();
        }
    }
    
    private void initialize(){
        gameStillRunning = true;
        score = new Score();
        addObject(score,40,20);
        Character player = new Character();
        addObject(player,400,100);
        manager = new Manager(this);
    }
    
    public boolean gameStillRunning(){
        return gameStillRunning;
    }
    
    public void addPoints(int points){
        score.pointsUp(points);
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
