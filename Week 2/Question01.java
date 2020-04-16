import java.util.Scanner;

public class Question01{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int x = input.nextInt();
        int result = x*x - 3*x + 7;
        System.out.println(result);
        input.close();
    }
}