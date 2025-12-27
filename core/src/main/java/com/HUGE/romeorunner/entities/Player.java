package com.HUGE.romeorunner.entities;

import com.HUGE.romeorunner.entities.actions.Attack;
import com.HUGE.romeorunner.entities.actions.Direction;
import com.HUGE.romeorunner.entities.actions.Movement;
import com.HUGE.romeorunner.entities.actions.Orientation;
import com.HUGE.romeorunner.map.MapLayout;

/**

 Romeo Runner - Player entity

 This class represents the main character(player) within the game.
 It manages the health, movement and position of the player at any given moment.
 It also implements a short invincibility timeframe after receiving damage.

 This class interacts with {@link MapLayout} to validate the movement and also check for damage or healing effects.
 @author Tiberiu-Theodor Circiu
 */

public class Player implements Movement, Attack {

    private int position_x;
    private int position_y;
    private Orientation orientation;
    private int health;
    private final int maxHealth = 3;
    private MapLayout map;
    private boolean key;
    private float invincibility = 0f;
    private static final float invincibilityDuration = 2.0f;

    /**
     * Constructor of the player class.
     *
     * @param map connects the player to the map
     * @param position_x is the starting x coordinate of the player in the map matrix
     * @param position_y is the starting y coordinate of the player in the map matrix
     */

    public Player(MapLayout map, int position_x, int position_y) {
        this.position_x = position_x;
        this.position_y = position_y;
        this.orientation = Orientation.NORTH;
        this.health = 3;
        this.map = map;
        this.key = false;
    }

    /**
     * The following methods are the getters and setters.
     */

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

    public MapLayout getMap() {
        return map;
    }

    public void setMap(MapLayout map) {
        this.map = map;
    }

    public boolean hasKey() {
        return key;
    }

    public void setKey(boolean key) {
        this.key = key;
    }

    public float getInvincibility() {
        return invincibility;
    }

    public void setInvincibility(float invincibility) {
        this.invincibility = invincibility;
    }


    //TO-DO: clean logic and do not use Player to change Map, instead create methods in map class

    /**
     * Updates the invincibility timer for the player.
     * Handles cooldown.
     *
     * @param delta is time passed since last frame(in seconds)
     */

    public void update(float delta) {
        if(invincibility > 0){
            invincibility -= delta;
        }
    }

    /**
     * Checks whether the tile with the specified coordinates to assess whether it deals damage or heals the player.
     * If the player is dead after it received damage, the game is over.
     *
     * @param x is the x coordinate for the tile that needs to be checked
     * @param y is the y coordinate for the tile that needs to be checked
     */

    public void check(int x, int y){
        if(map.doesDamage(x,y)){
            damage();
        }
        if(map.healsPlayer(x,y) && health<maxHealth){
            heal();
        }
        if(isDead()){
            System.out.println("GAME OVER!");
            // display game over screen and game over sound effect
        }
    }

    /**
     * Deals damage to the player if it is not currently invincible.
     * Activates temporary invincibility after being hit and also displays a cue.
     */

    public void damage(){
        if(invincibility > 0){
            return;
        }

        setHealth(health-1);
        setInvincibility(invincibilityDuration);
        //play invincibility effect after the player turns red
    }

    /**
     * Heals the player if it is possible.
     * Also displays a cue.
     */

    public void heal(){
        if(health<maxHealth) {
            setHealth(health + 1);
            //player turns green and play healing sound
        }
    }

    public boolean isDead(){
        return health<=0;
    }

    public boolean isInvincible(){
        return invincibility > 0;
    }

    /**
     * Moves the player in the given direction if the target tile is walkable.
     * Also checks for damage, healing, and updates orientation.
     *
     * @param direction is the direction in which the player should move
     */

    @Override
    public void move(Direction direction) {
        switch (direction) {

            case UP->{
                if(map.canMoveTo(position_x,position_y+1)) {
                    map.moveTo(this, position_x, position_y+1);
                }
                check(position_x, position_y);
                orientation = Orientation.NORTH;
            }

            case DOWN->{
                if(map.canMoveTo(position_x,position_y-1)) {
                    map.moveTo(this, position_x, position_y-1);
                }
                check(position_x, position_y);
                orientation = Orientation.SOUTH;
            }

            case LEFT->{
                if(map.canMoveTo(position_x-1,position_y)) {
                    map.moveTo(this, position_x-1, position_y);
                }
                check(position_x, position_y);
                orientation = Orientation.WEST;
            }

            case RIGHT->{
                if(map.canMoveTo(position_x+1,position_y)) {
                    map.moveTo(this, position_x+1, position_y);
                }
                check(position_x, position_y);
                orientation = Orientation.EAST;
            }

        }

    }

    /**
     * Moves the player in the given direction twice, simulating running.
     *
     * @param direction is the direction in which the player should run
     */

    public void run(Direction direction) {
        this.move(direction);
        this.move(direction);
    }

}
