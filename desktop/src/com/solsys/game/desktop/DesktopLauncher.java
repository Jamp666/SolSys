package com.solsys.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.solsys.game.SolSysTest;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "SolSys";
		config.width = 1024;
		config.height = 768;

		new LwjglApplication(new SolSysTest(), config);
	}
}
