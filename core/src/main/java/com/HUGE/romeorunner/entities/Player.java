package com.HUGE.romeorunner.entities;

import com.HUGE.romeorunner.entities.actions.Attack;
import com.HUGE.romeorunner.entities.actions.Movement;
import com.HUGE.romeorunner.entities.actions.Orientation;

public class Player implements Movement, Attack {

    private int position_x;
    private int position_y;
    private Orientation orientation;
    private int health;
    private int maxHealth;

    public Player(int position_x, int position_y) {
        this.position_x = position_x;
        this.position_y = position_y;
        this.orientation = Orientation.NORTH;
        this.health = 3;
        this.maxHealth = 3;
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

    @Override
    public void move(Orientation orientation) {

    }

    @Override
    public void run(Orientation orientation) {

    }

}
