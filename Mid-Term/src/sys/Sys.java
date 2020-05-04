package sys;

import player.*;

import java.util.Scanner;

public class Sys {
    
    // true : Player 1, false: Player 2
    public boolean turn = true;

    // For Alternative Screen
    // Not Working on Windows... 
    /*
    protected void startAltScreen(){
        System.out.print("\033[?1049h\033[H"); 
    }

    protected void quitAltScreen(){
        System.out.print("\033[?1049l");
    }

    protected void clearAltScreen(){
        System.out.println("\033[H\033[2J");
    }
    */

    public void nextTurn(){
        this.turn = !this.turn;
    }

    public void playGame()
        throws InterruptedException{

        Scanner input = new Scanner(System.in);

        Map m = new Map();
        Player1 p1 = new Player1();
        Player2 p2 = new Player2();

        int x, y;

        m.initMap();
        // this.startAltScreen();
        // this.clearAltScreen();

        Start.displayRule();

        Start.setPlayerName(p1, p2);
        p1.setOpponent(p2);
        p2.setOpponent(p1);

        // this.clearAltScreen();
        Start.displayStart();

        while((this.turn? p1:p2).isPlayable()){

            // this.clearAltScreen();

            m.displayMap();

            System.out.print("\n\n");
            System.out.print((this.turn? p1 : p2).getName()+ "\'s turn, enter point to place (ex: 4 5): ");
            
            y = input.nextInt();
            x = input.nextInt();

            while(!((this.turn? p1 : p2).isPlacable(y, x))){
                System.out.print("Cannot place here enter another place: ");
                y = input.nextInt();
                x = input.nextInt();
            }

            (this.turn? p1 : p2).placePoint(y, x);
            this.nextTurn();
        }

        // this.clearAltScreen();
        m.displayMap();
        System.out.println("\nGame Over");

        if(p1.compareTo(p2) > 0){
            System.out.println("Congratulation, " + p1.getName() + " won!");
        }
        else if(p1.compareTo(p2) == 0){
            System.out.println("Draw");
        }
        else{
            System.out.println("Congratulation, " + p2.getName() + " won!");
        }

        Thread.sleep(2000);
        // this.quitAltScreen();
        input.close();
        return;
    }
}