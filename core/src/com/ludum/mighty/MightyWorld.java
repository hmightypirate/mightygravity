package com.ludum.mighty;

import java.util.ArrayList;
import java.util.HashMap;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.RandomXS128;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.Box2D;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.Joint;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.physics.box2d.joints.RevoluteJoint;
import com.badlogic.gdx.physics.box2d.joints.RevoluteJointDef;
import com.badlogic.gdx.utils.TimeUtils;
import com.ludum.mighty.settings.Commons;

/**
 * 
 * @author hector
 *
 */
public class MightyWorld 
{

	World box2DWorld;

	//Vectors to store planets and enemies
	ArrayList<Body> planetVector;
	ArrayList<Body> pointVector;
	ArrayList<EnemyData> dataToRemVector;
	HashMap<Integer,Body> enemyInMoveVector;
	HashMap<Integer, Body> enemyStoppedVector;

	int enemyCounter;

	//Level of the system
	int level;

	int scoreToPass;

	int currentScore;

	long timeLastFreed = 0;

	RandomXS128 rand = new RandomXS128(TimeUtils.millis());

	float angular = 0f;

	/**
	 * 
	 */
	public void init()
	{

		//Creating the Box2D World
		Box2D.init();

		//Creating aux. vectors
		this.planetVector = new ArrayList<Body>();
		this.pointVector = new ArrayList<Body>();
		this.dataToRemVector = new ArrayList<EnemyData>();
		this.enemyInMoveVector = new HashMap<Integer, Body>();
		this.enemyStoppedVector = new HashMap<Integer,Body>();

		//Creating the Box2D World
		this.box2DWorld = new World(new Vector2(0,0), true);

		this.box2DWorld.setContactListener(new EnemyCollision(this));

		this.enemyCounter = 0;


		this.level = 1;
		this.scoreToPass = 5000; //FIXME: Hardcoded
		this.currentScore = 0;

	}

	/**
	 * 
	 */
	public void addNewEnemies()
	{
		/*
		addBall(-Commons.WORLD_WIDTH/2, Commons.WORLD_HEIGHT/8, 32, 0, 0, (float) 90.0, (float) 0.8, 0);
		addBall(200, 200, 32, 0, 0, (float) 90.0, (float) 0.8 , 0);
		this.addRevolutedBall(150, 150, 32, 0, 0, (float) 90.0, (float) 0.8 , 0);
		*/
	}

	/**
	 * 
	 */
	public void addEnemy()
	{

		if (this.enemyInMoveVector.size() < this.level + Commons.EXTRA_ENEMIES)
		{
			float width = 0;
			float height = 0;
			float degree = 0;
			float increment = 0;
			int ballSize = Commons.ENEMY_SIZE; // FIXME: fixed size of 32

			float nextRand = this.rand.nextFloat();
			if (nextRand < 0.5)
			{
				if (nextRand < 0.25)
				{
					width = -Commons.WORLD_WIDTH/2;
				}
				else
					width = Commons.WORLD_WIDTH/2;

				nextRand = this.rand.nextFloat();

				height =  nextRand*Commons.WORLD_HEIGHT - Commons.WORLD_HEIGHT/2;

			}
			else
			{
				if (nextRand < 0.75)
				{
					height = -Commons.WORLD_HEIGHT/2;
				}
				else
					height = Commons.WORLD_HEIGHT/2;

				nextRand = this.rand.nextFloat();

				width = nextRand*Commons.WORLD_WIDTH - Commons.WORLD_WIDTH/2;
			}

			nextRand = this.rand.nextFloat();

			degree = nextRand*Commons.DEGREE_AMPLITUDE - Commons.DEGREE_AMPLITUDE/2;

			nextRand = this.rand.nextFloat();

			increment = nextRand * Commons.MAX_AMPLITUDE;

			int maxColors = Math.min(this.level + Commons.EXTRA_COLOR_PER_LEVEL, Commons.MAX_COLORS);
			
			int color = this.rand.nextInt(maxColors);

			addBall((int) width, (int) height, ballSize, 0, 0, degree, increment, color);
		}
	}

