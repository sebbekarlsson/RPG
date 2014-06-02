package com.lucifer.main.instances;

import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Graphics2D;

import com.lucifer.main.Instance;

public class ItemBubble extends Instance {

	public Instance item;
	boolean up = true;

	int increment = 1;
	int yatstart;


	boolean created = false;


	public ItemBubble(int x, int y) {
		super(x, y);
		this.setSprite("images/bubble.png");
		yatstart = y;
	}

	public void tick(){

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

	public void setItem(Instance item){
		this.item = item;
	}

}
