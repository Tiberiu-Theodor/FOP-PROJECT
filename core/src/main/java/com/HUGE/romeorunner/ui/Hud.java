package com.HUGE.romeorunner.ui;

import com.HUGE.romeorunner.entities.Player;
import com.HUGE.romeorunner.map.MapLayout;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ScreenViewport;


public class Hud {
    private Stage stage;
    private Table table;

    private Label healthLabel;
    private Label keyLabel;
    private Label timerLabel;
    private Image arrow;
    Texture arrowTexture = new Texture("arrow.png");

    public Hud(SpriteBatch batch){

        this.stage = new Stage(new ScreenViewport(), batch);
        this.table = new Table();
        table.top();
        table.setFillParent(true);

        //ONLY TEMPORARY
        this.healthLabel = new Label("Health: 3", new Label.LabelStyle());
        this.keyLabel = new Label("Key: NO", new Label.LabelStyle());
        this.timerLabel = new Label("Timer: 0", new Label.LabelStyle());
        this.arrow = new Image(arrowTexture);
        arrow.setOrigin(Align.center);
        table.add(healthLabel).pad(10);
        table.add(keyLabel).pad(10);
        table.row();
        table.add(arrow).pad(10);
        table.row();
        table.add(timerLabel).pad(10);
        stage.addActor(table);

    }

    public void update(Player player, MapLayout map){
        healthLabel.setText("Health: " + player.getHealth());
        keyLabel.setText("Key: " + (player.hasKey() ? "YES" : "NO"));
        timerLabel.setText("Timer: " + (int)player.getTimer());
        if(player.hasShield()){
            healthLabel.setColor(Color.BLUE);
        }
        else {
            healthLabel.setColor(Color.RED);
        }

        if(!player.hasKey()) {
            int diff_x = map.getKeyX() - player.getX();
            int diff_y = map.getKeyY() - player.getY();
            if (Math.abs(diff_x) > Math.abs(diff_y)) {
                if (diff_x > 0) {
                    arrow.setRotation(0);
                } else arrow.setRotation(180);
            } else {
                if (diff_y > 0) {
                    arrow.setRotation(90);
                } else arrow.setRotation(270);
            }
        }
        else {
            int diff_x = map.getExitX() - player.getX();
            int diff_y = map.getExitY() - player.getY();
            if(Math.abs(diff_x) > Math.abs(diff_y)) {
                if (diff_x > 0) {
                    arrow.setRotation(0);
                }
                else arrow.setRotation(180);
            } else  {
                if (diff_y > 0) {
                    arrow.setRotation(90);
                }
                else arrow.setRotation(270);
            }
        }
    }

    public void draw(){
        stage.draw();
    }

    public void dispose(){
        stage.dispose();
        arrowTexture.dispose();
    }

}
