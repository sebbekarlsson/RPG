package com.lucifer.main.instances;

import com.lucifer.main.Instance;

public class Bottle extends Instance{

	int type;

	public Bottle(int x, int y,int type) {
		super(x, y);
		this.type = type;
		if(type == 0){
			this.setSprite("images/bottles/bottle.png");
			this.setDisplayName("Empty Bottle");
		}else if(type == 1){
			this.setSprite("images/bottles/bottle_health.png");
			this.setDisplayName("Health Bottle");
		}
		else if(type == 2){
			this.setSprite("images/bottles/bottle_speed.png");
			this.setDisplayName("Speed Bottle");
		}
		
		
	}

}
