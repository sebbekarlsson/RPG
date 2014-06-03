package com.lucifer.main.instances;

import com.lucifer.main.Item;
import com.lucifer.main.scenes.WorldScene;

public class Bottle extends Item{

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
		else if(type == 3){
			this.setSprite("images/bottles/bottle_poison.png");
			this.setDisplayName("Poison Bottle");
		}
		
		
	}
	
	public void use(){
		if(type == 1){
			if(WorldScene.player.health < 100){
				WorldScene.player.health = 100;
				WorldScene.player.getInventory().getItems().remove(this);
			}
		}
	}

}
