package com.imaginegames.mmgame.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.imaginegames.mmgame.GameControl;
import com.imaginegames.mmgame.tools.CollisionRect;

public class Bullet {
	
	public static float SPEED = 1500;
	
	private static final float SCALE = 1f;
	public static final float WIDTH = 16 * SCALE;
	public static final float HEIGHT = 8 * SCALE;
	public float x, y; // Don't do variable a static if it have a many objects with their own parameters for this variable
	int speed_direction;
	
	Texture x_line, y_line, rocket;
	private CollisionRect bullet_rect;
	
	public boolean remove = false;;
	
	public Bullet (float x, float y, int speed_direction) {
		SPEED = SPEED * GameControl.GAMESPEED;
		this.x = x;
		this.y = y;
		
		x_line = new Texture("x_line.png");
		y_line = new Texture("y_line.png");
		rocket = new Texture("bullet.png");
		
		this.speed_direction = speed_direction;
		bullet_rect = new CollisionRect(x, y, WIDTH, HEIGHT);
		
		}
	public void update(float deltaTime) {
		x += speed_direction * SPEED * deltaTime;
		if (y > Gdx.graphics.getHeight() || y < 0 - HEIGHT || x < 0 - WIDTH || x > Gdx.graphics.getWidth()) {
			remove = true;
		}
		bullet_rect.move(x, y);
	}
	public void render(SpriteBatch batch, float delta) {
		if (speed_direction == 1) {
			batch.draw(rocket, x, y, WIDTH, HEIGHT);
			if (GameControl.SHOW_STAT) {
			batch.draw(x_line, x + WIDTH, y, 1, HEIGHT);
			batch.draw(x_line, x, y, 1, HEIGHT);
			batch.draw(y_line, x, y + HEIGHT, WIDTH, 1);
			batch.draw(y_line, x, y, WIDTH, 1);
			}
		}
		else if (speed_direction == -1) {
			batch.draw(rocket, x + WIDTH, y, -WIDTH, HEIGHT);
			if (GameControl.SHOW_STAT) {
			batch.draw(x_line, x, y, 1, HEIGHT);
			batch.draw(x_line, x + WIDTH, y, 1, HEIGHT);
			batch.draw(y_line, x, y, WIDTH, 1);
			batch.draw(y_line, x, y + HEIGHT, WIDTH, 1);
			}
			
		}
	}
	
	public CollisionRect getCollisionRect() {
		return bullet_rect;
	}

}
