import greenfoot.*;

public class MyWorld extends World{
    public MyWorld(){    
        super(800, 600, 1); 
        prepare();
    }
    
    public void prepare(){
        Character character = new Character();
        addObject(character,400,90);
    }
}
