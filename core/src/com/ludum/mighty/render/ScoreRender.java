package com.ludum.mighty.render;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.RandomXS128;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.utils.TimeUtils;
import com.ludum.mighty.EnemyData;
import com.ludum.mighty.MightyWorld;
import com.ludum.mighty.assets.PlayerAssets;
import com.ludum.mighty.settings.Commons;

public class ScoreRender {

	SpriteBatch batch;

	PlayerAssets assets;
	float width;
	float height;
	float widthFactor;
	float heightFactor;
	RandomXS128 rand = new RandomXS128(TimeUtils.millis());
	int color = this.rand.nextInt(Commons.MAX_COLORS);
	
	
	public ScoreRender(SpriteBatch batch, PlayerAssets assets, float width, float height)
	{
		this.batch = batch;

		this.assets = assets;
		this.width = width;
		this.height = height;
		this.widthFactor = this.width/(1.0f*Commons.WORLD_WIDTH);
		this.heightFactor = this.height/(1.0f*Commons.WORLD_HEIGHT);
	}

	public void render(int lastScore, int hiScore)
	{
		//FIXME Not needed
		//batch.enableBlending();
		renderSlogan();
		renderScore(lastScore, hiScore);
		//renderEnemyLine();
	}

	public void renderSlogan()
	{

		this.batch.begin();

		TextureRegion hiScoreRegion = this.assets.getAnimation(PlayerAssets.HIGH_SCORE_SLOGAN, TimeUtils.millis());

		float x = Math.round( Commons.WORLD_WIDTH/2 - hiScoreRegion.getRegionWidth()/2);

		float y = Math.round((Commons.WORLD_HEIGHT * 2)/3.0f - hiScoreRegion.getRegionHeight()/2);

		batch.draw(hiScoreRegion, x, y, hiScoreRegion.getRegionWidth() * widthFactor, 
				hiScoreRegion.getRegionHeight() * heightFactor);



		TextureRegion lastScoreRegion = this.assets.getAnimation(PlayerAssets.LAST_SCORE_SLOGAN, TimeUtils.millis());

		x = Math.round( Commons.WORLD_WIDTH/2 - lastScoreRegion.getRegionWidth()/2);

		y = Math.round((Commons.WORLD_HEIGHT )/3.0f - lastScoreRegion.getRegionHeight()/2);

		batch.draw(lastScoreRegion, x, y, lastScoreRegion.getRegionWidth() * widthFactor, 
				lastScoreRegion.getRegionHeight() * heightFactor);


		//Get Earth Region

		/*
		TextureRegion earthRegion = this.assets.getAnimation(PlayerAssets.EARTH, TimeUtils.millis());


		Vector2 planetPosition = this.world.getPlanetVector().get(0).getPosition();

		float x = Math.round(planetPosition.x + Commons.WORLD_WIDTH/2 - earthRegion.getRegionWidth()/2);
		float y = Math.round(planetPosition.y + Commons.WORLD_HEIGHT/2 - earthRegion.getRegionHeight()/2);

		batch.draw(earthRegion, x, y, earthRegion.getRegionWidth() * widthFactor, 
				earthRegion.getRegionHeight() * heightFactor);

		 */

		this.batch.end();
	}

