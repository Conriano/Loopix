package com.philcon.loopix;

import java.awt.image.BufferedImage;

import com.philcon.loopix.display.Screen;
import com.philcon.loopix.utils.GetPixel;
import com.philcon.loopix.utils.Image;

/**
 * Loopix - Loop your picture!
 * @author Philpsc / Conriano
 * @version 0.1
 */
public class Launcher {

	public static void main(String[] args) {
		BufferedImage img = Image.LoadImage("res/test2.png");
		int width = img.getWidth();
		int height = img.getHeight();
		int[] pixel = new int[width * height];
		
		pixel = GetPixel.getPixelArray(img);
		
		Screen screen = new Screen(pixel, width, height);
	}

}
