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

    //Hello Tasin, I have created the class TyleType according to the problem statement, please check that too in case I missed anything. You may need to convert
    //it later to an ENUM and convert the int[][] map to a *insert enum name*[][] map, but don't focus on that for now.
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

    public boolean protectsPlayer(int x, int y){
        return map[x][y]== TileType.SHIELD;
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

    /**
     * Checks whether the entity provided as a parameter can move to the specified tile
     * with coordinates x and y.
     * The method first checks if the movement is out of bounds, then if it is a wall.
     * As a special rule, if the tile is the exit and the player does not have the key, then it cannot move there yet.
     *
     * @param o is the entity that wants to move
     * @param x is the x coordinate to which the entity wants to move
     * @param y is the y coordinate to which the entity wants to move
     * @author Tiberiu-Theodor Circiu
     */



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

    /**
     * Handles the movement of an entity within the map matrix.
     * This method first saves the tile that was under the entity in the old position of said entity,
     * then it proceeds to check whether it is a Player or an Enemy.
     * The player is able to pick up collectibles(Key,Shield,Potion), while the enemies should not interfere with those,
     * as not to steal those from the player.
     * At the end, the method sets the value of coordinates x and y according to which type of entity wishes to move on said tile
     *
     *
     * @param o is the entity that wants to move
     * @param x is the x coordinate to which the entity wants to move
     * @param y is the y coordinate to which the entity wants to move
     * @author Tiberiu-Theodor Circiu
     */


    public void moveTo(GameObject o, int x, int y){
        int objectX = o.getX();
        int objectY = o.getY();
        map[objectX][objectY] = o.getTileUnder();

        if(o instanceof Player) {
            int targetTile = map[x][y];
            if(targetTile == TileType.KEY || targetTile == TileType.SHIELD || targetTile == TileType.POTION){
                o.setTileUnder(TileType.GROUND);
            }
            else {
                o.setTileUnder(targetTile);
            }
        }
        else {
            o.setTileUnder(map[x][y]);
        }

        if(o instanceof Player) {
            map[x][y] = TileType.PLAYER;
        }
        else {
            map[x][y] = TileType.ENEMY;
        }

        o.setX(x);
        o.setY(y);
    }

}
