package com.lucifer.main;

import com.lucifer.main.scenes.WorldScene;

public class Food extends Item {

	int heal;
	
	public Food(int x, int y) {
		super(x, y);
		
	}
	
	public void use(){
		if(WorldScene.player.health < 100){
			WorldScene.player.health += heal;
			WorldScene.player.getInventory().getItems().remove(WorldScene.markerX/16);
		}
	}
	
	public void setHeal(int heal){
		this.heal = heal;
	}

}
