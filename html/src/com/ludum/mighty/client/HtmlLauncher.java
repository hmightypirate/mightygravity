package com.ludum.mighty.client;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.backends.gwt.GwtApplication;
import com.badlogic.gdx.backends.gwt.GwtApplicationConfiguration;
import com.ludum.mighty.game.MightyGame;
import com.ludum.mighty.settings.Commons;

public class HtmlLauncher extends GwtApplication {

        @Override
        public GwtApplicationConfiguration getConfig () {
                return new GwtApplicationConfiguration(Commons.WORLD_WIDTH, Commons.WORLD_HEIGHT);
        }

        @Override
        public ApplicationListener getApplicationListener () {
                return new MightyGame();
        }
}