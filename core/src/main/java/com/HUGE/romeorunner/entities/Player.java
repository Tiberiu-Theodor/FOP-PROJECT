package com.HUGE.romeorunner.entities;

import com.HUGE.romeorunner.entities.actions.Attack;
import com.HUGE.romeorunner.entities.actions.Direction;
import com.HUGE.romeorunner.entities.actions.Movement;
import com.HUGE.romeorunner.entities.actions.Orientation;
import com.HUGE.romeorunner.map.MapLayout;

public class Player implements Movement, Attack {

    private int position_x;
    private int position_y;
    private Orientation orientation;
    private int health;
    private int maxHealth = 3;
    private MapLayout map;


    public Player(MapLayout map, int position_x, int position_y) {
        this.position_x = position_x;
        this.position_y = position_y;
        this.orientation = Orientation.NORTH;
        this.health = 3;
        this.map = map;
    }

    public int getPosition_x() {
        return position_x;
    }

    public void setPosition_x(int position_x) {
        this.position_x = position_x;
    }

    public int getPosition_y() {
        return position_y;
    }

    public void setPosition_y(int position_y) {
        this.position_y = position_y;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public void check(){

    }

    @Override
    public void move(Direction direction) {
        switch (direction) {
            case UP->{
                if(position_y < map.getMap().length /* && map.isGround(position_x,position_y+1) */) {
                    position_y++;
                    map.getMap()[position_x][position_y-1]=1;
                    map.getMap()[position_x][position_y]=0;
                }
                orientation = Orientation.NORTH;

            }

            case DOWN->{
                position_y--;

                orientation = Orientation.SOUTH;
            }

            case LEFT->{
                position_x--;

                orientation = Orientation.WEST;
            }

            case RIGHT->{
                position_x++;

                orientation = Orientation.EAST;
            }
        }

    }

    @Override
    public void run(Direction direction) {


    }

}
