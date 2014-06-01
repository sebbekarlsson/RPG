package com.lucifer.main;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

public class Game extends JFrame implements Runnable, KeyListener, MouseListener {

	private static int WIDTH = 640;
	private static int HEIGHT = WIDTH / 16 * 9;
	private static int SCALE = 2;

	public static Dimension FRAMESIZE = new Dimension(WIDTH * SCALE, HEIGHT * SCALE);
	public static Dimension RENDERSIZE = new Dimension(FRAMESIZE.width / 2, FRAMESIZE.height / 2);

	private static BufferedImage offscreen = new BufferedImage(RENDERSIZE.width, RENDERSIZE.width, BufferedImage.TYPE_INT_RGB);

	private Thread gameLoop = new Thread(this,"Game Loop");

	public static List<Scene> scenes = new ArrayList<Scene>();
	public static int sceneIndex = 0;


	public Game(){
		this.setSize(FRAMESIZE);
		this.setVisible(true);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setTitle("RPG");
	}

	public static void main(String[] args){
		Game game = new Game();
		game.start();
	}

	public void start(){
		gameLoop.start();
	}

	public void run() {
		while(true){



			try {
				Thread.sleep(1000/60);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void paint(Graphics g){
		Graphics g2 = offscreen.getGraphics();
		g2.clearRect(0, 0, RENDERSIZE.width, RENDERSIZE.height);

		
		
		if(scenes.size() > 0){
			for(int i = 0; i < getCurrentScene().getInstances().size(); i++){
				Instance instance = getCurrentScene().getInstances().get(i);

				instance.tick();
				instance.draw(g2);
			}

			getCurrentScene().tick();
			getCurrentScene().draw(g2);
		}
		g.drawImage(offscreen.getScaledInstance(FRAMESIZE.width, FRAMESIZE.height, 1), 0, 0, this);
	}


	public void mouseClicked(MouseEvent e) {


	}


	public void mousePressed(MouseEvent e) {


	}


	public void mouseReleased(MouseEvent e) {


	}


	public void mouseEntered(MouseEvent e) {


	}


	public void mouseExited(MouseEvent e) {


	}


	public void keyTyped(KeyEvent e) {


	}


	public void keyPressed(KeyEvent e) {


	}


	public void keyReleased(KeyEvent e) {


	}

	public static Scene getCurrentScene(){
		return scenes.get(sceneIndex);
	}





}
