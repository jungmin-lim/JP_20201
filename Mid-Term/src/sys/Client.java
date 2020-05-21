package sys;

import player.*;

import java.net.*;
import java.io.*;
import java.util.Scanner;

public class Client extends Thread{

    private Socket socket = null;
    private BufferedReader in = null;
    private PrintWriter out = null;

    public boolean turn = false;

    public void nextTurn(){
        this.turn = !this.turn;
    }

    public void playGame(String addr, int port)
        throws IOException{

        Scanner input = new Scanner(System.in);
        Scanner convert = null; 

        Map m = new Map();
        Player1 p1 = new Player1();
        Player2 p2 = new Player2();

        String line = "";
        int x, y;

        try{
            socket = new Socket(addr, port);
            System.out.println("Connected");
        
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
        }catch(UnknownHostException e){
            System.err.println("Cannot access host");
            throw e;
        }catch(IOException e){
            System.err.println("I/O error");
            throw e;
        }

        m.initMap();

        Start.displayRule();

        System.out.println("Wating for Player 1 to choose name...");
        line = in.readLine();
        p1.setName(line);

        System.out.print("Enter your name: ");
        line = input.nextLine();
        p2.setName(line);
        out.println(line);

        p1.setOpponent(p2);
        p2.setOpponent(p1);
        
        Start.displayStart();

        while((this.turn? p2 : p1).isPlayable()){

            m.displayMap();

            if(this.turn){  // If Client's turn

                System.out.print("\n\n");
                System.out.print("Your turn, enter point to place (ex: 4 5): ");
            
                y = input.nextInt();
                x = input.nextInt();

                while(!(p2.isPlacable(y, x))){
                    System.out.print("Cannot place here enter another place: ");
                    y = input.nextInt();
                    x = input.nextInt();
                }

                line = (Integer.toString(y) + " " + Integer.toString(x));
                out.println(line);
                p2.placePoint(y, x);
            }

            else{           // If Server's turn
            
                System.out.print("\n\n");
                System.out.println("Waiting for " + p1.getName() + "\'s turn...");

                line = in.readLine();
                convert = new Scanner(line);
                p1.placePoint(convert.nextInt(), convert.nextInt());
            }

            this.nextTurn();
        }

        // Game Over
        try{
            socket.close();
            in.close();
            out.close();
        }catch(UnknownHostException e){
            System.err.println("Cannot access host");
            throw e;
        }catch(IOException e){
            System.err.println("I/O error");
            throw e;
        }

        m.displayMap();
        System.out.println("\nGame Over");

        if(p2.compareTo(p1) > 0){
            System.out.println("Congratulation, You Won!");
        }
        else if(p2.compareTo(p1) == 0){
            System.out.println("Draw");
        }
        else{
            System.out.println("You Lose :(");
        }
             
        input.close();
        return;
    }   
}