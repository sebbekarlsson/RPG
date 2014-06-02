package com.lucifer.main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;

import com.lucifer.main.instances.Obstacle;
import com.lucifer.main.instances.tiles.GrassTile;

public class Instance {

	public int x,y;
	public Image sprite;
	private String displayName;
	Rectangle hitbox = new Rectangle();

	public Instance(int x, int y){
		this.x = x;
		this.y = y;



	}

	public void tick(){}
	public void draw(Graphics g){
		this.drawDefaultSprite(g);
	}

	protected void drawDefaultSprite(Graphics g){
		g.drawImage(sprite, x, y, null);

		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.blue);
		if(this instanceof Obstacle){
			g2d.setColor(Color.red);
		}
		if(this instanceof GrassTile){
			g2d.setColor(Color.GRAY);
		}
		//g2d.draw(hitbox);
		hitbox.x = x;
		hitbox.y = y;
		this.hitbox.setSize(new Dimension(sprite.getWidth(null),sprite.getHeight(null)));

	}

	public void setSprite(String path){
		Image image = ImageLoader.load(path);
		if(this.sprite != image){
			this.sprite = image;
		}
	}

	public boolean isOutSideView(){
		return x+100 < -Game.getCurrentScene().camera.x||
				x > -Game.getCurrentScene().camera.x+Game.RENDERSIZE.width||
				y+100 < -Game.getCurrentScene().camera.y||
				y > -Game.getCurrentScene().camera.y+Game.RENDERSIZE.height;
	}

	public void setHitBoxSize(Dimension d){
		this.hitbox.setSize(d);
	}
	
	public void setDisplayName(String name){
		this.displayName = name;
	}
	
	public String getDisplayName(){
		return this.displayName;
	}

}
