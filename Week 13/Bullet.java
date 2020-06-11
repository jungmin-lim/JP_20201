public class Bullet extends GameObject{
    public static int speedY = 3;

    public Bullet(int x, int y){
        super(x, y, "fire.png");
        this.dx = 0;
        this.dy = -speedY;
    }

    public void move(){
        x += dx;
        y += dy;
    }

    public boolean isOutOfScreen(){
        if (y < 10) return true;
        else return false;
    }
}