
public class Triangle {
    public int width;
    public int height;

    public double getArea(){
        return (width * height / 2.0 );
    }

    public void show(){
        for(int i = 0; i < height; ++i ){
            for(int j = 0; j < ((i+1) * width / height); ++j){
                System.out.print("*");
            }
            System.out.print("\n");
        }
    }
}