	public void addJointForBody(Body groundBody, Body body)
	{
		
		RevoluteJointDef rjd = new RevoluteJointDef();
		rjd.initialize(groundBody, body , new Vector2(0,0));
		rjd.motorSpeed = MathUtils.PI*5;
		//rjd.maxMotorTorque = 1000000.0f;
		rjd.enableMotor = true;
		rjd.enableLimit = false;
		
	
		Joint join = (RevoluteJoint) 	this.box2DWorld.createJoint(rjd); 
		
		EnemyData enemyData = (EnemyData) body.getUserData();
		enemyData.setRevoluteJoint(join);
		
		
	
	
		
	
		
	}


	/**
	 * 
	 */
	public void stepBox2D()
	{
		//Same values as in the libGDX manual
		this.box2DWorld.step(1/30f, 10, 10);

		//this.box2DWorld.clearForces();

		//Auxiliary array to store those ids to be stopped
		ArrayList<Integer> keysToStop = new ArrayList<Integer>();


		//Apply Gravity Forces
		for (Body enemy : this.enemyInMoveVector.values())
		{


			Vector2 enemyPosition = enemy.getWorldCenter();



			float enemyRadius = enemy.getFixtureList().first().getShape().getRadius();

			EnemyData enemyData = (EnemyData) enemy.getUserData();
			/*
			System.out.println(MessageFormat.format("ID {0} POS {1} {2} PREVPOS {3} {4} IDLETIME {5} SIZE {6} LEVEL {7} CURRENTSCO {8}", new Object [] { 
					enemyData.getEnemyId(),
					enemyPosition.x,
					enemyPosition.y,
					enemyData.getPreviousPos().x,
					enemyData.getPreviousPos().y,
					TimeUtils.millis()-enemyData.getIdleStartTime(),
					enemyData.getEnemyLinks().size(),
					this.level,
					this.currentScore
			}));
			*/

			
			if ((Math.abs(enemyData.getPreviousPos().len() - enemyPosition.len()) < 0.01) &&
					enemyPosition.len() < Commons.MIN_ATMOSPHERE_LEN)
			{
				if (enemyData.checkIsIdle(TimeUtils.millis()))
				{

					if ((enemyData.getEnemyLinks().size()>0)||enemyData.isCrashInPlanet())
					{
						keysToStop.add(enemyData.getEnemyId());
					}
				}
			}	
			else
			{
				enemyData.setPreviousPos(enemyPosition);
				enemyData.setIdleStartTime(TimeUtils.millis());
			}

			//Fist update degree
			enemyData.checkDegree();

			for (Body planet : this.planetVector)
			{
				float planetRadius = planet.getFixtureList().first().getShape().getRadius()*Commons.MAX_RADIUS*this.level;
				Vector2 planetPosition = planet.getWorldCenter();


				Vector2 planetDistance = new Vector2(0,0);

				planetDistance = planetDistance.add(enemyPosition);
				planetDistance = planetDistance.sub(planetPosition);

				//System.out.println(MessageFormat.format("PlanetDistance {0} {1}", new Object [] { planetDistance.toString(), enemyPosition }));

				float jointDistance = planetDistance.len();

				//Max distance Allowed
				//Freed and destroy
				if (jointDistance > Commons.MAX_DISTANCE)
				{
					enemyData.setDestroyed(true);
					enemyData.setFreed(true);
					keysToStop.add(enemyData.getEnemyId());
				}

				//Always apply gravity force in this game
				//apply a distant threshold if a limit to apply gravity force is required

				//planetDistance.NegativeSelf();
				planetDistance= planetDistance.rotate(180);
				float vecSum = Math.abs(planetDistance.x)+Math.abs(planetDistance.y);

				//System.out.println(MessageFormat.format("VECUM {0} {1}", vecSum, jointDistance));

				Vector2 forceDistance = new Vector2(0,0).mulAdd(planetDistance,((planetRadius*enemyRadius)/(jointDistance*jointDistance)));

				//enemy.applyForceToCenter(forceDistance, true);
				enemy.applyForceToCenter(forceDistance.x, forceDistance.y, true);

				//System.out.println(MessageFormat.format("ForceDistance {0} {1}", new Object [] { forceDistance }));


				Vector2 enemyForce = new Vector2(0,0).mulAdd(forceDistance.rotateRad(enemyData.getDegree()), enemyData.getProcentImpulse());

				enemy.applyForceToCenter(enemyForce.x, enemyForce.y, true);

				//System.out.println(MessageFormat.format("EnemyDistance {0} {1} {2}", new Object [] { enemyForce, enemyData.getDegree(), enemyData.getProcentImpulse() }));


			}

		}

		for (Integer key : keysToStop)
		{
			if (this.getEnemyInMoveVector().containsKey(key))
			{
				Body enemy = this.getEnemyInMoveVector().remove(key);

				EnemyData enemyData = (EnemyData) enemy.getUserData();

				enemyData.setPreviousPos(new Vector2(0,0));
				enemyData.setDegree(0);
				enemyData.setProcentImpulse(0);
				
				this.addJointForBody(this.pointVector.get(0), enemy);
				enemy.setAwake(true);
				
				this.getEnemyStoppedVector().put(enemyData.getEnemyId(), enemy);
				
				

			}
		}

		//Auxiliary array to store those ids to be freed
		ArrayList<Integer> keysToFreed = new ArrayList<Integer>();

		//Auxiliary array to store those ids to activate
		ArrayList<Integer> keysToActive = new ArrayList<Integer>();

		//Update punctuation and freed enemies
		HashMap<Integer, Integer> punctMap = new HashMap<Integer, Integer>(); 


		for (Integer enemyKey : this.getEnemyStoppedVector().keySet())
		{
			Body enemy = this.getEnemyStoppedVector().get(enemyKey);



			EnemyData enemyData = (EnemyData) enemy.getUserData();

			if (enemyData.isFreed())
			{
				this.timeLastFreed = TimeUtils.millis();
				
				//UpdatePostion and Destruction Time to put them in the vector
				enemyData.setDestructionTime(this.timeLastFreed);
				enemyData.setPreviousPos(enemy.getPosition());
				this.dataToRemVector.add(enemyData);
				
				//Update score
				//FIXME: check for combos
				if (!enemyData.isDestroyed())
				{
					if (!punctMap.containsKey(enemyData.getColor()))
					{
						punctMap.put(enemyData.getColor(), 0);
					}
					int value = punctMap.get(enemyData.getColor());
					value++;
					punctMap.put(enemyData.getColor(), value);

				}

				int multiplier = punctMap.size();

				int scoreToSum = 0;
				for (Integer color : punctMap.keySet())
				{
					scoreToSum = scoreToSum + punctMap.get(color) + color * punctMap.get(color);
				}
				//Add combo
				scoreToSum = scoreToSum * multiplier * Commons.SCORE_NORMAL_KILL;

				this.currentScore = this.currentScore + scoreToSum;

				if (this.currentScore > this.scoreToPass)
				{
					this.level++;
					this.scoreToPass = this.scoreToPass + this.scoreToPass; //FIXME: * this.level;
				}

				//Delete Joints
				if (enemyData.getRevoluteJoint() != null)
					this.box2DWorld.destroyJoint(enemyData.getRevoluteJoint());
				
				//Delete links
				for (EnemyData otherEnemy : enemyData.getEnemyLinks().values())
				{
					otherEnemy.freedLink(enemyData);

				}

				//FIXME: render some animation



				keysToFreed.add(enemyData.getEnemyId());

				for (Integer key : enemyData.enemyLinks.keySet())
				{
					keysToActive.add(key);
				}

				this.box2DWorld.destroyBody(enemy);
			}
			else
			{
				
				if (enemyData.isToActivate())
				{
					
					//Only allow activations if a recent enemy was freed
					if ((TimeUtils.millis() - this.timeLastFreed  < Commons.TIME_SINCE_LAST_FREED) || (enemy.getPosition().len() > Commons.MIN_ATMOSPHERE_LEN))
					keysToActive.add(enemyData.getEnemyId());
					enemyData.setToActivate(false);
				}
				
				else
				{
					if (enemyData.getRevoluteJoint() == null)
					{
						this.addJointForBody(this.pointVector.get(0), enemy);
					}
					
					enemy.setLinearVelocity(new Vector2(0,0).mulAdd(enemy.getPosition().rotate(180), 10000));
					enemy.setAngularVelocity(this.angular);
					
					//enemy.;(MathUtils.PI);
					//enemy.setAwake(false);

					//enemy.setAwake(false);
					
				}
			}
		}

		for (Integer key : keysToFreed)
		{
			this.enemyStoppedVector.remove(key);
		}

		for (Integer key : keysToActive)
		{
			if (this.enemyStoppedVector.containsKey(key))
			{
				Body enemy = this.enemyStoppedVector.remove(key);
				enemy.setAwake(true);
				enemy.setActive(true);
				EnemyData enemyData = (EnemyData) enemy.getUserData();
				if (enemyData.getRevoluteJoint()!=null)
					this.box2DWorld.destroyJoint(enemyData.getRevoluteJoint());
				//Set Joint to null
				enemyData.setRevoluteJoint(null);
				enemyData.setToActivate(false);
				enemyData.setPreviousPos(new Vector2(0,0));
				enemyData.setIdleStartTime(TimeUtils.millis());
				this.enemyInMoveVector.put(enemyData.getEnemyId(), enemy);
			}
		}
	} 


