package sys;

import java.util.Scanner;
import player.*;

public class Start {
    
    public static void displayRule(){

        System.out.println("---------------------------------------------------------------------");
        System.out.println("|                                Rules                              |");
        System.out.println("|                                                                   |");
        System.out.println("| Each reversi piece has a black side and a white side.             |");
        System.out.println("| On your turn, you place one piece on the board with your color    |"); 
        System.out.println("| facing up. You must place the piece so that an opponent's piece,  |");
        System.out.println("| or a row of opponent's pieces, is flanked by your pieces. All of  |");
        System.out.println("| the opponent's pieces between your pieces are then turned over to |");
        System.out.println("| become your color.                                                |");
        System.out.println("|                                                                   |");
        System.out.println("---------------------------------------------------------------------");
 
        return;
    }

    public static void setPlayerName(Player1 p1, Player2 p2){
        Scanner input = new Scanner(System.in);

        System.out.print("Enter Player 1's name: ");
        p1.setName(input.nextLine());
        System.out.print("Enter Player 2's name: ");
        p2.setName(input.nextLine());
        return;
    }

    public static void displayStart(){

        System.out.println("---------------------------------------------------------------------");
        System.out.println("|                                                                   |");
        System.out.println("|                               START                               |");
        System.out.println("|                                                                   |");
        System.out.println("---------------------------------------------------------------------");

        return;
    }
}