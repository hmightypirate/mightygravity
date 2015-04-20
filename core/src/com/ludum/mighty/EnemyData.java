package com.ludum.mighty;

import java.util.HashMap;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Joint;
import com.badlogic.gdx.utils.TimeUtils;
import com.ludum.mighty.settings.Commons;

/**
 * 
 * @author hector
 *
 */
public class EnemyData 
{

	int color;
	
	int forceX;
	int forceY;
	float degree;
	float procentImpulse;
	int enemyId;
	HashMap<Integer, EnemyData> enemyLinks;
	HashMap<Integer, EnemyData> indirectLinks;
	long initialTime;
	
	//Time in which the enemy was created
	long creationTime;
	long destructionTime;
	
	int directContacts;
	int indirectContacts;
	
	boolean freed;
	boolean destroyed;
	
	boolean toActivate;
	
	boolean crashInPlanet;
	
	Vector2 previousPos;
	
	long idleStartTime;
	
	Joint revoluteJoint;
	
	public EnemyData( int forceX, int forceY, float degree, float procentImpulse, int enemyId, int color)
	{
		this.forceX = forceX;
		this.forceY = forceY;
		this.degree = degree;
		this.procentImpulse = procentImpulse;
		this.enemyId = enemyId;
		this.enemyLinks = new HashMap<Integer, EnemyData>();
		this.indirectLinks = new HashMap<Integer, EnemyData>();
		this.initialTime = TimeUtils.millis();
		this.color = color;
		this.freed = false;
		this.toActivate = false;
		this.previousPos = new Vector2(0,0);
		this.crashInPlanet = false;
		this.idleStartTime = TimeUtils.millis();
		this.revoluteJoint = null;
		this.creationTime = TimeUtils.millis();
		
		
		
	}
	
	
	public void addEnemyLink(EnemyData newLink)
	{
		
		if (!this.enemyLinks.containsKey(newLink.getEnemyId()))
		{	
			this.enemyLinks.put(newLink.getEnemyId(), newLink);
			
			if (newLink.getColor() == this.color)
			{
				this.directContacts++;
				
				//Check indirectContacts
				for (EnemyData otherEnemy : newLink.getEnemyLinks().values())
				{
					if (otherEnemy.getColor() == this.color)
					{
						if ((!this.enemyLinks.containsKey(otherEnemy.getEnemyId())) &&
								(!this.indirectLinks.containsKey(otherEnemy.getEnemyId())))
						{
							//Add the indirect link to the map
							this.indirectContacts++;
							
							this.indirectLinks.put(otherEnemy.getEnemyId(), otherEnemy);
						}
					}
				}
				
				if (this.directContacts + this.indirectContacts == Commons.MAX_COMPARISON)
				{
					this.freed = true;
					this.setOthersFree(false);
				}
			}
		}
		
	}
	
	
	/**
	 * 
	 */
	public void setOthersFree(boolean flag)
	{
		if (!this.freed || !flag)
		{
			this.freed = true;
			
			for (EnemyData enemy : this.enemyLinks.values())
			{
				//If the enemy ball has the same color set them free
				if (enemy.getColor() == this.color)
				{
					enemy.setOthersFree(true);
				}
			}
			
		}
	}
	
	/**
	 * 
	 * @param idleTime
	 * @return
	 */
	public boolean checkIsIdle(long idleTime)
	{
		return (Math.abs(idleTime - this.idleStartTime ) > Commons.MAX_TIME_IDLE);
	}

	public void checkDegree()
	{
		if (TimeUtils.timeSinceMillis(this.initialTime) > Commons.MAX_TIME_TO_CRASH)
		{
			//Force the balls to crash
			this.degree = this.degree  - this.degree * Commons.MAX_DEGREE_REDUCTION;
			//Update thie initial time
			this.initialTime = TimeUtils.millis();
		}
	}
	
	public void freedLink(EnemyData newLink)
	{
		if (this.enemyLinks.containsKey(newLink.getEnemyId()))
		{
			this.enemyLinks.remove(newLink.getEnemyId());
			
			if (newLink.getColor() == this.color)
			{
				this.directContacts--;
			}
		}
	}
	
	
	
	public long getIdleStartTime() {
		return idleStartTime;
	}


	public void setIdleStartTime(long idleStartTime) {
		this.idleStartTime = idleStartTime;
	}


	//Getters and setters
	public int getForceX() {
		return forceX;
	}

	public void setForceX(int forceX) {
		this.forceX = forceX;
	}

	public int getForceY() {
		return forceY;
	}

	public void setForceY(int forceY) {
		this.forceY = forceY;
	}

	public float getDegree() {
		return degree;
	}

	public void setDegree(float degree) {
		this.degree = degree;
	}

	public float getProcentImpulse() {
		return procentImpulse;
	}

	public void setProcentImpulse(float procentImpulse) {
		this.procentImpulse = procentImpulse;
	}

	public int getEnemyId() {
		return enemyId;
	}

	public void setEnemyId(int enemyId) {
		this.enemyId = enemyId;
	}	
	
	public int getColor() {
		return color;
	}


	public void setColor(int color) {
		this.color = color;
	}


	public HashMap<Integer, EnemyData> getEnemyLinks() {
		return enemyLinks;
	}


	public void setEnemyLinks(HashMap<Integer, EnemyData> enemyLinks) {
		this.enemyLinks = enemyLinks;
	}


	public boolean isFreed() {
		return freed;
	}


	public void setFreed(boolean freed) {
		this.freed = freed;
	}


	public boolean isToActivate() {
		return toActivate;
	}


	public void setToActivate(boolean toActivate) {
		this.toActivate = toActivate;
	}


	public Vector2 getPreviousPos() {
		return previousPos;
	}


	public void setPreviousPos(Vector2 previousPos) {
		this.previousPos = previousPos;
	}


	public boolean isCrashInPlanet() {
		return crashInPlanet;
	}


	public void setCrashInPlanet(boolean crashInPlanet) {
		this.crashInPlanet = crashInPlanet;
	}


	public HashMap<Integer, EnemyData> getIndirectLinks() {
		return indirectLinks;
	}


	public void setIndirectLinks(HashMap<Integer, EnemyData> indirectLinks) {
		this.indirectLinks = indirectLinks;
	}


	public boolean isDestroyed() {
		return destroyed;
	}


	public void setDestroyed(boolean destroyed) {
		this.destroyed = destroyed;
	}


	public Joint getRevoluteJoint() {
		return revoluteJoint;
	}


	public void setRevoluteJoint(Joint revoluteJoint) {
		this.revoluteJoint = revoluteJoint;
	}


	public long getCreationTime() {
		return creationTime;
	}


	public void setCreationTime(long creationTime) {
		this.creationTime = creationTime;
	}


	public long getDestructionTime() {
		return destructionTime;
	}


	public void setDestructionTime(long destructionTime) {
		this.destructionTime = destructionTime;
	}
	
	
	
}