	public void addCenterPoint()
	{
		BodyDef groundBodyDef = new BodyDef();
		groundBodyDef.type = BodyType.StaticBody;
		//groundBodyDef.position.set(0, -Commons.WORLD_HEIGHT/2);
		groundBodyDef.position.set(0, 0);
		
		// Create our body in the world using our body definition
		Body planet = this.box2DWorld.createBody(groundBodyDef);

		CircleShape circle = new CircleShape();
		circle.setRadius(1);


		// Create a fixture definition to apply our shape to
		FixtureDef fixtureDef = new FixtureDef();
		fixtureDef.restitution = 0;
		fixtureDef.density = 0;

		//Attach shape to circle;
		fixtureDef.shape = circle;


		// Create our fixture and attach it to the body
		planet.createFixture(fixtureDef);
		planet.setUserData(new Sprite());

		this.pointVector.add(planet);

		//Dispose of shapes
		circle.dispose();
	}

	
	
	public void addCenterPlanet()
	{

		BodyDef groundBodyDef = new BodyDef();
		groundBodyDef.type = BodyType.StaticBody;
		groundBodyDef.position.set(0, 0);

		// Create our body in the world using our body definition
		Body planet = this.box2DWorld.createBody(groundBodyDef);

		CircleShape circle = new CircleShape();
		circle.setRadius(Commons.WORLD_HEIGHT/12);


		// Create a fixture definition to apply our shape to
		FixtureDef fixtureDef = new FixtureDef();
		fixtureDef.restitution = 0;
		fixtureDef.density = 5;

		//Attach shape to circle;
		fixtureDef.shape = circle;


		// Create our fixture and attach it to the body
		planet.createFixture(fixtureDef);
		planet.setUserData(new Sprite());

		this.planetVector.add(planet);

		//Dispose of shapes
		circle.dispose();
	}


