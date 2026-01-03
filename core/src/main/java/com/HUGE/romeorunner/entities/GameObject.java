package com.HUGE.romeorunner.entities;

import com.HUGE.romeorunner.entities.actions.Orientation;
import com.HUGE.romeorunner.map.TileType;

/**
 * Romeo Runner - GameObject entity
 *
 * This class represents the super class of the movable entities within the game.
 * It stores the x and y coordinate in the map matrix and also the orientation and tile underneath.
 * Orientation is useful for the movement of the entity, for example the slip() mechanic for the Player.
 * Storing the tile currently underneath the entity is useful for moving smoothly within the maze.
 *
 * @author Tiberiu-Theodor Circiu
 */


public abstract class GameObject {
    protected int x, y;
    protected Orientation orientation;
    protected int tileUnder = TileType.GROUND;

    public GameObject(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
    public int getTileUnder(){
        return tileUnder;
    }
    public void setTileUnder(int tileUnder){
        this.tileUnder = tileUnder;
    }

}
