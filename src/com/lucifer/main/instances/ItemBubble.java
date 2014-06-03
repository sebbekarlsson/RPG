package com.lucifer.main.instances;

import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Graphics2D;

import com.lucifer.main.Game;
import com.lucifer.main.Instance;
import com.lucifer.main.Item;
import com.lucifer.main.scenes.WorldScene;

public class ItemBubble extends Instance {

	public Item item;
	boolean up = true;
	int popTime = 100;

	int increment = 1;
	int yatstart;


	boolean created = false;


	public ItemBubble(int x, int y,Item item) {
		super(x, y);
		this.setSprite("images/bubble.png");
		yatstart = y;
		this.item = item;
	}

	public void tick(){
		
		
		if(popTime >0){
			popTime -= 1;
		}else{
			pop();
		}

		if(created == false){
			yatstart = y;
			created = true;
		}


		if (up == true && y <= yatstart+8)
		{
			y += 1;

			if (y == yatstart+8)
			{up = false;}
		}
		else
		{
			up = false;
			y -= 1;

			if (y == yatstart)
			{up = true;}
		}


		Player player = WorldScene.player;
		if(player.x+(player.getHitBox().width/2) >= x && player.x+(player.getHitBox().width/2) <= x+hitbox.width && player.y+(player.getHitBox().height/2) >= y && player.y+(player.getHitBox().height/2) <= y+hitbox.height ){
			if(Game.vk_enter){
				
				if(!WorldScene.player.getInventory().isFull()){
					WorldScene.player.getInventory().add(item);
					Game.getCurrentScene().destroy(this);
				}
			}
		}
		

	}

	public void draw(Graphics g){
		Graphics2D g2 = (Graphics2D) g;

		if(item.sprite != null){
			if(item.sprite.getHeight(null) < 16 || item.sprite.getHeight(null) > 16 || item.sprite.getWidth(null) < 16 || item.sprite.getWidth(null) > 16 ){
				g2.drawImage(item.sprite.getScaledInstance(16, 16, 0), x, y, null);
			}else{
				g2.drawImage(item.sprite, x, y, null);
			}

		}
		

		
		g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float) 0.5));
		drawDefaultSprite(g2);
		g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float) 1));
	}
	

	public void setItem(Item item){
		this.item = item;
	}
	
	public void pop(){
		item.x = x;
		item.y = y;
		Game.getCurrentScene().instantiate(item);
		Game.getCurrentScene().destroy(this);
	}

}
