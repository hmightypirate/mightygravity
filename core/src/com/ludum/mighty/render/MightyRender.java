package com.ludum.mighty.render;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.utils.TimeUtils;
import com.ludum.mighty.EnemyData;
import com.ludum.mighty.MightyWorld;
import com.ludum.mighty.assets.PlayerAssets;
import com.ludum.mighty.settings.Commons;

public class MightyRender {

	SpriteBatch batch;
	MightyWorld world;
	PlayerAssets assets;
	float width;
	float height;
	float widthFactor;
	float heightFactor;

	public MightyRender(SpriteBatch batch, MightyWorld world, PlayerAssets assets, float width, float height)
	{
		this.batch = batch;
		this.world = world;
		this.assets = assets;
		this.width = width;
		this.height = height;
		this.widthFactor = this.width/(1.0f*Commons.WORLD_WIDTH);
		this.heightFactor = this.height/(1.0f*Commons.WORLD_HEIGHT);
	}

	public void render()
	{
		//FIXME Not needed
		//batch.enableBlending();
		renderEarth();
		renderStaticEnemies();
		renderDynamicEnemies();
		renderExplosions();
	}

	public void renderEarth()
	{

		this.batch.begin();
		//Get Earth Region

		TextureRegion earthRegion = this.assets.getAnimation(PlayerAssets.EARTH, TimeUtils.millis());

		Vector2 planetPosition = this.world.getPlanetVector().get(0).getPosition();

		float x = Math.round(planetPosition.x + Commons.WORLD_WIDTH/2 - earthRegion.getRegionWidth()/2);
		float y = Math.round(planetPosition.y + Commons.WORLD_HEIGHT/2 - earthRegion.getRegionHeight()/2);

		batch.draw(earthRegion, x, y, earthRegion.getRegionWidth() * widthFactor, 
				earthRegion.getRegionHeight() * heightFactor);



		this.batch.end();
	}

	public void renderStaticEnemies()
	{
		this.batch.begin();

		for (Body enemy : this.world.getEnemyStoppedVector().values())
		{
			Vector2 enemyPos = enemy.getPosition();
			float angle = enemyPos.angle();
			EnemyData enemyData = (EnemyData) enemy.getUserData();

			TextureRegion anim = null;

			if (enemyData.getColor() == PlayerAssets.BLUE)
			{
				anim = this.assets.getAnimation(PlayerAssets.ALIEN_BLUE_IDLE, 
						(TimeUtils.millis() - enemyData.getCreationTime())/1000.0f);
			}
			else if (enemyData.getColor() == PlayerAssets.BROWN)
			{
				anim = this.assets.getAnimation(PlayerAssets.ALIEN_BROWN_IDLE, 
						(TimeUtils.millis() - enemyData.getCreationTime())/1000.0f);				
			}
			else if (enemyData.getColor() == PlayerAssets.GREEN)
			{
				anim = this.assets.getAnimation(PlayerAssets.ALIEN_GREEN_IDLE, 
						(TimeUtils.millis() - enemyData.getCreationTime())/1000.0f);				
			}
			else if (enemyData.getColor() == PlayerAssets.GREY)
			{
				anim = this.assets.getAnimation(PlayerAssets.ALIEN_GREY_IDLE, 
						(TimeUtils.millis() - enemyData.getCreationTime())/1000.0f);				
			}
			else if (enemyData.getColor() == PlayerAssets.RED)
			{
				anim = this.assets.getAnimation(PlayerAssets.ALIEN_RED_IDLE, 
						(TimeUtils.millis() - enemyData.getCreationTime())/1000.0f);				
			}			
			else if (enemyData.getColor() == PlayerAssets.ROSE)
			{
				anim = this.assets.getAnimation(PlayerAssets.ALIEN_ROSE_IDLE, 
						(TimeUtils.millis() - enemyData.getCreationTime())/1000.0f);				
			}
			else if (enemyData.getColor() == PlayerAssets.YELLOW)
			{
				anim = this.assets.getAnimation(PlayerAssets.ALIEN_YELLOW_IDLE, 
						(TimeUtils.millis() - enemyData.getCreationTime())/1000.0f);				
			}
			else if (enemyData.getColor() == PlayerAssets.VIOLET)
			{
				anim = this.assets.getAnimation(PlayerAssets.ALIEN_VIOLET_IDLE, 
						(TimeUtils.millis() - enemyData.getCreationTime())/1000.0f);				
			}

			if (anim!= null)
			{


				float x = Math.round(enemyPos.x + Commons.WORLD_WIDTH/2 - anim.getRegionWidth()/2);
				float y = Math.round(enemyPos.y + Commons.WORLD_HEIGHT/2 - anim.getRegionHeight()/2);

				/*
			batch.draw(anim, x, y, anim.getRegionWidth() * widthFactor, 
					anim.getRegionHeight() * heightFactor);
				 */

				batch.draw(anim, x, y, anim.getRegionWidth()/2, anim.getRegionHeight()/2 , 
						anim.getRegionWidth(), anim.getRegionHeight(), widthFactor, heightFactor, angle);




			}

		}

		this.batch.end();

	}

