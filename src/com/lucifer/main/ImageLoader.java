package com.lucifer.main;

import java.awt.Image;
import java.awt.Toolkit;

public class ImageLoader {
	
	public static Image load(String path){
		return Toolkit.getDefaultToolkit().getImage(path);
	}

}
