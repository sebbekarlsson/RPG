package com.lucifer.main.instances;

import java.awt.Dimension;

import com.lucifer.main.Game;
import com.lucifer.main.Instance;
import com.lucifer.main.Inventory;
import com.lucifer.main.Item;
import com.lucifer.main.scenes.WorldScene;

public class Player extends Instance {

	int speed = 2;
	public int health = 50;
	boolean collides = false;
	Inventory inventory = new Inventory(8);

	public Player(int x, int y) {
		super(x, y);
		this.setSprite("images/player/player_down.png");
		this.setHitBoxSize(new Dimension(sprite.getWidth(null),sprite.getHeight(null)));
	}



	public void tick(){

		for(int i = 0; i < Game.getCurrentScene().getInstances().size(); i++){
			Instance instance = Game.getCurrentScene().getInstances().get(i);
			if(instance instanceof Obstacle){


				if(x-(getHitBox().width/2) <= instance.x && x-(getHitBox().width/2) >= instance.x-(instance.getHitBox().width/2) && y >= instance.y && y <= instance.y+instance.getHitBox().height){
					x -= speed;
				}

				if(x-(getHitBox().width/2) >= instance.x && x-(getHitBox().width/2) <= instance.x+(instance.getHitBox().width/2) && y >= instance.y && y <= instance.y+instance.getHitBox().height){
					x += speed;
				}

				if(x >= instance.x && x <= instance.x+instance.getHitBox().height && y <= instance.y && y >= instance.y-(instance.getHitBox().height/2)){
					y -= speed;
				}

				if(x >= instance.x && x <= instance.x+instance.getHitBox().height && y >= instance.y+instance.getHitBox().height && y <= instance.y+(instance.getHitBox().height+getHitBox().height/8)){
					y += speed;
				}



			}
		}


		if(inventory.getItems().size() > 0 && WorldScene.markerX/16 < inventory.getItems().size()){

			if(Game.vk_d){
				Item item = inventory.getItems().get(WorldScene.markerX/16);

				item.x = x;
				item.y = y;
				ItemBubble bubble = new ItemBubble(x,y,item);
				Game.getCurrentScene().instantiate(bubble);

				inventory.getItems().remove(WorldScene.markerX/16);
				Game.vk_d = false;

			}

			if(Game.vk_x){
				inventory.getItems().get(WorldScene.markerX/16).use();
				Game.vk_x = false;
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