	public void addRevolutedBall(
			int xPosition, 
			int yPosition, 
			int ballSizeScale, 
			int forceX, 
			int forceY, 
			float degree, 
			float procentImpulse,
			int color
			)
			{
		BodyDef enemyBodyDef = new BodyDef();
		enemyBodyDef.type = BodyType.DynamicBody;
		enemyBodyDef.position.set(xPosition, yPosition);	

		// Create our body in the world using our body definition
		Body enemy = this.box2DWorld.createBody(enemyBodyDef);
		
		
		CircleShape circle = new CircleShape();
		circle.setRadius(Commons.WORLD_HEIGHT/ballSizeScale);

		// Create a fixture definition to apply our shape to
		FixtureDef fixtureDef = new FixtureDef();
		fixtureDef.restitution = 0f;
		fixtureDef.density = 0;
		fixtureDef.friction = (float) 1f;
		//Attach shape to circle;
		fixtureDef.shape = circle;

		// Create our fixture and attach it to the body
		enemy.createFixture(fixtureDef);
		enemy.setUserData(new EnemyData(forceX, forceY, degree, procentImpulse, enemyCounter, color ));
		//enemy.applyForceToCenter(forceX, forceY, true);

		//enemy.applyLinearImpulse(forceX, forceY, xPosition, yPosition, false);

		this.addJointForBody(this.pointVector.get(0), enemy);
	

		enemy.setAngularVelocity(0.3f);
		enemy.setBullet(false);
		//Dispose of shapes
		circle.dispose();
	
		

		
			}
	
	
	
	
	public void addBall(
			int xPosition, 
			int yPosition, 
			int ballSizeScale, 
			int forceX, 
			int forceY, 
			float degree, 
			float procentImpulse,
			int color
			)
	{
		BodyDef enemyBodyDef = new BodyDef();
		enemyBodyDef.type = BodyType.DynamicBody;
		enemyBodyDef.position.set(xPosition, yPosition);	

		// Create our body in the world using our body definition
		Body enemy = this.box2DWorld.createBody(enemyBodyDef);
		
		
		CircleShape circle = new CircleShape();
		circle.setRadius(Commons.WORLD_HEIGHT/ballSizeScale);

		// Create a fixture definition to apply our shape to
		FixtureDef fixtureDef = new FixtureDef();
		fixtureDef.restitution = 0f;
		fixtureDef.density = 0;
		fixtureDef.friction = (float) 1f;
		//Attach shape to circle;
		fixtureDef.shape = circle;

		// Create our fixture and attach it to the body
		enemy.createFixture(fixtureDef);
		enemy.setUserData(new EnemyData(forceX, forceY, degree, procentImpulse, enemyCounter, color ));
		enemy.applyForceToCenter(forceX, forceY, false);
		enemy.setBullet(false);
		//enemy.applyLinearImpulse(forceX, forceY, xPosition, yPosition, false);

		this.enemyInMoveVector.put(this.enemyCounter, enemy); 
		this.enemyCounter++;

		//Dispose of shapes
		circle.dispose();

	}
	
