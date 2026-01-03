package com.HUGE.romeorunner.ui;

import com.HUGE.romeorunner.Main;
import com.HUGE.romeorunner.entities.Player;
import com.HUGE.romeorunner.map.MapLayout;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;

/**
 * Romeo Runner - GameScreen class
 * This class handles the main screen of the Romeo Runner Game.
 *
 * It loads up .... ( To be completed later )
 *
 * @author Tiberiu-Theodor Circiu
 */



public class GameScreen implements Screen {

    private final Main game;
    private MapLayout map;
    private Player player;
    private Hud hud;

    private Texture wallT,groundT,playerT,enemyT,iceT,trapT;

    public GameScreen(Main game) {
        this.game = game;

        int[][] testArray = new int[20][20];
        this.map = new MapLayout(testArray);
        this.player = new Player(map,map.getEntryX(),map.getEntryY());
        this.hud = new Hud(game.batch);

    }


    @Override
    public void show() {

    }

    @Override
    public void render(float v) {

    }

    @Override
    public void resize(int i, int i1) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
