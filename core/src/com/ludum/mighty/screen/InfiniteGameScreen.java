package com.ludum.mighty.screen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.ludum.mighty.MightyWorld;
import com.ludum.mighty.settings.Commons;

/**
 * 
 * @author hector
 *
 */
public class InfiniteGameScreen extends DefaultScreen {

	public static final int STATE_INIT = 0;
	public static final int STATE_INTRO = 1;
	public static final int STATE_PLAYING = 2;
	public static final int STATE_ENDSCREEN = 3;

	Box2DDebugRenderer debugRenderer;

	int state;

	OrthographicCamera guiCam;
	SpriteBatch batcher;

	MightyWorld mWorld;

	/**
	 * 
	 * @param game
	 */
	public InfiniteGameScreen(Game game) {
		super(game);
		// TODO Auto-generated constructor stub


		this.state = STATE_INIT;

		this.guiCam = new OrthographicCamera(Commons.WORLD_WIDTH, 
				Commons.WORLD_HEIGHT);

		this.guiCam.position.set(Commons.WORLD_WIDTH/2, 
				Commons.WORLD_HEIGHT/2, 0);

		this.batcher = new SpriteBatch();

		//Create world and render;
		this.mWorld = new MightyWorld();
		this.mWorld.init();

		this.debugRenderer = new Box2DDebugRenderer();


	}

	/**
	 * 
	 */
	public void initWorld()
	{

		this.mWorld.addCenterPoint();
		this.mWorld.addCenterPlanet();

		this.state = STATE_INTRO;
	}

	public void updateIntro()
	{
		this.mWorld.addNewEnemies();
		this.state = STATE_PLAYING;
	}

	public void updatePlaying()
	{
		//FIXME Complete
		
		this.mWorld.addEnemy();

	}

	public void updatePad()
	{
		if (Gdx.input.isTouched())
		{

			float x = (((float) Gdx.input.getX()) / Gdx.graphics.getWidth());
			//float y = 1 - (((float) Gdx.input.getY()) / Gdx.graphics.getHeight());
			/*
			System.out.println(MessageFormat.format("X {0}", 
					new Object [] { Float.toString(x)} ));
			*/
			this.mWorld.updateAngularVelPlanet(x);
		}
		else if(Gdx.input.isKeyPressed(Keys.LEFT))
		{
			//FIXME 0.2f hardcoded
			this.mWorld.updateAngularVelPlanet(0.2f);
		} else if(Gdx.input.isKeyPressed(Keys.RIGHT))
		{
			//FIXME 0.8f hardcoded
			this.mWorld.updateAngularVelPlanet(0.8f);
		}
		else
		{
			this.mWorld.keyboardRelease();

			//world.getController().releasePad();
		}
	}


	/**
	 * 
	 * @param deltaTime
	 */
	public void update(float deltaTime)
	{
		if (deltaTime > 0.1f) deltaTime = 0.1f;

		switch(state)
		{

		case STATE_INIT:
			initWorld();
			break;
		case STATE_INTRO:
			updateIntro();
		case STATE_PLAYING:
			updatePad();
			updatePlaying();
		case STATE_ENDSCREEN:
			break;
		}
	}

	/**
	 * 
	 * @param deltaTime
	 */
	public void draw(float deltaTime)
	{
		GL20 gl = Gdx.gl;
		gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		switch (state) {
		case STATE_INIT:
			break;
		case STATE_INTRO:
		case STATE_PLAYING:
			//System.out.println(MessageFormat.format("Bodycounts a {0}", new Object [] { this.mWorld.getBox2DWorld().getBodyCount()} ));
			this.debugRenderer.render(this.mWorld.getBox2DWorld(), guiCam.combined);
			//this.guiCam.update();
			//this.batcher.setProjectionMatrix(guiCam.combined);
			//this.batcher.enableBlending();	
			break;
		case STATE_ENDSCREEN:
			this.debugRenderer.render(this.mWorld.getBox2DWorld(), guiCam.combined);
			//this.guiCam.update();
			//this.batcher.setProjectionMatrix(guiCam.combined);
			//this.batcher.enableBlending();	
			break;

		}

	}

	/**
	 * 
	 * @param delta
	 */
	public void physicStep(float delta)
	{
		this.mWorld.stepBox2D();
	}


	@Override
	public void render(float delta)
	{
		update(delta);
		draw(delta);
		physicStep(delta);
	}

}
