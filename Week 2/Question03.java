import java.util.Scanner;
public class Question03{

    public static void modifyArray(int array[]){
        for(int i = 0; i < array.length; ++i){
            if(array[i] >= 10){
                array[i] = 0;
            }
        }
    }

    public static void printArray(int array[]){

        for(int i = 0; i < array.length; ++i){
            System.out.println(array[i]);
        }
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int length = input.nextInt();
        int array[] = new int[length];

        for(int i = 0; i< length; ++i){
            array[i] = input.nextInt();
        }

        modifyArray(array);
        printArray(array);
        input.close();
    }
}