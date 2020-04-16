
public class C implements I1, I2{
    public static int f1c = 0;
    public static int f2c = 0;

    public void f1(){
        f1c++;
        System.out.println(f2c);
    }

    public void f2(){
        f2c++;
        System.out.println(f1c);
    }
}