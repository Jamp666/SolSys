package com.solsys.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Mars extends Actor {
    private Texture texture = new Texture(Gdx.files.internal("mars.png"));

    @Override
    public void draw(Batch batch, float alpha){
        batch.draw(texture,this.getX(),getY());
    }
}




