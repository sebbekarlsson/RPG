package com.lucifer.main.instances;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import com.lucifer.main.Game;
import com.lucifer.main.Instance;
import com.lucifer.main.Inventory;
import com.lucifer.main.MathBrain;
import com.lucifer.main.scenes.WorldScene;

public class Chest extends Instance {

	boolean open = false;
	Inventory inventory = new Inventory();

	public Chest(int x, int y) {
		super(x, y);
		this.setSprite("images/chest/chest.png");
	}



	public void tick(){

		Instance instance = WorldScene.player;
		if(instance.x >= x && instance.x < x+sprite.getWidth(null) && instance.y > y && instance.y < y+sprite.getHeight(null)){
			if(Game.vk_enter){
				open();
				
				Game.vk_enter = false;

			}}

	}

	public void draw(Graphics g){
		
		drawDefaultSprite(g);
		Instance instance = WorldScene.player;
		if(instance.x >= x && instance.x < x+sprite.getWidth(null) && instance.y > y && instance.y < y+sprite.getHeight(null)){
			if(open == false){
				
				g.setColor(Color.WHITE);
				g.setFont(new Font(Font.SERIF,12,12));
				g.drawString("[ENTER]", x-4, y-16);
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
		for(int i = 0; i < inventory.getInstances().size(); i++){
			ItemBubble bubble = new ItemBubble(x,y);
			
			bubble.setItem(inventory.getInstances().get(i));
			bubble.x = x+MathBrain.chooseInt(MathBrain.random.nextInt(32),-MathBrain.random.nextInt(32));
			bubble.y = y+MathBrain.chooseInt(MathBrain.random.nextInt(32),-MathBrain.random.nextInt(32));
			
			Game.getCurrentScene().instantiate(bubble);
		}
		this.inventory.getInstances().clear();
	}
	
	public Inventory getInventory(){
		return this.inventory;
	}

}
