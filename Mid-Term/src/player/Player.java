package player;

import sys.*;
public abstract class Player {
    protected String username;
    protected int score = 2;
    
    public void setName(String name){
        this.username = name;
    }

    public String getName(){
        return this.username;
    }
    
    public int getScore(){
        return this.score;
    }
    public abstract boolean isPlayable();
    public abstract boolean isPlacable(int y, int x);
    public abstract boolean checkVec(int y, int x, int i);
    public abstract void placePoint(int y, int x);
}