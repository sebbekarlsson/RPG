package com.lucifer.main.instances;

import com.lucifer.main.Food;

public class Fish extends Food {

	public Fish(int x, int y) {
		super(x, y);
		this.setSprite("images/food/fish.png");
		this.setDisplayName("Fish");
		this.setHeal(10);
	}

}
