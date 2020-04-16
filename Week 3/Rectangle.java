
public class Rectangle{
    public int width;
    public int height;

    public int getArea(){
        return width * height;
    }

    public void show(){
        for(int i = 0; i < height; ++i){
            for(int j = 0; j < width; ++j){
                System.out.print("*");
            }
            System.out.print("\n");
        }
    }
}