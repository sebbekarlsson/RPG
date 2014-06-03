package com.lucifer.main;

import java.awt.Dimension;

import com.lucifer.main.instances.ItemBubble;
import com.lucifer.main.instances.Player;
import com.lucifer.main.scenes.WorldScene;

public class Item extends Instance {


	public Item(int x, int y) {
		super(x, y);
		this.setHitBoxSize(new Dimension(16,16));
	}

	public void tick(){
		checkForPickups();
		

		if(isOutSideRoom()){
			Game.getCurrentScene().destroy(this);
		}
	}
	
	public void use(){}
	
	public void checkForPickups(){
		Player player = WorldScene.player;
		if(player.x+(player.getHitBox().width/2) >= x && player.x+(player.getHitBox().width/2) <= x+hitbox.width && player.y+(player.getHitBox().height/2) >= y && player.y+(player.getHitBox().height/2) <= y+hitbox.height ){
			if(Game.vk_enter){
				putInsideBubble();
				Game.vk_enter = false;
			}
		}
	}

	public void putInsideBubble(){
		ItemBubble bubble = new ItemBubble(x,y,this);
		Game.getCurrentScene().instantiate(bubble);
		Game.getCurrentScene().destroy(this);
	}
}
