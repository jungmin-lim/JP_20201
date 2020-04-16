
public class Square {
    int length;
    int x, y;

    public Square(){
        this.length = 1;
        this.x = 0;
        this.y = 0;
    }

    public Square(int length, int x, int y){
        this.length = length;
        this.x = x;
        this.y = y;
    }

    public int getArea(){
        return this.length * this.length;
    }

    public void move(int delta_x, int delta_y){
        this.x = this.x + delta_x;
        this.y = this.y + delta_y;
    }

    public void move(int delta){
        this.x = this.x + delta;
        this.y = this.y + delta;
    }

    public boolean increase(int delta){
        int temp = this.length;
        if(temp + delta >= 1){
            this.length = this.length + delta;
            return true;
        }
        else return false;
    }

    public void exchange(Square s){
        int temp;
        
        temp = this.length;
        this.length = s.length;
        s.length = temp;

        temp = this.x;
        this.x = s.x;
        s.x = temp;

        temp = this.y;
        this.y = s.y;
        s.y = temp;
    }

    public Square duplicate(){
        Square duplicated = new Square();

        duplicated.length = this.length;
        duplicated.x = this.x;
        duplicated.y = this.y;
        return duplicated;
    }
}