	public void renderDynamicEnemies()
	{
		this.batch.begin();

		for (Body enemy : this.world.getEnemyInMoveVector().values())
		{
			Vector2 enemyPos = enemy.getPosition();
			float angle = enemyPos.angle();
			EnemyData enemyData = (EnemyData) enemy.getUserData();

			TextureRegion anim = null;

			if (enemyData.getColor() == PlayerAssets.BLUE)
			{
				anim = this.assets.getAnimation(PlayerAssets.ALIEN_BLUE_NORMAL, 
						(TimeUtils.millis() - enemyData.getCreationTime())/1000.0f);
			}
			else if (enemyData.getColor() == PlayerAssets.BROWN)
			{
				anim = this.assets.getAnimation(PlayerAssets.ALIEN_BROWN_NORMAL, 
						(TimeUtils.millis() - enemyData.getCreationTime())/1000.0f);				
			}
			else if (enemyData.getColor() == PlayerAssets.GREEN)
			{
				anim = this.assets.getAnimation(PlayerAssets.ALIEN_GREEN_NORMAL, 
						(TimeUtils.millis() - enemyData.getCreationTime())/1000.0f);				
			}
			else if (enemyData.getColor() == PlayerAssets.GREY)
			{
				anim = this.assets.getAnimation(PlayerAssets.ALIEN_GREY_NORMAL, 
						(TimeUtils.millis() - enemyData.getCreationTime())/1000.0f);				
			}
			else if (enemyData.getColor() == PlayerAssets.RED)
			{
				anim = this.assets.getAnimation(PlayerAssets.ALIEN_RED_NORMAL, 
						(TimeUtils.millis() - enemyData.getCreationTime())/1000.0f);				
			}			
			else if (enemyData.getColor() == PlayerAssets.ROSE)
			{
				anim = this.assets.getAnimation(PlayerAssets.ALIEN_ROSE_NORMAL, 
						(TimeUtils.millis() - enemyData.getCreationTime())/1000.0f);				
			}
			else if (enemyData.getColor() == PlayerAssets.YELLOW)
			{
				anim = this.assets.getAnimation(PlayerAssets.ALIEN_YELLOW_NORMAL, 
						(TimeUtils.millis() - enemyData.getCreationTime())/1000.0f);				
			}
			else if (enemyData.getColor() == PlayerAssets.VIOLET)
			{
				anim = this.assets.getAnimation(PlayerAssets.ALIEN_VIOLET_NORMAL, 
						(TimeUtils.millis() - enemyData.getCreationTime())/1000.0f);				
			}

			if (anim!= null)
			{


				float x = Math.round(enemyPos.x + Commons.WORLD_WIDTH/2 - anim.getRegionWidth()/2);
				float y = Math.round(enemyPos.y + Commons.WORLD_HEIGHT/2 - anim.getRegionHeight()/2);

				/*
			batch.draw(anim, x, y, anim.getRegionWidth() * widthFactor, 
					anim.getRegionHeight() * heightFactor);

				 */
				batch.draw(anim, x, y,anim.getRegionWidth()/2, anim.getRegionHeight()/2, 
						anim.getRegionWidth(), anim.getRegionHeight(), widthFactor, heightFactor, angle);




			}

		}

		this.batch.end();
	}


