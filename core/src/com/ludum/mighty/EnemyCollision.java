package com.ludum.mighty;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.Manifold;
import com.badlogic.gdx.utils.TimeUtils;

public class EnemyCollision implements ContactListener {

	MightyWorld world;


	public EnemyCollision(MightyWorld world)
	{
		this.world = world;
	}

	@Override
	public void endContact(Contact contact) {

		Fixture fixA = contact.getFixtureA();

		Fixture fixB = contact.getFixtureB();

		if ((fixA.getBody().getUserData() instanceof EnemyData) && 
				(fixB.getBody().getUserData() instanceof EnemyData))
		{


			EnemyData enemyDataA = (EnemyData) fixA.getBody().getUserData();
			EnemyData enemyDataB = (EnemyData) fixB.getBody().getUserData();

			enemyDataA.freedLink(enemyDataB);
			enemyDataB.freedLink(enemyDataA);

	
			if (this.world.getEnemyStoppedVector().containsKey(enemyDataA.getEnemyId()) && (!enemyDataA.isCrashInPlanet()))
				enemyDataA.setToActivate(true);
			
			if (this.world.getEnemyStoppedVector().containsKey(enemyDataB.getEnemyId()) && (!enemyDataB.isCrashInPlanet()))
				enemyDataB.setToActivate(true);
				
	
		
		}		
	}

	@Override
	public void beginContact(Contact contact) {



		Fixture fixA = contact.getFixtureA();

		Fixture fixB = contact.getFixtureB();



		//A bumps into a planet
		if ((fixA.getBody().getUserData() instanceof EnemyData) && 
				!(fixB.getBody().getUserData() instanceof EnemyData)) 			
		{
			//System.out.println("CollisionA");

			EnemyData enemyData = (EnemyData) fixA.getBody().getUserData();

			if (this.world.getEnemyInMoveVector().containsKey(enemyData.getEnemyId()))
			{

				enemyData.setDegree(0);
				enemyData.setProcentImpulse(0);
				enemyData.setCrashInPlanet(true);
				enemyData.setPreviousPos(new Vector2(0,0));


				contact.getFixtureA().getBody().setUserData(enemyData);

				Body bodyEnemy = this.world.getEnemyInMoveVector().remove(enemyData.getEnemyId());

				this.world.getEnemyStoppedVector().put(enemyData.getEnemyId(), bodyEnemy);

			}
		}
		//B bumps into the planet
		else if ((fixB.getBody().getUserData() instanceof EnemyData) &&
				!(fixA.getBody().getUserData() instanceof EnemyData))
		{
			//System.out.println("CollisionB");

			EnemyData enemyData = (EnemyData) fixB.getBody().getUserData();

			if (this.world.getEnemyInMoveVector().containsKey(enemyData.getEnemyId()))
			{

				enemyData.setDegree(0);
				enemyData.setProcentImpulse(0);
				enemyData.setCrashInPlanet(true);
				enemyData.setPreviousPos(new Vector2(0,0));
				enemyData.setIdleStartTime(TimeUtils.millis());

				contact.getFixtureB().getBody().setUserData(enemyData);

				Body bodyEnemy = this.world.getEnemyInMoveVector().remove(enemyData.getEnemyId());

				this.world.getEnemyStoppedVector().put(enemyData.getEnemyId(), bodyEnemy);

			}

		}
		else if ((fixA.getBody().getUserData() instanceof EnemyData) && 
				(fixB.getBody().getUserData() instanceof EnemyData))
		{
			EnemyData enemyDataA = (EnemyData) fixA.getBody().getUserData();
			EnemyData enemyDataB = (EnemyData) fixB.getBody().getUserData();

			//A (moving) bumps against B (stopped)
			if (this.world.getEnemyInMoveVector().containsKey(enemyDataA.getEnemyId() ) && 
					this.world.getEnemyStoppedVector().containsKey(enemyDataB.getEnemyId() ))
			{
				enemyDataA.setDegree(0);
				enemyDataA.setProcentImpulse(0);

				enemyDataA.setPreviousPos(new Vector2(0,0));
				enemyDataA.setIdleStartTime(TimeUtils.millis());

				//Add Links
				enemyDataA.addEnemyLink(enemyDataB);
				enemyDataB.addEnemyLink(enemyDataA);


				contact.getFixtureA().getBody().setUserData(enemyDataA);

				Body bodyEnemy = this.world.getEnemyInMoveVector().remove(enemyDataA.getEnemyId());

				this.world.getEnemyStoppedVector().put(enemyDataA.getEnemyId(), bodyEnemy);


				//B moving bumps against A (stopped)
			} else if (this.world.getEnemyInMoveVector().containsKey(enemyDataB.getEnemyId() ) && 
					this.world.getEnemyStoppedVector().containsKey(enemyDataA.getEnemyId() ))

			{
				enemyDataB.setDegree(0);
				enemyDataB.setProcentImpulse(0);
				enemyDataB.setIdleStartTime(TimeUtils.millis());
				enemyDataB.setPreviousPos(new Vector2(0,0));


				//Add Links
				enemyDataA.addEnemyLink(enemyDataB);
				enemyDataB.addEnemyLink(enemyDataA);

				contact.getFixtureB().getBody().setUserData(enemyDataB);

				Body bodyEnemy = this.world.getEnemyInMoveVector().remove(enemyDataB.getEnemyId());

				this.world.getEnemyStoppedVector().put(enemyDataB.getEnemyId(), bodyEnemy);

			}

			//A (moving) bumps against B (moving). 
			else
			{
				//TODO
				enemyDataA.addEnemyLink(enemyDataB);
				enemyDataB.addEnemyLink(enemyDataA);
				enemyDataA.setIdleStartTime(TimeUtils.millis());
				enemyDataB.setIdleStartTime(TimeUtils.millis());
			}
		}
	}

	@Override
	public void preSolve(Contact contact, Manifold oldManifold) {
		// TODO Auto-generated method stub

	}

	@Override
	public void postSolve(Contact contact, ContactImpulse impulse) {
		// TODO Auto-generated method stub

	}


}
