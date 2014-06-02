package com.lucifer.main.instances;

import com.lucifer.main.Game;
import com.lucifer.main.Instance;

public class Player extends Instance {

	int speed = 2;
	boolean collides = false;

	public Player(int x, int y) {
		super(x, y);
		this.setSprite("images/player/player_down.png");
	}



	public void tick(){

		for(int i = 0; i < Game.getCurrentScene().getInstances().size(); i++){
			Instance instance = Game.getCurrentScene().getInstances().get(i);
			if(instance instanceof Obstacle){



				
				

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

}
