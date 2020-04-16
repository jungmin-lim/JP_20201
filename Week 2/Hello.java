import java.util.Scanner;

public class Hello{
    public static void main(String[] args){
        System.out.println("name, city, age, weight");
        Scanner input = new Scanner(System.in);
        String name = input.next();
        System.out.println(name);
        String city = input.next();
        System.out.println(city);
        int age = input.nextInt();
        System.out.println(age);
        float weight = input.nextFloat();
        System.out.println(weight);
        input.close();
    }
}