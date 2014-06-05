package com.lucifer.main.instances;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;




public class Kiero extends NPC {

	public Kiero(int x, int y) {
		super(x, y);
		this.downSprite = "images/npc/kiero/kiero_down.png";
		this.upSprite = "images/npc/kiero/kiero_up.png";
		this.leftSprite = "images/npc/kiero/kiero_left.png";
		this.rightSprite = "images/npc/kiero/kiero_right.png";

		this.setSprite("images/npc/kiero/kiero_down.png");
		this.setDisplayName("Kiero");
		
		
		
	}
	
	public void draw(Graphics g){
		drawDefaultSprite(g);
		g.setColor(Color.WHITE);
		g.setFont(new Font(Font.SERIF,12,12));
		g.drawString(this.getDisplayName(), x, y-8);
		
	}

}
