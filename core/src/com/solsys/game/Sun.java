package com.solsys.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Sun extends Actor {
    private Texture texture = new Texture(Gdx.files.internal("sun.png"));
    private static float X = 1024f/2-50 ;
    private static float Y = 768f/2-25 ;

    @Override
        public void draw(Batch batch, float alpha){
        batch.draw(texture, X, Y);
        }

    public static float getSunX() {
        return X;
    }
    public static float getSunY() {
        return Y;
    }
}
