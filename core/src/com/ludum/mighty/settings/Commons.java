package com.ludum.mighty.settings;

/**
 * 
 * @author hector
 *
 */
public class Commons 
{
	
	//World Height
	public static final int WORLD_HEIGHT = 600;
	
	//World Width
	public static final int WORLD_WIDTH = 1000;
	
	//To apply a staic seedO
	public static final int WORLD_SEED = 0;
	
	//Maximum amplitude of the linear force of the enemies
	public static final int DEGREE_AMPLITUDE = 160;
	
	//Maximum amplitude of the linear force of the enemies
	public static final float MAX_AMPLITUDE = (float) 1.0;
	
	//Max time to crash to earth before updating the angular force
	public static final int MAX_TIME_TO_CRASH = 5 * 1000;
	
	//To avoid to much deviation in the enemies
	public static final float MAX_DEGREE_REDUCTION = (float) 0.10;
	
	//Conect-three!
	public static final int MAX_COMPARISON = 3;
	
	//Different number of enemies
	public static final int MAX_COLORS = 8;
	
	public static final int EXTRA_COLOR_PER_LEVEL = 2;
	
	public static final long MAX_TIME_IDLE = 2 * 1000;
	
	public static final int MAX_DISTANCE = 1000;
	
	//Constant to multiply the radius of the planet (more radius => more gravity)
	public static final int MAX_RADIUS = 10;
	
	//Extra enemies active per level (2 extra enemies in level 1 means 3 enemies)
	public static final int EXTRA_ENEMIES = 4;
	
	//Score given when a enemy is killed
	public static final int SCORE_NORMAL_KILL = 100;
	
	public static final int MIN_ATMOSPHERE_LEN = 190;
	
	//Time since last enemy was killed (it allows/blocks reactivations of stopped enemies
	public static final int TIME_SINCE_LAST_FREED = 2 * 1000;
	
	public static final float MAX_ANGULAR_SPEED = 1.0f;
	
	public static final float ANGULAR_STEP = 0.01f;
	
	//Relative radius of the enemy (adjust to have 24 x 24 pixels)
	public static final int ENEMY_SIZE = 48;
	
	//Adjust to have 100 x 100 pixels
	public static final int PLANET_REL_RADIUS = 12;
	
	public static final int MAX_ENEMIES = 100;
	

	
	
	
}
