import greenfoot.*;

public class InitialSreen extends World{
    public InitialSreen(){    
        super(1000, 600, 1); 
        prepare();
    }
    
    private void prepare(){
        InitialWords initialWords = new InitialWords();
        addObject(initialWords,500,350);
    }

    public void act(){
        if(Greenfoot.isKeyDown("enter")){
            Greenfoot.setWorld(new MyWorld());
        }
    }
}