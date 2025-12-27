package com.HUGE.romeorunner.map;

import com.HUGE.romeorunner.entities.Player;

public class MapLayout {

    private int[][] map;

    //Hello Tasin, I have realised something while creating my Player class, Ground and Wall were just meant as placeholders, but I advise you to create
    //an enumeration and place them there(look what I did in orientation class), as making a list of walls and ground objects would be way too tedious
    //Instead, try to focus on creating a MATRIX using integers in this class. I just created it for now so that I can use it in Player class. Thank you.
    //Also, we must agree(yes, all of us) on what each value in the matrix map will be. For example 0 = player, -1 = spikes, 1 = ground etc. Please think about that too.
    //For now, for simplicity we will use: player = 0, free space/ground = 1, wall = 2, key = 3, healing potion = 4, enemy1 = -1, enemy2 = -2, enemy3 = -3.

    public int[][] getMap() {
        return map;
    }

    public void setMap(int[][] map) {
        this.map = map;
    }

    public boolean doesDamage(int x, int y){
        return map[x][y]==-1 || map[x][y]==-2 || map[x][y]==-3;
    }

    public boolean healsPlayer(int x, int y){
        return map[x][y]==4;
    }

    public boolean canMoveTo(int x, int y){
        if(x<0 || y<0 || x>=map.length || y>=map[0].length){
            return false;
        }
        return map[x][y] != 2;
    }

    public void moveTo(Player player, int x, int y){
        int playerX = player.getPosition_x();
        int playerY = player.getPosition_y();
        map[playerX][playerY] = map[x][y];
        map[x][y] = 0;
        player.setPosition_x(x);
        player.setPosition_y(y);
    }

}
