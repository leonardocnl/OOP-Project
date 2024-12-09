import greenfoot.*;

public class Score extends Actor{
    private int points;//total de pontos
    private int pointsPerItem;//quantidade de pontos ganhos ao coletar um item
    private int pointsToWin;//quantidade de pontos necessarios para vencer o jogo
    
    public Score(){
        pointsPerItem = 100;
        setLocation(100,40);
        initialize();
    }
    
    /**reseta o placar*/
    public void initialize(){
        points = 0;
        pointsToWin = 500;
        resetImage();
    }
    
    /**incrementa os pontos e atualiza a o que é mostrado na tela*/
    public void playerGotItem(){
        points += pointsPerItem;
        resetImage();
    }
    
    /**atualiza a imagem do placar*/
    private void resetImage(){
        setImage(new GreenfootImage("Placar: " + points,20,Color.BLUE,Color.WHITE));
    }
    
    public boolean wonTheGame(){
        return points >= pointsToWin;
    }
}