package com.lucifer.main.instances;

import com.lucifer.main.Game;
import com.lucifer.main.Instance;
import com.lucifer.main.Inventory;
import com.lucifer.main.scenes.WorldScene;

public class Player extends Instance {

	int speed = 2;
	public int health = 100;
	boolean collides = false;
	Inventory inventory = new Inventory(8);

	public Player(int x, int y) {
		super(x, y);
		this.setSprite("images/player/player_down.png");
	}



	public void tick(){

		for(int i = 0; i < Game.getCurrentScene().getInstances().size(); i++){
			Instance instance = Game.getCurrentScene().getInstances().get(i);
			if(instance instanceof Obstacle){



				
				

			}
			
			
			if(Game.vk_d && inventory.getInstances().size() > 0 && WorldScene.markerX/16 < inventory.getInstances().size()){
				
				
				Instance item = inventory.getInstances().get(WorldScene.markerX/16);
				item.x = x;
				item.y = y;
				ItemBubble bubble = new ItemBubble(x,y,item);
				Game.getCurrentScene().instantiate(bubble);
				
				inventory.getInstances().remove(WorldScene.markerX/16);
				Game.vk_d = false;
				
				
			}
			
		}



		if(Game.vk_up){
			y -= speed;
			this.setSprite("images/player/player_up.png");
		}

		if(Game.vk_down){
			y += speed;
			this.setSprite("images/player/player_down.png");
		}

		if(Game.vk_left){
			x -= speed;
			this.setSprite("images/player/player_left.png");
		}

		if(Game.vk_right){
			x += speed;
			this.setSprite("images/player/player_right.png");
		}


	}
	
	public Inventory getInventory(){
		return this.inventory;
	}

}
