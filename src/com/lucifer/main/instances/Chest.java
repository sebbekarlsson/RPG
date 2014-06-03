package com.lucifer.main.instances;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import com.lucifer.main.Game;
import com.lucifer.main.Instance;
import com.lucifer.main.Inventory;
import com.lucifer.main.Item;
import com.lucifer.main.MathBrain;
import com.lucifer.main.scenes.WorldScene;

public class Chest extends Instance {

	boolean open = false;
	Inventory inventory = new Inventory(12);

	public Chest(int x, int y) {
		super(x, y);
		this.setSprite("images/chest/chest.png");
	}



	public void tick(){

		
		Player player = WorldScene.player;
		if(player.x+(player.getHitBox().width/2) >= x && player.x+(player.getHitBox().width/2) <= x+hitbox.width && player.y+(player.getHitBox().height/2) >= y && player.y+(player.getHitBox().height/2) <= y+hitbox.height ){
			if(Game.vk_enter){
				open();
				
			}
		}

	}

	public void draw(Graphics g){
		
		drawDefaultSprite(g);
		Player player = WorldScene.player;
		if(player.x+(player.getHitBox().width/2) >= x && player.x+(player.getHitBox().width/2) <= x+hitbox.width && player.y+(player.getHitBox().height/2) >= y && player.y+(player.getHitBox().height/2) <= y+hitbox.height ){
			if(open == false){
				
				g.setColor(Color.WHITE);
				g.setFont(new Font(Font.SERIF,12,12));
				g.drawString("[ENTER]"+" ("+this.getInventory().getItems().size()+")", x-4, y-16);
			}else{
				g.setColor(Color.WHITE);
				g.setFont(new Font(Font.SERIF,12,12));
				g.drawString("Opened", x-4, y-16);
			}
		}
	}

	public void open(){
		open = true;
		this.setSprite("images/chest/chest_open.png");
		for(int i = 0; i < inventory.getItems().size(); i++){
			Item item = inventory.getItems().get(i);
			ItemBubble bubble = new ItemBubble(x,y,item);
			
			
			bubble.x = x+MathBrain.chooseInt(MathBrain.random.nextInt(32),-MathBrain.random.nextInt(32));
			bubble.y = y+MathBrain.chooseInt(MathBrain.random.nextInt(32),-MathBrain.random.nextInt(32));
			
			
			Game.getCurrentScene().instantiate(bubble);
		}
		this.inventory.getItems().clear();
	}
	
	public Inventory getInventory(){
		return this.inventory;
	}

}
