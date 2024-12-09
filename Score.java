import greenfoot.*;

public class Score extends Actor{
    private int points;
    private int pointsPerItem;
    
    public Score(){
        pointsPerItem = 100;
        setLocation(100,40);
        initialize();
    }
    
    public void initialize(){
        points = 0;
        resetImage();
    }
    
    public void playerGotItem(){
        points += pointsPerItem;
        resetImage();
    }
    
    private void resetImage(){
        setImage(new GreenfootImage("Placar: " + points,20,Color.BLUE,Color.WHITE));
    }
}