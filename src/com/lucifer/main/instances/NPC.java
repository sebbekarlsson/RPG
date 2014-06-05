package com.lucifer.main.instances;

import java.awt.Point;

import com.lucifer.main.DialogBox;
import com.lucifer.main.Game;
import com.lucifer.main.Instance;
import com.lucifer.main.MathBrain;

public class NPC extends Instance {
	
	
	boolean wander = false;
	Point goal = new Point(0,0);
	int speed = 1;
	public String upSprite;
	public String downSprite;
	public String leftSprite;
	public String rightSprite;
	
	boolean created = false;
	

	public NPC(int x, int y) {
		super(x, y);
		
	}
	
	public void talk(String...args){
		DialogBox dialog = new DialogBox();
		for(int i = 0; i < args.length; i++){
			dialog.addMessage(args[i]);
		}
		Game.getCurrentScene().instantiateGUIObject(dialog);
		
	}
	
	
	
	public void tick(){
		
		if(created == false){
			goal.setLocation(MathBrain.random.nextInt((Game.getCurrentScene().getSceneSize().width)), MathBrain.random.nextInt(Game.getCurrentScene().getSceneSize().height));
			
			created = true;
		}
		if(wander){
			if( x < goal.x){
				x += speed;
				setSprite(rightSprite);
			}
			
			if(x > goal.x){
				x -= speed;
				setSprite(leftSprite);
			}
			
			if(y < goal.y){
				y += speed;
				setSprite(downSprite);
			}
			
			if(y > goal.y){
				y -= speed;
				setSprite(upSprite);
			}
			
			if(MathBrain.random.nextInt(200) == 0){
				goal.setLocation(MathBrain.random.nextInt((Game.getCurrentScene().getSceneSize().width)), MathBrain.random.nextInt(Game.getCurrentScene().getSceneSize().height));

			}
		}
	}
	
	
	public void wander(){
		this.wander = true;
	}
	
	public void stopWander(){
		this.wander = false;
	}

}
