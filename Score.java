import greenfoot.*;

public class Score extends Actor{
    private int points;//total de pontos
    private int pointsToWin;//quantidade de pontos necessarios para vencer o jogo
    
    public Score(){
        pointsToWin = 500;
        initialize();
    }
    
    /**reseta o placar*/
    public void initialize(){
        points = 0;
        resetImage();
    }
    
    public void pointsUp(int points){
        this.points += points;
        resetImage();
    }
    
    private void resetImage(){
        setImage(new GreenfootImage("Placar: " + points,20,Color.BLUE,Color.WHITE));
    }
    
    public boolean wonTheGame(){
        return points >= pointsToWin;
    }
}