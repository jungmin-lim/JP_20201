public class Player extends GameObject{
    public static int speedX = 3;

    public Player(int x, int y){
        super(x, y, "starship.png");
        this.dx = 0;
        this.dy = 0;
    }

    public void move(){
        x += dx;
        y += dy;

        if(x < 10){
            x = 10;
        }

        if(x > 740){
            x = 740;
        }
    }
}