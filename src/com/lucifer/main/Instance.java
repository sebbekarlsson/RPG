package com.lucifer.main;

import java.awt.Graphics;
import java.awt.Image;

public class Instance {

	public int x,y;
	public Image sprite;

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

}
