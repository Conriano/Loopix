package com.philcon.loopix.utils;

import java.awt.image.BufferedImage;

public class GetPixel {

	/**
	 * transformiert ein zeilenweise eingelesenes Bild in ein pixel-Array mit entsprechenden RGB-Werten
	 * @param img ist das Bild
	 * @param width ist die Breite des Bildes
	 * @param height ist die Hoehe des Bildes
	 * @return ist das pixel-Array
	 */
	public static int[] getPixelArray(BufferedImage img, int width, int height) {
			
		int[] pixels = new int[width * height];
		int z = 0;
		
		for(int y = 0; y < height; y++) {
			for(int x = 0; x < width; x++) {
				pixels[z] = img.getRGB(x, y);
				z++;
			}
		}
		
		return pixels;
	}
}
