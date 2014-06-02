package com.lucifer.main;

import java.util.Random;

public class MathBrain {

	public static Random random = new Random();
	
	public static int chooseInt(int...args){
		return args[random.nextInt(args.length)];
	}
}
