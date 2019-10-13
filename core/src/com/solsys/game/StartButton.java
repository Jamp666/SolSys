package com.solsys.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class StartButton extends Actor {
    private Texture texture = new Texture(Gdx.files.internal("button.png"));
    float actorX = 1024f / 2 - 50;
    float actorY = 0;

   public StartButton() {
        setBounds(actorX, actorY, texture.getWidth(), texture.getHeight());
    }

    @Override
    public void draw(Batch batch, float alpha) {
        batch.draw(texture, actorX, actorY);
    }

    @Override
    public void act(float delta) {
    }
}

