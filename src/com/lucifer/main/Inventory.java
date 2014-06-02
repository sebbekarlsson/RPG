package com.lucifer.main;

import java.util.ArrayList;
import java.util.List;

public class Inventory {

	List<Instance> instances = new ArrayList<Instance>();
	public int slots = 12;

	public Inventory(int slots){
		this.slots = slots;
	}

	public void add(Instance instance){
		//if(instances.size() < slots){

		if(!isFull()){
			instances.add(instance);
		}
		//}
	}

	public List<Instance> getInstances(){
		return this.instances;
	}

	public boolean isFull(){
		return instances.size() >= slots;
	}


}
