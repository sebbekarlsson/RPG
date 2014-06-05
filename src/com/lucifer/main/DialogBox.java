package com.lucifer.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import com.lucifer.main.scenes.WorldScene;

public class DialogBox extends GUIObject {

	
	public int messageIndex = 1;
	private List<String> messages = new ArrayList<String>();
	
	public DialogBox() {
		
		
		
	}

	
	public void tick(){
		WorldScene.player.canWalk = false;
		if(Game.vk_enter){
			if(messageIndex < messages.size()-1){
				 messageIndex += 1;
			}else{
				WorldScene.player.canWalk = true;
				Game.getCurrentScene().destroyGUIObject(this);
			}
			
		Game.vk_enter = false;
			
			
		}
	}
	
	public void draw(Graphics g){
		System.out.println("ticked");
		g.setColor(Color.WHITE);
		g.setFont(new Font(Font.SERIF,16,16));
		g.drawString(messages.get(messageIndex), 16, Game.RENDERSIZE.height-64);
		
	}
	
	public void addMessage(String message){
		this.messages.add(message);
	}
	
}
