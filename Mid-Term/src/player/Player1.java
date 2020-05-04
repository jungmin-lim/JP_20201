package player;

import sys.*;

public class Player1 extends Player implements Comparable<Player2>{
    protected Player2 opponent;

    public void setOpponent(Player2 opponent) {
        this.opponent = opponent;
    }

    @Override
    public boolean isPlayable(){
        for(int i = 1; i <= Map.bSize; ++i){
            for(int j = 1; j <= Map.bSize; ++j){
                if(Map.board[i][j] == 0){
                    if(this.isPlacable(i, j)){
                        return true;
                    }
                }
            }
        }
        return false;
    }   

    @Override
    public boolean isPlacable(int y, int x){
        int k = 1;
        if(Map.board[y][x] != 0) return false;
        for(int i = 0; i < 8; ++i){
            if(Map.board[y+Map.vec[i][0]][x+Map.vec[i][1]] == 1){
                k = 1;
                while(Map.board[y+(k*Map.vec[i][0])][x+(k*Map.vec[i][1])] != 3){
                    if(Map.board[y+(k*Map.vec[i][0])][x+(k*Map.vec[i][1])] == 0){
                        break;
                    }
                    if(Map.board[y+(k*Map.vec[i][0])][x+(k*Map.vec[i][1])] == -1){
                        return true;
                    }
                    k++;
                }
            }
        }
        return false;
    }

    @Override
    public boolean checkVec(int y, int x, int i){
        int k = 1;
        if(Map.board[y+Map.vec[i][0]][x+Map.vec[i][1]] == 1){
            while(Map.board[y+(k*Map.vec[i][0])][x+(k*Map.vec[i][1])] != 3){
                if(Map.board[y+(k*Map.vec[i][0])][x+(k*Map.vec[i][1])] == 0){
                   return false;
                }
                else if(Map.board[y+(k*Map.vec[i][0])][x+(k*Map.vec[i][1])] == -1){
                    return true;
                }
                else{
                    k++;
                    continue;
                }
            }
        }
        return false;
    }

    @Override
    public void placePoint(int y, int x){
        int k = 1;
        for(int i = 0; i < 8; ++i){
            if(this.checkVec(y, x, i)){
                k = 1;
                while(Map.board[y+(k*Map.vec[i][0])][x+(k*Map.vec[i][1])] != 3){
                    if(Map.board[y+(k*Map.vec[i][0])][x+(k*Map.vec[i][1])] == -1){
                        // change map
                        Map.board[y][x] = -1;
                        this.score++;
                        for(int j = 1; j < k; ++j){
                            Map.board[y+(j*Map.vec[i][0])][x+(j*Map.vec[i][1])] = -1;
                            opponent.score--;
                        }
                        break;
                    }
                    k++;
                }
            }
        }
    }

    @Override
    public int compareTo(Player2 p2){
        int cmp = this.score - p2.score;
        return cmp;
    }
}