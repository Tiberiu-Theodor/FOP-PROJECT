package com.HUGE.romeorunner;

import com.HUGE.romeorunner.ui.GameScreen;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Romeo Runner - Main Class
 * This class is responsible for holding the SpriteBatch and switching between
 * screens during gameplay.
 *
 * @author Tiberiu-Theodor Circiu
 */

public class Main extends Game {
    public SpriteBatch batch;

    @Override
    public void create() {
        batch = new SpriteBatch();
        this.setScreen(new GameScreen(this));
    }

    @Override
    public void render() {
        super.render();
    }

    @Override
    public void dispose() {
        batch.dispose();
    }
}
