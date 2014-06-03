package com.lucifer.main.instances;

import com.lucifer.main.Food;

public class Cookie extends Food {

	public Cookie(int x, int y) {
		super(x, y);
		this.setSprite("images/food/cookie.png");
		this.setDisplayName("Cookie");
		this.setHeal(5);
	}

}
