package com.ludum.mighty.assets;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Animation.PlayMode;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

public class PlayerAssets extends AbstractAssets 
{

	static Texture alienSheet;
	static Texture allThingsSheet;
	static Texture endSheet;
	
	public static final int BLUE = 0;
	public static final int BROWN = 1;
	public static final int GREEN = 2;
	public static final int GREY = 3;
	public static final int RED = 4;
	public static final int ROSE = 5;
	public static final int YELLOW = 6;
	public static final int VIOLET = 7;
	
	public static final int ALIEN_BLUE_NORMAL = 0;
	public static final int ALIEN_BLUE_IDLE = 1;
	public static final int ALIEN_BLUE_EXPLOSION = 2;
	public static final int ALIEN_BROWN_NORMAL = 3;
	public static final int ALIEN_BROWN_IDLE = 4;
	public static final int ALIEN_BROWN_EXPLOSION = 5;
	public static final int ALIEN_GREEN_NORMAL = 6;
	public static final int ALIEN_GREEN_IDLE = 7;
	public static final int ALIEN_GREEN_EXPLOSION = 8;
	public static final int ALIEN_GREY_NORMAL = 9;
	public static final int ALIEN_GREY_IDLE = 10;
	public static final int ALIEN_GREY_EXPLOSION = 11;
	public static final int ALIEN_RED_NORMAL = 12;
	public static final int ALIEN_RED_IDLE = 13;
	public static final int ALIEN_RED_EXPLOSION = 14;
	public static final int ALIEN_ROSE_NORMAL = 15;
	public static final int ALIEN_ROSE_IDLE = 16;
	public static final int ALIEN_ROSE_EXPLOSION = 17;
	public static final int ALIEN_YELLOW_NORMAL = 18;
	public static final int ALIEN_YELLOW_IDLE = 19;
	public static final int ALIEN_YELLOW_EXPLOSION = 20;
	public static final int ALIEN_VIOLET_NORMAL = 21;
	public static final int ALIEN_VIOLET_IDLE = 22;
	public static final int ALIEN_VIOLET_EXPLOSION = 23;
	
	public static final int EARTH = 24;
	
	public static final int HIGH_SCORE_SLOGAN = 25;
	public static final int LAST_SCORE_SLOGAN = 26;
	
	public static final int NUM_0 = 27;
	public static final int NUM_1 = 28;
	public static final int NUM_2 = 29;
	public static final int NUM_3 = 30;
	public static final int NUM_4 = 31;
	public static final int NUM_5 = 32;
	public static final int NUM_6 = 33;
	public static final int NUM_7 = 34;
	public static final int NUM_8 = 35;
	public static final int NUM_9 = 36;
	
	ArrayList<TextureRegion> alienBlueNormalList = new ArrayList<TextureRegion>();
	ArrayList<TextureRegion> alienBlueIdleList = new ArrayList<TextureRegion>();
	ArrayList<TextureRegion> alienBlueBombList = new ArrayList<TextureRegion>();

	Animation alienBlueNormalAnim;
	Animation alienBlueIdleAnim;
	Animation alienBlueBombAnim;

	ArrayList<TextureRegion> alienBrownNormalList = new ArrayList<TextureRegion>();
	ArrayList<TextureRegion> alienBrownIdleList = new ArrayList<TextureRegion>();
	ArrayList<TextureRegion> alienBrownBombList = new ArrayList<TextureRegion>();

	Animation alienBrownNormalAnim;
	Animation alienBrownIdleAnim;
	Animation alienBrownBombAnim;

	ArrayList<TextureRegion> alienGreenNormalList = new ArrayList<TextureRegion>();
	ArrayList<TextureRegion> alienGreenIdleList = new ArrayList<TextureRegion>();
	ArrayList<TextureRegion> alienGreenBombList = new ArrayList<TextureRegion>();

	Animation alienGreenNormalAnim;
	Animation alienGreenIdleAnim;
	Animation alienGreenBombAnim;

	ArrayList<TextureRegion> alienGreyNormalList = new ArrayList<TextureRegion>();
	ArrayList<TextureRegion> alienGreyIdleList = new ArrayList<TextureRegion>();
	ArrayList<TextureRegion> alienGreyBombList = new ArrayList<TextureRegion>();

