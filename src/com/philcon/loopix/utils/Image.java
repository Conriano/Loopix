package com.philcon.loopix.utils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Image {

	public static BufferedImage LoadImage(String path) {
		BufferedImage img = null;
		
		try {
			img = ImageIO.read(new File(path));
		} catch (IOException e) {
			System.out.println(e +"\nImage not found!!");
		}
		
		return img;
	}
	
}
