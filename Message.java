import greenfoot.*;

public class Message extends Actor{
    private GreenfootImage messageImage;
    
    public Message(){
        messageImage = new GreenfootImage(1,1);
        setImage(messageImage);
    }
    
    public void show(String message){
        messageImage.clear();
        messageImage.setFont(new Font("Arial", true, false, 24));
        messageImage.setColor(Color.BLACK);
        messageImage.drawString(message,10,25);
        setImage(messageImage);
    }
    
    public void clear() {
        messageImage.clear();
        setImage(messageImage);
    }
}