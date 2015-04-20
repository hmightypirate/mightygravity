package com.ludum.mighty.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.ludum.mighty.game.MightyGame;
import com.ludum.mighty.settings.Commons;

public class DesktopLauncher {
	public static void main (String[] arg) {
		
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.title = "MightyPirate";
		//cfg.useGL30 = true;
		cfg.width = Commons.WORLD_WIDTH;
		cfg.height = Commons.WORLD_HEIGHT;
		
		new LwjglApplication(new MightyGame(), cfg);
		
	}
}
