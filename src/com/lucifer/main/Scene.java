package com.lucifer.main;

import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class Scene {
	

	protected int WIDTH, HEIGHT;
	
	private static List<Instance> instances = new ArrayList<Instance>();
	private static List<GUIObject> guiobjects = new ArrayList<GUIObject>();
	
	
	protected Camera camera = new Camera();
	
	public Scene(int WIDTH, int HEIGHT){
		this.WIDTH = WIDTH;
		this.HEIGHT = HEIGHT;
	}
	
	public void tick(){}
	public void drawGUI(Graphics g){}
	
	public List<Instance> getInstances(){
		return instances;
	}
	
	public List<GUIObject> getGUIObjects(){
		return guiobjects;
	}
	
	public void instantiateGUIObject(GUIObject object){
		guiobjects.add(object);
	}
	
	public void destroyGUIObject(GUIObject object){
		guiobjects.remove(object);
	}
	
	public void instantiate(Instance instance){
		instances.add(instance);
	}
	
	public void destroy(Instance instance){
		instances.remove(instance);
	}
	
	public Dimension getSceneSize(){
		return new Dimension(WIDTH,HEIGHT);
	}

}
