package com.solsys.game;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.*;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Array;

public class SolSysTest implements ApplicationListener {
	static Stage stage;

	@Override
	public void create() {
		stage = new Stage();
		Gdx.input.setInputProcessor(stage);
		Sun sun = new Sun();
		final Earth earth = new Earth();
		final Mars mars = new Mars();
		final Moon moonActor = new Moon();
		final StartButton button = new StartButton();

		final Action earthOrbiting = Actions.forever(OrbitMovement.actionCircle(Sun.getSunX(),Sun.getSunY(), 150, 1, true, 5, 5));
		final Action marsOrbiting = Actions.forever(OrbitMovement.actionCircle(Sun.getSunX(),Sun.getSunY(), 250, 1, true, 10,7));
		final Action moonOrbiting = Actions.forever(OrbitMovement.actionCircle(Earth.getEarthX(),Earth.getEarthY(), 60, 1, true, 3,7));

		earth.addAction(earthOrbiting);
		mars.addAction(marsOrbiting);
		moonActor.addAction(moonOrbiting);

		button.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				Array<Action> earthActions = earth.getActions();
				Array<Action> marsActions = mars.getActions();
				Array<Action> moonActions = moonActor.getActions();

				if (earthActions.contains(earthOrbiting, true)) {
					earthActions.removeValue(earthOrbiting, true);
					marsActions.removeValue(marsOrbiting, true);
					moonActions.removeValue(moonOrbiting, true);
				} else {
					earth.addAction(earthOrbiting);
					mars.addAction(marsOrbiting);
					moonActor.addAction(moonOrbiting);
				}
			}});

		stage.addActor(sun);
		stage.addActor(button);
		stage.addActor(earth);
		stage.addActor(mars);
		stage.addActor(moonActor);
	}

	@Override
	public void dispose() {
		stage.dispose();
	}

	@Override
	public void render() {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stage.act(Gdx.graphics.getDeltaTime());
		stage.draw();
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void pause(){
	}

	@Override
	public void resume() {
	}

}
