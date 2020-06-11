public class Alien extends GameObject{
    public static int speedX = 3;
    public static int speedY = 20;

    public Alien(int x, int y){
        super(x, y, "alien.png");
        this.dx = -speedX; 
        this.dy = speedY;
    }

    public void move(){
        x += dx;

        if(((dx < 0) && (x < 10)) || ((dx > 0) && (x > 740))){
            dx = -dx;
            y += dy;
        }
    }

    public boolean isOutOfScreen(){
        if(y > 600) return true;
        else return false;
    }
}