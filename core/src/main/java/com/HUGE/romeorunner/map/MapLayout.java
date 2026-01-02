package com.HUGE.romeorunner.map;

import com.HUGE.romeorunner.entities.GameObject;
import com.HUGE.romeorunner.entities.Player;

public class MapLayout {

    private int[][] map;
    private int keyX;
    private int keyY;
    private int exitX;
    private int exitY;
    private int entryX;
    private int entryY;

    //Hello Tasin, I have created the class TyleType according to the problem statement, please check that too in case I missed anything.
    //Try to focus on working on a MATRIX using integers in this class, as using lists of classes(Ground Wall etc.) would be way too tedious
    //I just created it for now so that I can use it in Player class. Thank you.
    //I have decided that we should have the unique enemy as ICE ( or a banana peel if we want to be funny),
    // something that will use my current move Method on the player :)!

    public MapLayout(int[][] map) {
        this.map = map;
        keyX = findKeyX();
        keyY = findKeyY();
        exitX = findExitX();
        exitY = findExitY();
        entryX = findEntryX();
        entryY = findEntryY();
    }

    public int[][] getMap() {
        return map;
    }

    public void setMap(int[][] map) {
        this.map = map;
    }

    public int getKeyX() {
        return keyX;
    }

    public int getKeyY() {
        return keyY;
    }

    public int getExitX() {
        return exitX;
    }

    public int getExitY() {
        return exitY;
    }

    public int getEntryX() {
        return entryX;
    }

    public int getEntryY() {
        return entryY;
    }


    public boolean doesDamage(int x, int y){
        return map[x][y]== TileType.ENEMY || map[x][y]== TileType.TRAP;
    }

    public boolean healsPlayer(int x, int y){
        return map[x][y]== TileType.POTION;
    }

    public boolean slipsPlayer(int x, int y){
        return map[x][y]== TileType.ICE;
    }

    public int findKeyX(){
        for(int x=0;x<map.length;x++){
            for(int y=0;y<map[x].length;y++){
                if(map[x][y]== TileType.KEY) {
                    return x;
                }
            }
        }
        return -1;
    }

    public int findKeyY(){
        for(int x=0;x<map.length;x++){
            for(int y=0;y<map[x].length;y++){
                if(map[x][y]== TileType.KEY) {
                    return y;
                }
            }
        }
        return -1;
    }

    public int findExitX(){
        for(int x=0;x<map.length;x++){
            for(int y=0;y<map[x].length;y++){
                if(map[x][y]== TileType.EXIT) {
                    return x;
                }
            }
        }
        return -1;
    }

    public int findExitY(){
        for(int x=0;x<map.length;x++){
            for(int y=0;y<map[x].length;y++){
                if(map[x][y]== TileType.EXIT) {
                    return y;
                }
            }
        }
        return -1;
    }

    public int findEntryX(){
        for(int x=0;x<map.length;x++){
            for(int y=0;y<map[x].length;y++){
                if(map[x][y]== TileType.ENTRY) {
                    return x;
                }
            }
        }
        return -1;
    }

    public int findEntryY(){
        for(int x=0;x<map.length;x++){
            for(int y=0;y<map[x].length;y++){
                if(map[x][y]== TileType.ENTRY) {
                    return y;
                }
            }
        }
        return -1;
    }

    public boolean canMoveTo(GameObject o, int x, int y){
        if(x<0 || y<0 || x>=map.length || y>=map[0].length){
            return false;
        }
        int targetTile = map[x][y];
        if(targetTile == TileType.WALL){
            return false;
        }
        if(targetTile == TileType.EXIT && (o instanceof Player)){
            if(!((Player) o).hasKey()){
                return false;
            }
        }
        return true;
    }

    public void moveTo(GameObject o, int x, int y){
        int objectX = o.getX();
        int objectY = o.getY();
        map[objectX][objectY] = TileType.GROUND;
        switch(o.getClass().getSimpleName()){
            case "Player" -> map[x][y] = TileType.PLAYER;
            case "Enemy" -> map[x][y] = TileType.ENEMY;
        }
        o.setX(x);
        o.setY(y);
    }

}
