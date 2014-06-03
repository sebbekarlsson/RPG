package com.lucifer.main;

import java.util.ArrayList;
import java.util.List;

public class Inventory {

	List<Item> items = new ArrayList<Item>();
	public int slots = 12;

	public Inventory(int slots){
		this.slots = slots;
	}

	public void add(Item item){
		//if(instances.size() < slots){

		if(!isFull()){
			items.add(item);
		}
		//}
	}

	public List<Item> getItems(){
		return this.items;
	}

	public boolean isFull(){
		return items.size() >= slots;
	}


}