	Animation alienGreyNormalAnim;
	Animation alienGreyIdleAnim;
	Animation alienGreyBombAnim;
	
	ArrayList<TextureRegion> alienRedNormalList = new ArrayList<TextureRegion>();
	ArrayList<TextureRegion> alienRedIdleList = new ArrayList<TextureRegion>();
	ArrayList<TextureRegion> alienRedBombList = new ArrayList<TextureRegion>();

	Animation alienRedNormalAnim;
	Animation alienRedIdleAnim;
	Animation alienRedBombAnim;

	ArrayList<TextureRegion> alienRoseNormalList = new ArrayList<TextureRegion>();
	ArrayList<TextureRegion> alienRoseIdleList = new ArrayList<TextureRegion>();
	ArrayList<TextureRegion> alienRoseBombList = new ArrayList<TextureRegion>();

	Animation alienRoseNormalAnim;
	Animation alienRoseIdleAnim;
	Animation alienRoseBombAnim;

	ArrayList<TextureRegion> alienYellowNormalList = new ArrayList<TextureRegion>();
	ArrayList<TextureRegion> alienYellowIdleList = new ArrayList<TextureRegion>();
	ArrayList<TextureRegion> alienYellowBombList = new ArrayList<TextureRegion>();

	Animation alienYellowNormalAnim;
	Animation alienYellowIdleAnim;
	Animation alienYellowBombAnim;
	
	ArrayList<TextureRegion> alienVioletNormalList = new ArrayList<TextureRegion>();
	ArrayList<TextureRegion> alienVioletIdleList = new ArrayList<TextureRegion>();
	ArrayList<TextureRegion> alienVioletBombList = new ArrayList<TextureRegion>();

	Animation alienVioletNormalAnim;
	Animation alienVioletIdleAnim;
	Animation alienVioletBombAnim;
	
	TextureRegion earthTexture;
	
	TextureRegion highScoreRegion;
	TextureRegion lastScoreRegion;
	TextureRegion num0Region;
	TextureRegion num1Region;
	TextureRegion num2Region;
	TextureRegion num3Region;
	TextureRegion num4Region;
	TextureRegion num5Region;
	TextureRegion num6Region;
	TextureRegion num7Region;
	TextureRegion num8Region;
	TextureRegion num9Region;
	

	