	public void renderScore(int lastScore, int hiScore)
	{
		this.batch.begin();

		String lastScoreStr = Integer.toString(lastScore);
		String hiScoreStr = Integer.toString(hiScore);

		//High Score
		int xBase = (Commons.WORLD_WIDTH*5)/8;
		int yBase = Commons.WORLD_HEIGHT/2;

		for (int i = hiScoreStr.length()-1; i >= 0; i--)
		{
			TextureRegion nextNum = null; 


			if (hiScoreStr.charAt(i) == '0')
			{
				nextNum = this.assets.getAnimation(PlayerAssets.NUM_0, TimeUtils.millis());
			}
			else if (hiScoreStr.charAt(i) == '1')
			{
				nextNum = this.assets.getAnimation(PlayerAssets.NUM_1, TimeUtils.millis());
			}
			else if (hiScoreStr.charAt(i) == '2')
			{
				nextNum = this.assets.getAnimation(PlayerAssets.NUM_2, TimeUtils.millis());
			}
			else if (hiScoreStr.charAt(i) == '3')
			{
				nextNum = this.assets.getAnimation(PlayerAssets.NUM_3, TimeUtils.millis());
			}
			else if (hiScoreStr.charAt(i) == '4')
			{
				nextNum = this.assets.getAnimation(PlayerAssets.NUM_4, TimeUtils.millis());
			}
			else if (hiScoreStr.charAt(i) == '5')
			{
				nextNum = this.assets.getAnimation(PlayerAssets.NUM_5, TimeUtils.millis());
			}
			else if (hiScoreStr.charAt(i) == '6')
			{
				nextNum = this.assets.getAnimation(PlayerAssets.NUM_6, TimeUtils.millis());
			}
			else if (hiScoreStr.charAt(i) == '7')
			{
				nextNum = this.assets.getAnimation(PlayerAssets.NUM_7, TimeUtils.millis());
			}
			else if (hiScoreStr.charAt(i) == '8')
			{
				nextNum = this.assets.getAnimation(PlayerAssets.NUM_8, TimeUtils.millis());
			}
			else if (hiScoreStr.charAt(i) == '9')
			{
				nextNum = this.assets.getAnimation(PlayerAssets.NUM_9, TimeUtils.millis());
			}

			int x = xBase - (hiScoreStr.length() - i) * 24;
			int y = yBase;

			if (nextNum != null)
				batch.draw(nextNum, x, y, nextNum.getRegionWidth() * widthFactor, 
						nextNum.getRegionHeight() * heightFactor);

		}

		//Last Score
		xBase = (Commons.WORLD_WIDTH*5)/8;
		yBase = Commons.WORLD_HEIGHT/5;

		for (int i = lastScoreStr.length()-1; i >= 0; i--)
		{
			TextureRegion nextNum = null; 


			if (lastScoreStr.charAt(i) == '0')
			{
				nextNum = this.assets.getAnimation(PlayerAssets.NUM_0, TimeUtils.millis());
			}
			else if (lastScoreStr.charAt(i) == '1')
			{
				nextNum = this.assets.getAnimation(PlayerAssets.NUM_1, TimeUtils.millis());
			}
			else if (lastScoreStr.charAt(i) == '2')
			{
				nextNum = this.assets.getAnimation(PlayerAssets.NUM_2, TimeUtils.millis());
			}
			else if (lastScoreStr.charAt(i) == '3')
			{
				nextNum = this.assets.getAnimation(PlayerAssets.NUM_3, TimeUtils.millis());
			}
			else if (lastScoreStr.charAt(i) == '4')
			{
				nextNum = this.assets.getAnimation(PlayerAssets.NUM_4, TimeUtils.millis());
			}
			else if (lastScoreStr.charAt(i) == '5')
			{
				nextNum = this.assets.getAnimation(PlayerAssets.NUM_5, TimeUtils.millis());
			}
			else if (lastScoreStr.charAt(i) == '6')
			{
				nextNum = this.assets.getAnimation(PlayerAssets.NUM_6, TimeUtils.millis());
			}
			else if (lastScoreStr.charAt(i) == '7')
			{
				nextNum = this.assets.getAnimation(PlayerAssets.NUM_7, TimeUtils.millis());
			}
			else if (lastScoreStr.charAt(i) == '8')
			{
				nextNum = this.assets.getAnimation(PlayerAssets.NUM_8, TimeUtils.millis());
			}
			else if (lastScoreStr.charAt(i) == '9')
			{
				nextNum = this.assets.getAnimation(PlayerAssets.NUM_9, TimeUtils.millis());
			}

			int x = xBase - (lastScoreStr.length() - i) * 24;
			int y = yBase;

			if (nextNum != null)
				batch.draw(nextNum, x, y, nextNum.getRegionWidth() * widthFactor, 
						nextNum.getRegionHeight() * heightFactor);

		}

		this.batch.end();

	}


	public void renderEnemyLine()
	{


		

		int xBase = (Commons.WORLD_WIDTH)/2;
		int yBase = (Commons.WORLD_HEIGHT)/2;


		int jump = Commons.WORLD_WIDTH/20;

		this.batch.begin();

		for (int i = 50; i < Commons.WORLD_WIDTH - 50; i  = i + jump)
		{

			TextureRegion anim = null;

			if (color == PlayerAssets.BLUE)
			{
				anim = this.assets.getAnimation(PlayerAssets.ALIEN_BLUE_NORMAL, 
						rand.nextFloat());
			}
			else if (color == PlayerAssets.BROWN)
			{
				anim = this.assets.getAnimation(PlayerAssets.ALIEN_BROWN_NORMAL, 
						rand.nextFloat());				
			}
			else if (color == PlayerAssets.GREEN)
			{
				anim = this.assets.getAnimation(PlayerAssets.ALIEN_GREEN_NORMAL, 
						rand.nextFloat());				
			}
			else if (color == PlayerAssets.GREY)
			{
				anim = this.assets.getAnimation(PlayerAssets.ALIEN_GREY_NORMAL, 
						rand.nextFloat());				
			}
			else if (color == PlayerAssets.RED)
			{
				anim = this.assets.getAnimation(PlayerAssets.ALIEN_RED_NORMAL, 
						rand.nextFloat());				
			}			
			else if (color == PlayerAssets.ROSE)
			{
				anim = this.assets.getAnimation(PlayerAssets.ALIEN_ROSE_NORMAL, 
						rand.nextFloat());				
			}
			else if (color == PlayerAssets.YELLOW)
			{
				anim = this.assets.getAnimation(PlayerAssets.ALIEN_YELLOW_NORMAL, 
						rand.nextFloat());				
			}
			else if (color == PlayerAssets.VIOLET)
			{
				anim = this.assets.getAnimation(PlayerAssets.ALIEN_VIOLET_NORMAL, 
						rand.nextFloat());				
			}

			if (anim!= null)
			{


				float x = Math.round(i - anim.getRegionWidth()/2);
				float y = Math.round(yBase - anim.getRegionHeight()/2);

				/*
			batch.draw(anim, x, y, anim.getRegionWidth() * widthFactor, 
					anim.getRegionHeight() * heightFactor);

				 */
				batch.draw(anim, x, y,anim.getRegionWidth()/2, anim.getRegionHeight()/2, 
						anim.getRegionWidth(), anim.getRegionHeight(), widthFactor, heightFactor, rand.nextFloat());


			}

		}
		this.batch.end();
	}


}