	public void renderExplosions()
	{
		this.batch.begin();

		ArrayList<EnemyData> idsToRemList = new ArrayList<EnemyData>();

		for (int i = 0; i < this.world.getDataToRemVector().size(); i++)
		{
			EnemyData enemyData = this.world.getDataToRemVector().get(i);

			Vector2 enemyPos = enemyData.getPreviousPos();
			float angle = enemyPos.angle();


			TextureRegion anim = null;

			if (enemyData.getColor() == PlayerAssets.BLUE)
			{
				anim = this.assets.getAnimation(PlayerAssets.ALIEN_BLUE_EXPLOSION, 
						(TimeUtils.millis() - enemyData.getDestructionTime())/1000.0f);
			}
			else if (enemyData.getColor() == PlayerAssets.BROWN)
			{
				anim = this.assets.getAnimation(PlayerAssets.ALIEN_BROWN_EXPLOSION, 
						(TimeUtils.millis() - enemyData.getDestructionTime())/1000.0f);				
			}
			else if (enemyData.getColor() == PlayerAssets.GREEN)
			{
				anim = this.assets.getAnimation(PlayerAssets.ALIEN_GREEN_EXPLOSION, 
						(TimeUtils.millis() - enemyData.getDestructionTime())/1000.0f);				
			}
			else if (enemyData.getColor() == PlayerAssets.GREY)
			{
				anim = this.assets.getAnimation(PlayerAssets.ALIEN_GREY_EXPLOSION, 
						(TimeUtils.millis() - enemyData.getDestructionTime())/1000.0f);				
			}
			else if (enemyData.getColor() == PlayerAssets.RED)
			{
				anim = this.assets.getAnimation(PlayerAssets.ALIEN_RED_EXPLOSION, 
						(TimeUtils.millis() - enemyData.getDestructionTime())/1000.0f);				
			}			
			else if (enemyData.getColor() == PlayerAssets.ROSE)
			{
				anim = this.assets.getAnimation(PlayerAssets.ALIEN_ROSE_EXPLOSION, 
						(TimeUtils.millis() - enemyData.getDestructionTime())/1000.0f);				
			}
			else if (enemyData.getColor() == PlayerAssets.YELLOW)
			{
				anim = this.assets.getAnimation(PlayerAssets.ALIEN_YELLOW_EXPLOSION, 
						(TimeUtils.millis() - enemyData.getDestructionTime())/1000.0f);				
			}
			else if (enemyData.getColor() == PlayerAssets.VIOLET)
			{
				anim = this.assets.getAnimation(PlayerAssets.ALIEN_VIOLET_EXPLOSION, 
						(TimeUtils.millis() - enemyData.getDestructionTime())/1000.0f);				
			}

			if (anim!= null)
			{


				float x = Math.round(enemyPos.x + Commons.WORLD_WIDTH/2 - anim.getRegionWidth()/2);
				float y = Math.round(enemyPos.y + Commons.WORLD_HEIGHT/2 - anim.getRegionHeight()/2);

				/*
			batch.draw(anim, x, y, anim.getRegionWidth() * widthFactor, 
					anim.getRegionHeight() * heightFactor);

				 */
				batch.draw(anim, x, y,anim.getRegionWidth()/2, anim.getRegionHeight()/2, 
						anim.getRegionWidth(), anim.getRegionHeight(), widthFactor, heightFactor, angle);


				idsToRemList.add(enemyData);

			}


		}
		
		this.world.setDataToRemVector(idsToRemList);
		this.batch.end();
	}

}
