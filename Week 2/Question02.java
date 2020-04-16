import java.util.Scanner;
public class Question02{
    public static void main(String[] args){
        String words[] = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        Scanner input = new Scanner(System.in);
        int index = input.nextInt();

        System.out.println(words[index]);
        input.close();

    }
}