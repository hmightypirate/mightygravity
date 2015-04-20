package com.ludum.mighty.screen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.TimeUtils;
import com.ludum.mighty.assets.PlayerAssets;
import com.ludum.mighty.game.MightyGame;
import com.ludum.mighty.render.ScoreRender;
import com.ludum.mighty.settings.Commons;

/**
 * 
 * @author hector
 *
 */
public class ScoreScreen extends DefaultScreen {

	
	long timeInScreen;

	ScoreRender mightyRender;

	int state;

	OrthographicCamera guiCam;
	SpriteBatch batcher;
	
	PlayerAssets gameAssets = new PlayerAssets();


	/**
	 * 
	 * @param game
	 */
	public ScoreScreen(Game game) {
		super(game);
		// TODO Auto-generated constructor stub


	

		this.guiCam = new OrthographicCamera(Commons.WORLD_WIDTH, 
				Commons.WORLD_HEIGHT);

		this.guiCam.position.set(Commons.WORLD_WIDTH/2, 
				Commons.WORLD_HEIGHT/2, 0);

		this.batcher = new SpriteBatch();


		this.gameAssets.load();
		
		this.mightyRender = new ScoreRender(batcher, gameAssets, Commons.WORLD_WIDTH, 
				Commons.WORLD_HEIGHT);	
		
		this.timeInScreen = TimeUtils.millis();
	}

	

	public void updatePad()
	{
		if ((TimeUtils.millis() - this.timeInScreen) > 4000)
		{
		
		if (Gdx.input.isTouched()|| Gdx.input.isKeyPressed(Keys.ANY_KEY))
		{

			this.mightyGame.setScreen(new InfiniteGameScreenWithRender(this.mightyGame));
		
		}
		}
	
	}


	/**
	 * 
	 * @param deltaTime
	 */
	public void update(float deltaTime)
	{
		if (deltaTime > 0.1f) deltaTime = 0.1f;

		updatePad();
	}

	/**
	 * 
	 * @param deltaTime
	 */
	public void draw(float deltaTime)
	{
		GL20 gl = Gdx.gl;
		gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		MightyGame game = (MightyGame) this.mightyGame;
		this.mightyRender.render(game.getLastScore(), game.getHighScore());

	}


	@Override
	public void render(float delta)
	{
		update(delta);
		draw(delta);
	
	}


}
