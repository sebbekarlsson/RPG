package com.lucifer.main;

import java.util.ArrayList;
import java.util.List;

public class Inventory {

	List<Instance> instances = new ArrayList<Instance>();
	public int slots = 12;

	public void add(Instance instance){
		//if(instances.size() < slots){
			instances.add(instance);
		//}
	}

	public List<Instance> getInstances(){
		return this.instances;
	}

}
