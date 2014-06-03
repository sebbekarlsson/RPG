package com.lucifer.main.instances;

import com.lucifer.main.Game;
import com.lucifer.main.Item;

public class Stone extends Item {

	public Stone(int x, int y) {
		super(x, y);
		this.setSprite("images/stone_small.png");
		this.setDisplayName("Stone");
	}
	
	public void tick(){
		checkForPickups();
		
		//make the stone throwable.
	}

}