	@Override
	public TextureRegion getAsset(int asset) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Animation getAnimation(int anim) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TextureRegion getAnimation(int anim, float time) {
		
		switch(anim)
		{
		
		
		
		case ALIEN_BLUE_NORMAL:
			return new TextureRegion(this.alienBlueNormalAnim.getKeyFrame(time, true));
		
		case ALIEN_BLUE_IDLE:
			return new TextureRegion(this.alienBlueIdleAnim.getKeyFrame(time, true));		
			
		
		case ALIEN_BLUE_EXPLOSION:			
			if (this.alienBlueBombAnim.isAnimationFinished(time))
				return null;
			return new TextureRegion(this.alienBlueBombAnim.getKeyFrame(time, false));
			
			
		case ALIEN_BROWN_NORMAL:
			return new TextureRegion(this.alienBrownNormalAnim.getKeyFrame(time, true));
		
		case ALIEN_BROWN_IDLE:
			return new TextureRegion(this.alienBrownIdleAnim.getKeyFrame(time, true));		
		
		
		case ALIEN_BROWN_EXPLOSION:			
			if (this.alienBrownBombAnim.isAnimationFinished(time))
				return null;
			return new TextureRegion(this.alienBrownBombAnim.getKeyFrame(time, false));
			
			
		case ALIEN_GREEN_NORMAL:
			return new TextureRegion(this.alienGreenNormalAnim.getKeyFrame(time, true));
		
		case ALIEN_GREEN_IDLE:
			return new TextureRegion(this.alienGreenIdleAnim.getKeyFrame(time, true));		
			
		
		case ALIEN_GREEN_EXPLOSION:			
			if (this.alienGreenBombAnim.isAnimationFinished(time))
				return null;
			return new TextureRegion(this.alienGreenBombAnim.getKeyFrame(time, false));
		
			
		case ALIEN_GREY_NORMAL:
			return new TextureRegion(this.alienGreyNormalAnim.getKeyFrame(time, true));
			
		case ALIEN_GREY_IDLE:
			return new TextureRegion(this.alienGreyIdleAnim.getKeyFrame(time, true));		
		
		
		case ALIEN_GREY_EXPLOSION:			
			if (this.alienGreyBombAnim.isAnimationFinished(time))
				return null;
			return new TextureRegion(this.alienGreyBombAnim.getKeyFrame(time, false));
			
			
	
		case ALIEN_RED_NORMAL:
			return new TextureRegion(this.alienRedNormalAnim.getKeyFrame(time, true));
	
		case ALIEN_RED_IDLE:
			return new TextureRegion(this.alienRedIdleAnim.getKeyFrame(time, true));		
		
		
		case ALIEN_RED_EXPLOSION:			
			if (this.alienRedBombAnim.isAnimationFinished(time))
				return null;
			return new TextureRegion(this.alienRedBombAnim.getKeyFrame(time, false));
		
			
		case ALIEN_ROSE_NORMAL:
			return new TextureRegion(this.alienRoseNormalAnim.getKeyFrame(time, true));
			
		case ALIEN_ROSE_IDLE:
			return new TextureRegion(this.alienRoseIdleAnim.getKeyFrame(time, true));		
		
		
		case ALIEN_ROSE_EXPLOSION:			
			if (this.alienRoseBombAnim.isAnimationFinished(time))
				return null;
			return new TextureRegion(this.alienRoseBombAnim.getKeyFrame(time, false));
			
			
		case ALIEN_YELLOW_NORMAL:
			return new TextureRegion(this.alienYellowNormalAnim.getKeyFrame(time, true));
			
		case ALIEN_YELLOW_IDLE:
			return new TextureRegion(this.alienYellowIdleAnim.getKeyFrame(time, true));		
			
			
		case ALIEN_YELLOW_EXPLOSION:			
			if (this.alienYellowBombAnim.isAnimationFinished(time))
				return null;
			return new TextureRegion(this.alienYellowBombAnim.getKeyFrame(time, false));
			
			
		case ALIEN_VIOLET_NORMAL:
			return new TextureRegion(this.alienVioletNormalAnim.getKeyFrame(time, true));
			
		case ALIEN_VIOLET_IDLE:
			return new TextureRegion(this.alienVioletIdleAnim.getKeyFrame(time, true));		
			
		
		case ALIEN_VIOLET_EXPLOSION:			
			if (this.alienVioletBombAnim.isAnimationFinished(time))
				return null;
			return new TextureRegion(this.alienVioletBombAnim.getKeyFrame(time, false));
						
			
		case EARTH:
			return this.earthTexture;
		
		case HIGH_SCORE_SLOGAN:
			return new TextureRegion(this.highScoreRegion);
			
		case LAST_SCORE_SLOGAN:
			return new TextureRegion(this.lastScoreRegion);
			
		case NUM_0:
			return new TextureRegion(this.num0Region);
			
		case NUM_1:
			return new TextureRegion(this.num1Region);
	
		case NUM_2:
			return new TextureRegion(this.num2Region);
			
		case NUM_3:
			return new TextureRegion(this.num3Region);
			
		case NUM_4:
			return new TextureRegion(this.num4Region);
			
		case NUM_5:
			return new TextureRegion(this.num5Region);
			
		case NUM_6:
			return new TextureRegion(this.num6Region);
			
		case NUM_7:
			return new TextureRegion(this.num7Region);
			
		case NUM_8:
			return new TextureRegion(this.num8Region);
			
		case NUM_9:
			return new TextureRegion(this.num9Region);
					
		}
		
		return null;
	}

