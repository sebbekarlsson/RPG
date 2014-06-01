package com.lucifer.main;

import java.awt.Graphics;
import java.awt.Image;

public class Instance {
	
	public int x,y;
	Image sprite;
	
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
		this.sprite = ImageLoader.load(path);
	}

}
