package com.HUGE.romeorunner.map;

public class MapLayout {

    private int[][] map;

    //Hello Tasin, I have realised something while creating my Player class, Ground and Wall were just meant as placeholders, but I advise you to create
    //an enumeration and place them there(look what I did in orientation class), as making a list of walls and ground objects would be way too tedious
    //Instead, try to focus on creating a MATRIX using integers in this class. I just created it for now so that I can use it in Player class. Thank you.
    //Also, we must agree(yes, all of us) on what each value in the matrix map will be. For example 0 = player, -1 = spikes, 1 = ground etc. Please think about that too.


    public int[][] getMap() {
        return map;
    }
    public void setMap(int[][] map) {
        this.map = map;
    }

}