	@Override
	public Rectangle getPolygonon(int assetType, float time) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void load() {
		
		alienSheet = loadTexture("img/all_aliens.png");
		allThingsSheet = loadTexture("img/allthings.png");
		endSheet = loadTexture("img/combo_things.png");
		
		alienSheet.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		allThingsSheet.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		endSheet.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		
		this.earthTexture = new TextureRegion(allThingsSheet, 0,0,100, 100);
		
		this.highScoreRegion = new TextureRegion(endSheet, 0,0, 200, 48);
		this.lastScoreRegion = new TextureRegion(endSheet, 0, 48, 200, 48);
		
		this.num0Region = new TextureRegion(endSheet, 0, 96, 24, 24);
		this.num1Region = new TextureRegion(endSheet, 24, 96, 24, 24);
		this.num2Region = new TextureRegion(endSheet, 48, 96, 24, 24);
		this.num3Region = new TextureRegion(endSheet, 72, 96, 24, 24);
		this.num4Region = new TextureRegion(endSheet, 96, 96, 24, 24);
		this.num5Region = new TextureRegion(endSheet, 120, 96, 24, 24);
		this.num6Region = new TextureRegion(endSheet, 144, 96, 24, 24);
		this.num7Region = new TextureRegion(endSheet, 168, 96, 24, 24);
		this.num8Region = new TextureRegion(endSheet, 192, 96, 24, 24);
		this.num9Region = new TextureRegion(endSheet, 216, 96, 24, 24);

		//Blue Alien
		int startXPoint = 0;
		int startYPoint = 0;
		
		//Read 9 normals
		for (int i = 0 ; i < 9 ; i++)
		{
			this.alienBlueNormalList.add(new TextureRegion(alienSheet, 
					i * 24 + startXPoint, startYPoint, 24, 24));
		}
		
		//Read 5 idles
		startXPoint = 24 * 9;
		for (int i = 0; i < 5; i++)
		{
			this.alienBlueIdleList.add(new TextureRegion(alienSheet, 
					i * 24 + startXPoint, startYPoint, 24, 24));
		}
		
		startXPoint = 24 * 14;
		for (int i = 0; i < 5; i++)
		{
			this.alienBlueBombList.add(new TextureRegion(alienSheet, 
					i * 24 + startXPoint, startYPoint, 24, 24));
		}
				
		

		//Brown Alien
		startXPoint = 0;
		startYPoint = 24;
		
		//Read 9 normals
		for (int i = 0 ; i < 9 ; i++)
		{
			this.alienBrownNormalList.add(new TextureRegion(alienSheet, 
					i * 24 + startXPoint, startYPoint, 24, 24));
		}
		
		//Read 5 idles
		startXPoint = 24 * 9;
		for (int i = 0; i < 5; i++)
		{
			this.alienBrownIdleList.add(new TextureRegion(alienSheet, 
					i * 24 + startXPoint, startYPoint, 24, 24));
		}
		
		startXPoint = 24 * 14;
		for (int i = 0; i < 5; i++)
		{
			this.alienBrownBombList.add(new TextureRegion(alienSheet, 
					i * 24 + startXPoint, startYPoint, 24, 24));
		
		}

		
		//Green Alien
		startXPoint = 0;
		startYPoint = 24*2;
		
		//Read 9 normals
		for (int i = 0 ; i < 9 ; i++)
		{
			this.alienGreenNormalList.add(new TextureRegion(alienSheet, 
					i * 24 + startXPoint, startYPoint, 24, 24));
		}
		
		//Read 5 idles
		startXPoint = 24 * 9;
		for (int i = 0; i < 5; i++)
		{
			this.alienGreenIdleList.add(new TextureRegion(alienSheet, 
					i * 24 + startXPoint, startYPoint, 24, 24));
		}
		
		startXPoint = 24 * 14;
		for (int i = 0; i < 5; i++)
		{
			this.alienGreenBombList.add(new TextureRegion(alienSheet, 
					i * 24 + startXPoint, startYPoint, 24, 24));
		
		}
		
		
		//Grey Alien
		startXPoint = 0;
		startYPoint = 24 * 3;
		
		//Read 9 normals
		for (int i = 0 ; i < 9 ; i++)
		{
			this.alienGreyNormalList.add(new TextureRegion(alienSheet, 
					i * 24 + startXPoint, startYPoint, 24, 24));
		}
		
		//Read 5 idles
		startXPoint = 24 * 9;
		for (int i = 0; i < 5; i++)
		{
			this.alienGreyIdleList.add(new TextureRegion(alienSheet, 
					i * 24 + startXPoint, startYPoint, 24, 24));
		}
		
		startXPoint = 24 * 14;
		for (int i = 0; i < 5; i++)
		{
			this.alienGreyBombList.add(new TextureRegion(alienSheet, 
					i * 24 + startXPoint, startYPoint, 24, 24));
		
		}
		
		//Red Alien
		startXPoint = 0;
		startYPoint = 24 * 4;
		
		//Read 9 normals
		for (int i = 0 ; i < 9 ; i++)
		{
			this.alienRedNormalList.add(new TextureRegion(alienSheet, 
					i * 24 + startXPoint, startYPoint, 24, 24));
		}
		
		//Read 5 idles
		startXPoint = 24 * 9;
		for (int i = 0; i < 5; i++)
		{
			this.alienRedIdleList.add(new TextureRegion(alienSheet, 
					i * 24 + startXPoint, startYPoint, 24, 24));
		}
		
		startXPoint = 24 * 14;
		for (int i = 0; i < 5; i++)
		{
			this.alienRedBombList.add(new TextureRegion(alienSheet, 
					i * 24 + startXPoint, startYPoint, 24, 24));
		
		}
		
		
		//Rose Alien
		startXPoint = 0;
		startYPoint = 24 * 5;
		
		//Read 9 normals
		for (int i = 0 ; i < 9 ; i++)
		{
			this.alienRoseNormalList.add(new TextureRegion(alienSheet, 
					i * 24 + startXPoint, startYPoint, 24, 24));
		}
		
		//Read 5 idles
		startXPoint = 24 * 9;
		for (int i = 0; i < 5; i++)
		{
			this.alienRoseIdleList.add(new TextureRegion(alienSheet, 
					i * 24 + startXPoint, startYPoint, 24, 24));
		}
		
		startXPoint = 24 * 14;
		for (int i = 0; i < 5; i++)
		{
			this.alienRoseBombList.add(new TextureRegion(alienSheet, 
					i * 24 + startXPoint, startYPoint, 24, 24));
		
		}
		
		//Yellow Alien
		startXPoint = 0;
		startYPoint = 24 * 6;
		
		//Read 9 normals
		for (int i = 0 ; i < 9 ; i++)
		{
			this.alienYellowNormalList.add(new TextureRegion(alienSheet, 
					i * 24 + startXPoint, startYPoint, 24, 24));
		}
		
		//Read 5 idles
		startXPoint = 24 * 9;
		for (int i = 0; i < 5; i++)
		{
			this.alienYellowIdleList.add(new TextureRegion(alienSheet, 
					i * 24 + startXPoint, startYPoint, 24, 24));
		}
		
		startXPoint = 24 * 14;
		for (int i = 0; i < 5; i++)
		{
			this.alienYellowBombList.add(new TextureRegion(alienSheet, 
					i * 24 + startXPoint, startYPoint, 24, 24));
		
		}
		
		
		//Rose Alien
		startXPoint = 0;
		startYPoint = 24 * 7;
		
		//Read 9 normals
		for (int i = 0 ; i < 9 ; i++)
		{
			this.alienVioletNormalList.add(new TextureRegion(alienSheet, 
					i * 24 + startXPoint, startYPoint, 24, 24));
		}
		
		//Read 5 idles
		startXPoint = 24 * 9;
		for (int i = 0; i < 5; i++)
		{
			this.alienVioletIdleList.add(new TextureRegion(alienSheet, 
					i * 24 + startXPoint, startYPoint, 24, 24));
		}
		
		startXPoint = 24 * 14;
		for (int i = 0; i < 5; i++)
		{
			this.alienVioletBombList.add(new TextureRegion(alienSheet, 
					i * 24 + startXPoint, startYPoint, 24, 24));
		
		}

		
		//Animations
		//Blue
		this.alienBlueNormalAnim = new Animation(0.20f, 
				this.alienBlueNormalList.get(0), 
				this.alienBlueNormalList.get(1), 
				this.alienBlueNormalList.get(2), 
				this.alienBlueNormalList.get(1), 
				this.alienBlueNormalList.get(0), 
				this.alienBlueNormalList.get(3),
				this.alienBlueNormalList.get(4), 
				this.alienBlueNormalList.get(5),
				this.alienBlueNormalList.get(4),
				this.alienBlueNormalList.get(3),
				this.alienBlueNormalList.get(6),
				this.alienBlueNormalList.get(7),
				this.alienBlueNormalList.get(8),
				this.alienBlueNormalList.get(7),
				this.alienBlueNormalList.get(6));
		this.alienBlueNormalAnim.setPlayMode(PlayMode.LOOP);
		
		this.alienBlueIdleAnim = new Animation(0.20f, this.alienBlueIdleList.get(0),
				this.alienBlueIdleList.get(1),
				this.alienBlueIdleList.get(2), 
				this.alienBlueIdleList.get(3), 
				this.alienBlueIdleList.get(4));
		this.alienBlueIdleAnim.setPlayMode(PlayMode.LOOP_RANDOM);
		
		this.alienBlueBombAnim = new Animation(0.10f, this.alienBlueBombList.get(0),
				this.alienBlueBombList.get(1),
				this.alienBlueBombList.get(2),
				this.alienBlueBombList.get(3),
				this.alienBlueBombList.get(4));
		this.alienBlueBombAnim.setPlayMode(PlayMode.NORMAL);
		
		
		
		//Brown
		this.alienBrownNormalAnim = new Animation(0.20f, 
				this.alienBrownNormalList.get(0), 
				this.alienBrownNormalList.get(1), 
				this.alienBrownNormalList.get(2), 
				this.alienBrownNormalList.get(1), 
				this.alienBrownNormalList.get(0), 
				this.alienBrownNormalList.get(3),
				this.alienBrownNormalList.get(4), 
				this.alienBrownNormalList.get(5),
				this.alienBrownNormalList.get(4),
				this.alienBrownNormalList.get(3),
				this.alienBrownNormalList.get(6),
				this.alienBrownNormalList.get(7),
				this.alienBrownNormalList.get(8),
				this.alienBrownNormalList.get(7),
				this.alienBrownNormalList.get(6));
		this.alienBrownNormalAnim.setPlayMode(PlayMode.LOOP);
		
		this.alienBrownIdleAnim = new Animation(0.20f, this.alienBrownIdleList.get(0),
				this.alienBrownIdleList.get(1),
				this.alienBrownIdleList.get(2), 
				this.alienBrownIdleList.get(3), 
				this.alienBrownIdleList.get(4));
		this.alienBrownIdleAnim.setPlayMode(PlayMode.LOOP_RANDOM);
		
		this.alienBrownBombAnim = new Animation(0.10f, this.alienBrownBombList.get(0),
				this.alienBrownBombList.get(1),
				this.alienBrownBombList.get(2),
				this.alienBrownBombList.get(3),
				this.alienBrownBombList.get(4));
		this.alienBrownBombAnim.setPlayMode(PlayMode.NORMAL);
		
		
		//Green
		this.alienGreenNormalAnim = new Animation(0.20f, 
				this.alienGreenNormalList.get(0), 
				this.alienGreenNormalList.get(1), 
				this.alienGreenNormalList.get(2), 
				this.alienGreenNormalList.get(1), 
				this.alienGreenNormalList.get(0), 
				this.alienGreenNormalList.get(3),
				this.alienGreenNormalList.get(4), 
				this.alienGreenNormalList.get(5),
				this.alienGreenNormalList.get(4),
				this.alienGreenNormalList.get(3),
				this.alienGreenNormalList.get(6),
				this.alienGreenNormalList.get(7),
				this.alienGreenNormalList.get(8),
				this.alienGreenNormalList.get(7),
				this.alienGreenNormalList.get(6));
		this.alienGreenNormalAnim.setPlayMode(PlayMode.LOOP);
		
		this.alienGreenIdleAnim = new Animation(0.20f, this.alienGreenIdleList.get(0),
				this.alienGreenIdleList.get(1),
				this.alienGreenIdleList.get(2), 
				this.alienGreenIdleList.get(3), 
				this.alienGreenIdleList.get(4));
		this.alienGreenIdleAnim.setPlayMode(PlayMode.LOOP_RANDOM);
		
		this.alienGreenBombAnim = new Animation(0.10f, this.alienGreenBombList.get(0),
				this.alienGreenBombList.get(1),
				this.alienGreenBombList.get(2),
				this.alienGreenBombList.get(3),
				this.alienGreenBombList.get(4));
		this.alienGreenBombAnim.setPlayMode(PlayMode.NORMAL);
		
		//Grey
		this.alienGreyNormalAnim = new Animation(0.20f, 
				this.alienGreyNormalList.get(0), 
				this.alienGreyNormalList.get(1), 
				this.alienGreyNormalList.get(2), 
				this.alienGreyNormalList.get(1), 
				this.alienGreyNormalList.get(0), 
				this.alienGreyNormalList.get(3),
				this.alienGreyNormalList.get(4), 
				this.alienGreyNormalList.get(5),
				this.alienGreyNormalList.get(4),
				this.alienGreyNormalList.get(3),
				this.alienGreyNormalList.get(6),
				this.alienGreyNormalList.get(7),
				this.alienGreyNormalList.get(8),
				this.alienGreyNormalList.get(7),
				this.alienGreyNormalList.get(6));
		this.alienGreyNormalAnim.setPlayMode(PlayMode.LOOP);
		
		this.alienGreyIdleAnim = new Animation(0.20f, this.alienGreyIdleList.get(0),
				this.alienGreyIdleList.get(1),
				this.alienGreyIdleList.get(2), 
				this.alienGreyIdleList.get(3), 
				this.alienGreyIdleList.get(4));
		this.alienGreyIdleAnim.setPlayMode(PlayMode.LOOP_RANDOM);
		
		this.alienGreyBombAnim = new Animation(0.10f, this.alienGreyBombList.get(0),
				this.alienGreyBombList.get(1),
				this.alienGreyBombList.get(2),
				this.alienGreyBombList.get(3),
				this.alienGreyBombList.get(4));
		this.alienGreyBombAnim.setPlayMode(PlayMode.NORMAL);
		
		//Red
		this.alienRedNormalAnim = new Animation(0.20f, 
				this.alienRedNormalList.get(0), 
				this.alienRedNormalList.get(1), 
				this.alienRedNormalList.get(2), 
				this.alienRedNormalList.get(1), 
				this.alienRedNormalList.get(0), 
				this.alienRedNormalList.get(3),
				this.alienRedNormalList.get(4), 
				this.alienRedNormalList.get(5),
				this.alienRedNormalList.get(4),
				this.alienRedNormalList.get(3),
				this.alienRedNormalList.get(6),
				this.alienRedNormalList.get(7),
				this.alienRedNormalList.get(8),
				this.alienRedNormalList.get(7),
				this.alienRedNormalList.get(6));
		this.alienRedNormalAnim.setPlayMode(PlayMode.LOOP);
		
		this.alienRedIdleAnim = new Animation(0.20f, this.alienRedIdleList.get(0),
				this.alienRedIdleList.get(1),
				this.alienRedIdleList.get(2), 
				this.alienRedIdleList.get(3), 
				this.alienRedIdleList.get(4));
		this.alienRedIdleAnim.setPlayMode(PlayMode.LOOP_RANDOM);
		
		this.alienRedBombAnim = new Animation(0.10f, this.alienRedBombList.get(0),
				this.alienRedBombList.get(1),
				this.alienRedBombList.get(2),
				this.alienRedBombList.get(3),
				this.alienRedBombList.get(4));
		this.alienRedBombAnim.setPlayMode(PlayMode.NORMAL);
		
		
		//Rose
		this.alienRoseNormalAnim = new Animation(0.20f, 
				this.alienRoseNormalList.get(0), 
				this.alienRoseNormalList.get(1), 
				this.alienRoseNormalList.get(2), 
				this.alienRoseNormalList.get(1), 
				this.alienRoseNormalList.get(0), 
				this.alienRoseNormalList.get(3),
				this.alienRoseNormalList.get(4), 
				this.alienRoseNormalList.get(5),
				this.alienRoseNormalList.get(4),
				this.alienRoseNormalList.get(3),
				this.alienRoseNormalList.get(6),
				this.alienRoseNormalList.get(7),
				this.alienRoseNormalList.get(8),
				this.alienRoseNormalList.get(7),
				this.alienRoseNormalList.get(6));
		this.alienRoseNormalAnim.setPlayMode(PlayMode.LOOP);
		
		this.alienRoseIdleAnim = new Animation(0.20f, this.alienRoseIdleList.get(0),
				this.alienRoseIdleList.get(1),
				this.alienRoseIdleList.get(2), 
				this.alienRoseIdleList.get(3), 
				this.alienRoseIdleList.get(4));
		this.alienRoseIdleAnim.setPlayMode(PlayMode.LOOP_RANDOM);
		
		this.alienRoseBombAnim = new Animation(0.10f, this.alienRoseBombList.get(0),
				this.alienRoseBombList.get(1),
				this.alienRoseBombList.get(2),
				this.alienRoseBombList.get(3),
				this.alienRoseBombList.get(4));
		this.alienRoseBombAnim.setPlayMode(PlayMode.NORMAL);
		
		//Yellow
		this.alienYellowNormalAnim = new Animation(0.20f, 
				this.alienYellowNormalList.get(0), 
				this.alienYellowNormalList.get(1), 
				this.alienYellowNormalList.get(2), 
				this.alienYellowNormalList.get(1), 
				this.alienYellowNormalList.get(0), 
				this.alienYellowNormalList.get(3),
				this.alienYellowNormalList.get(4), 
				this.alienYellowNormalList.get(5),
				this.alienYellowNormalList.get(4),
				this.alienYellowNormalList.get(3),
				this.alienYellowNormalList.get(6),
				this.alienYellowNormalList.get(7),
				this.alienYellowNormalList.get(8),
				this.alienYellowNormalList.get(7),
				this.alienYellowNormalList.get(6));
		this.alienYellowNormalAnim.setPlayMode(PlayMode.LOOP);
		
		this.alienYellowIdleAnim = new Animation(0.20f, this.alienYellowIdleList.get(0),
				this.alienYellowIdleList.get(1),
				this.alienYellowIdleList.get(2), 
				this.alienYellowIdleList.get(3), 
				this.alienYellowIdleList.get(4));
		this.alienYellowIdleAnim.setPlayMode(PlayMode.LOOP_RANDOM);
		
		this.alienYellowBombAnim = new Animation(0.10f, this.alienYellowBombList.get(0),
				this.alienYellowBombList.get(1),
				this.alienYellowBombList.get(2),
				this.alienYellowBombList.get(3),
				this.alienYellowBombList.get(4));
		this.alienYellowBombAnim.setPlayMode(PlayMode.NORMAL);
		
		//Violet
		this.alienVioletNormalAnim = new Animation(0.20f, 
				this.alienVioletNormalList.get(0), 
				this.alienVioletNormalList.get(1), 
				this.alienVioletNormalList.get(2), 
				this.alienVioletNormalList.get(1), 
				this.alienVioletNormalList.get(0), 
				this.alienVioletNormalList.get(3),
				this.alienVioletNormalList.get(4), 
				this.alienVioletNormalList.get(5),
				this.alienVioletNormalList.get(4),
				this.alienVioletNormalList.get(3),
				this.alienVioletNormalList.get(6),
				this.alienVioletNormalList.get(7),
				this.alienVioletNormalList.get(8),
				this.alienVioletNormalList.get(7),
				this.alienVioletNormalList.get(6));
		this.alienVioletNormalAnim.setPlayMode(PlayMode.LOOP);
		
		this.alienVioletIdleAnim = new Animation(0.20f, this.alienVioletIdleList.get(0),
				this.alienVioletIdleList.get(1),
				this.alienVioletIdleList.get(2), 
				this.alienVioletIdleList.get(3), 
				this.alienVioletIdleList.get(4));
		this.alienVioletIdleAnim.setPlayMode(PlayMode.LOOP_RANDOM);
		
		this.alienVioletBombAnim = new Animation(0.10f, this.alienVioletBombList.get(0),
				this.alienVioletBombList.get(1),
				this.alienVioletBombList.get(2),
				this.alienVioletBombList.get(3),
				this.alienVioletBombList.get(4));
		this.alienVioletBombAnim.setPlayMode(PlayMode.NORMAL);
		
		
	}
	

}
