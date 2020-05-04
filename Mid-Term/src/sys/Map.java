package sys;

import player.*;

public class Map {

    public static int bSize = 8;
    public static int[][] board = new int[Map.bSize+2][Map.bSize+2];
    public final static int[][] vec = {
        {-1, -1}, {-1, 0}, {-1, 1},
        {0, -1},            {0, 1},
        {1, -1},  {1, 0},   {1, 1},
    };

    public void initMap(){

        for(int i = 1; i <= Map.bSize; ++i){
            for(int j = 1; j <= Map.bSize; ++j){
                Map.board[i][j] = 0;
            }
        }
        Map.board[Map.bSize/2][Map.bSize/2] = 1;
        Map.board[Map.bSize/2][Map.bSize/2+1] = -1;
        Map.board[Map.bSize/2+1][Map.bSize/2] = -1;
        Map.board[Map.bSize/2+1][Map.bSize/2+1] = 1;

        for(int i = 0; i < Map.bSize+2; ++i){
            Map.board[0][i] = 3;
        }
        for(int i = 0; i < Map.bSize+2; ++i){
            Map.board[Map.bSize+1][i] = 3;
        }
        for(int i = 1; i <= Map.bSize; ++i){
            Map.board[i][0] = 3;
            Map.board[i][Map.bSize+1] = 3;
        }
    }

    public void displayMap(){
        System.out.print("\n  ");
        for(int i = 1; i <= Map.bSize; ++i){
            System.out.printf("%2d", i);
        }
        System.out.print("\n");

        for(int i = 1; i <= Map.bSize; ++i){
            System.out.printf("%2d", i);
            for(int j = 1; j <= Map.bSize; ++j){
                if(this.board[i][j] == -1){
                    System.out.print(" B");
                }
                else if(this.board[i][j] == 0){
                    System.out.print(" _");
                }
                else{
                    System.out.print(" W");
                }
            }
            System.out.print("\n");
        }

        return;
    }
}