	public void updateAngularVelPlanet(float x)
	{
		if (x < 0.5)
		{
			this.angular = this.angular + Commons.ANGULAR_STEP;
			if (Math.abs(this.angular) > Commons.MAX_ANGULAR_SPEED)
			{
				this.angular = Commons.MAX_ANGULAR_SPEED;
			}
		}
		else
		{
			this.angular = this.angular - Commons.ANGULAR_STEP;
			
			if (Math.abs(this.angular) > Commons.MAX_ANGULAR_SPEED)
			{
				this.angular = -Commons.MAX_ANGULAR_SPEED;
			}
		}
		
	}
	
	public void keyboardRelease()
	{
		this.angular = this.angular - this.angular * 0.10f; //FIXME: hardcoded
	}


	//Getters and setters
	public World getBox2DWorld() {
		return box2DWorld;
	}

	public void setBox2DWorld(World box2dWorld) {
		box2DWorld = box2dWorld;
	}

	public HashMap<Integer, Body> getEnemyInMoveVector() {
		return enemyInMoveVector;
	}

	public void setEnemyInMoveVector(HashMap<Integer, Body> enemyInMoveVector) {
		this.enemyInMoveVector = enemyInMoveVector;
	}

	public int getEnemyCounter() {
		return enemyCounter;
	}

	public void setEnemyCounter(int enemyCounter) {
		this.enemyCounter = enemyCounter;
	}

	public HashMap<Integer, Body> getEnemyStoppedVector() {
		return enemyStoppedVector;
	}

	public void setEnemyStoppedVector(HashMap<Integer, Body> enemyStoppedVector) {
		this.enemyStoppedVector = enemyStoppedVector;
	}

	public ArrayList<Body> getPlanetVector() {
		return planetVector;
	}

	public void setPlanetVector(ArrayList<Body> planetVector) {
		this.planetVector = planetVector;
	}

	public int getCurrentScore() {
		return currentScore;
	}

	public void setCurrentScore(int currentScore) {
		this.currentScore = currentScore;
	}

	public ArrayList<EnemyData> getDataToRemVector() {
		return dataToRemVector;
	}

	public void setDataToRemVector(ArrayList<EnemyData> dataToRemVector) {
		this.dataToRemVector = dataToRemVector;
	}

	
	
}
