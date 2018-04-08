package com.imaginegames.mmgame;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.imaginegames.mmgame.screens.MainMenuScreen;

public class GameControl extends Game {
	
	public SpriteBatch batch;
	
	public static final String GENERATION = "Alpha"; 
	public static final String RELEASE = "0.4"; //Android release + new textures
	public static final String VERSION = GENERATION + " " + RELEASE;
	
	public static boolean ENGLISH_LANGUAGE = false;
	public static boolean XY_TRACKING = false;
	public static float GAMESPEED = 1.0f;
	public static boolean FULLSCREEN = false;
	public static boolean SHOW_STAT = false;
	
	@Override
	public void create() {
		batch = new SpriteBatch();
		this.setScreen(new MainMenuScreen(this));
	}

	@Override
	public void render() {
		super.render();
	}
}