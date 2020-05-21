package sys;

import java.io.IOException;
import java.util.Scanner;

public class Sys {

    public void run(){
        Offline o = new Offline();
        o.playGame();
    }

    public void run(int port){
        Server s = new Server();
        try{
            s.playGame(port);
        }catch(IOException e){
            System.err.println("I/O error");
        }
    }

    public void run(String adr, int port){
        Client c = new Client();
        try{
            c.playGame(adr, port);
        }catch(IOException e){
            System.err.println("I/O error");
        }
    }
}