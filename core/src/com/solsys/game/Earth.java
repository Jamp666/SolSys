package com.solsys.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Earth extends Actor {
    private Texture texture = new Texture(Gdx.files.internal("earth.png"));
    private static float X;
    private static float Y;

    @Override
    public void draw(Batch batch, float alpha){
        batch.draw(texture,this.getX(),this.getY());
        X=this.getX();
        Y=this.getY();
    }

    public static float getEarthX(){
        return X;
    }
    public static float getEarthY(){
        return Y;
    }
}
