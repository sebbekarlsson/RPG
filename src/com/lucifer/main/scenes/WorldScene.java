package com.lucifer.main.scenes;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import com.lucifer.main.Game;
import com.lucifer.main.ImageLoader;
import com.lucifer.main.Instance;
import com.lucifer.main.MathBrain;
import com.lucifer.main.Scene;
import com.lucifer.main.instances.Bottle;
import com.lucifer.main.instances.Chest;
import com.lucifer.main.instances.Flower;
import com.lucifer.main.instances.Mushroom;
import com.lucifer.main.instances.Player;
import com.lucifer.main.instances.Tree;
import com.lucifer.main.instances.tiles.GrassTile;

public class WorldScene extends Scene {
	public static Player player = new Player(120,120);
	public static int markerX = 1;
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

				
				Instance[] chestItems = new Instance[]{
						new Bottle(0,0,0),
						new Bottle(0,0,1),
						new Bottle(0,0,2),
						new Bottle(0,0,3),
						new Flower(0,0),
						new Mushroom(0,0)
				};
				
				Chest chest = new Chest(i*32,ii*32);

				
				for(int it = 0; it < MathBrain.random.nextInt(20)+1; it++){
				chest.getInventory().add(chestItems[MathBrain.random.nextInt(chestItems.length)]);

				}




				if(MathBrain.random.nextInt(50)==0){
					this.instantiate(chest);
				}
			}
		}

		player.getInventory().add(new Bottle(0,0,0));
		player.getInventory().add(new Mushroom(0,0));

		this.instantiate(player);


	}


	public void tick(){
		camera.x = -player.x+Game.RENDERSIZE.width/2-16;
		camera.y = -player.y+Game.RENDERSIZE.height/2-16;

		if(Game.vk_q){

			if(markerX > 1){
				markerX -= 16;
			}

			Game.vk_q = false;
		}

		if(Game.vk_e){
			if(markerX < 16*7){
				markerX += 16;
			}

			Game.vk_e = false;
		}
	}

	public void drawGUI(Graphics g){
		for(int i = 0; i < 8; i++){
			g.drawImage(ImageLoader.load("images/inventory/slot.png"), 1+16*i, Game.RENDERSIZE.height-17, null);

		}
		
		for(int i = 0; i < player.health/10; i++){
			g.drawImage(ImageLoader.load("images/heart.png"), 2+17*i, 9, null);
		}
		if(player.getInventory().getInstances().size() > 0){
			for(int i = 0; i < player.getInventory().getInstances().size(); i++){

				g.drawImage(player.getInventory().getInstances().get(i).sprite, 1+16*i, Game.RENDERSIZE.height-17, null);
				g.setColor(Color.WHITE);
				g.setFont(new Font(Font.SERIF,12,12));

			}


			if(markerX <= player.getInventory().getInstances().size()*16){
				g.drawString(player.getInventory().getInstances().get(markerX/16).getDisplayName(), 8, Game.RENDERSIZE.height-32);
			}

		}
		g.setColor(Color.BLUE);
		g.drawRect(markerX, Game.RENDERSIZE.height-17, 16, 16);
		g.drawImage(ImageLoader.load("images/inventory/marker.png"), markerX, Game.RENDERSIZE.height-17, null);


	}

}
