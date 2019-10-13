package com.solsys.game;

import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.actions.TemporalAction;

public class OrbitMovement extends TemporalAction {
    private Vector2 start;
    private float r1;
    private float r2;
    private float startAngle;
    private float direction;
    private boolean toRotate;

    public static OrbitMovement actionCircle(float x, float y, float r, float direction, boolean rotate, float duration, float startAngle)
    {
        return actionEllipse(x,y,r,r,direction,rotate,duration,Interpolation.linear,startAngle);
    }

    public static OrbitMovement actionEllipse(float x, float y, float r1, float r2,
                                              float direction, boolean rotate, float duration, Interpolation interpolation, float angle) {

        OrbitMovement action = new OrbitMovement();
        action.setR(r1, r2);
        action.setDuration(duration);
        action.setPosition(x, y);
        action.setDirection(direction);
        action.setRotate(rotate);
        action.setInterpolation(interpolation);
        action.setStartAngle(angle);
        return action;
    }

    protected void setRotate(boolean rotate)
    {
        toRotate = rotate;
    }

    protected void setDirection(float dir)
    {
        direction = -dir;
    }

    protected void setPosition(float x, float y)
    {
            start = new Vector2(x, y);
    }

    protected void setStartAngle(float angle)
    {
        startAngle = angle;
    }

    protected void update (float percent) {
        float angle = (float)(Math.PI*2*(direction*percent/1f)) + startAngle;
        if (actor instanceof Moon){
            actor.setPosition((Earth.getEarthX()+20) + r1*(float)Math.cos(angle), (Earth.getEarthY()+20) + r2*(float)Math.sin(angle));
        }
        else {
            actor.setPosition(start.x + r1 * (float) Math.cos(angle), start.y + r2 * (float) Math.sin(angle));
        }
    }

    public void setR (float r1, float r2)
    {
        this.r1=r1;
        this.r2=r2;
    }
}