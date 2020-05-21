import sys.*;

import java.io.IOException;
import java.util.Scanner;

public class Week8 {

    public static void main(String args[])
        throws InterruptedException {
        Scanner input = new Scanner(System.in);
        String adr;
        int mod, port;

        System.out.println("<<<  Modes  >>>");
        System.out.println("1. Offline Match");
        System.out.println("2. Open server for Online match");
        System.out.println("3. Participate Online match");

        System.out.print("Choose mode to play(-1 to quit): ");
        mod = input.nextInt();
        adr = input.nextLine();


        Sys s = new Sys();
        if(mod == 1){
            s.run();
        }
        else if(mod == 2){
            System.out.print("Enter Port number of Server to open: ");
            port = input.nextInt();
            s.run(port);
        }
        else if(mod == 3){
            System.out.print("Enter IP address of server player to enter match: ");
            adr = input.nextLine(); 
            System.out.print("Enter Port number of server to enter match: ");
            port = input.nextInt();
            s.run(adr, port);
        }
        else if(mod == -1){
            return;
        }
        else{
            System.out.println("No such mode.");
            return;
        }
        return;
    }
}
