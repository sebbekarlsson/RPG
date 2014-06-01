package com.lucifer.main.scenes;

import com.lucifer.main.Game;
import com.lucifer.main.MathBrain;
import com.lucifer.main.Scene;
import com.lucifer.main.instances.Flower;
import com.lucifer.main.instances.Player;
import com.lucifer.main.instances.Tree;
import com.lucifer.main.instances.tiles.GrassTile;

public class WorldScene extends Scene {
	Player player = new Player(120,120);
	public WorldScene(int WIDTH, int HEIGHT) {
		super(WIDTH, HEIGHT);
		
		
		
		for(int i = 0; i < WIDTH/32; i++){
			for(int ii = 0; ii < HEIGHT+32/32; ii++){
				this.instantiate(new GrassTile(i*32,ii*32));
				
			}
		}
		
		
		for(int i = 0; i < WIDTH/32; i++){
			for(int ii = 0; ii < HEIGHT+32/32; ii++){
				
				if(MathBrain.random.nextInt(100)==0){
					this.instantiate(new Tree(i*32,ii*32));
				}
				
				if(MathBrain.random.nextInt(7)==0){
					this.instantiate(new Flower(i*32,ii*32));
				}
			}
		}
		
		this.instantiate(player);
		
		
	}
	
	
	public void tick(){
		camera.x = -player.x+Game.RENDERSIZE.width/2-16;
		camera.y = -player.y+Game.RENDERSIZE.height/2-16;
	}

}
