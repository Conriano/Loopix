package com.philcon.loopix;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageData {
	int width;
	int height;
	BufferedImage image;
	boolean debug = true;

	/**
	 * ImageData-Objekte für den Fall, dass mehrere Bilder gelesen werden sollen.
	 */
	public ImageData(String path) throws IOException {
		image = ImageIO.read(new File(path));
		width = image.getWidth();
		height = image.getHeight();
	}

	/**
	 * String-Array wird mit RGB-Werten jedes Pixels im Bild befüllt.
	 */
	public String[] getStringArray() {
		String[] imageAsStringArray = new String[width * height];
		int arrayCounter = 0;

		for (int row = 0; row < width; row++) {
			for (int column = 0; column < height; column++) {
				// imageAsStringArray[arrayCounter++] = convertRGBsToDecimal(row, column);
				imageAsStringArray[arrayCounter++] = Integer.toString(image.getRGB(row, column));
				if (debug)
					System.out.println(imageAsStringArray[arrayCounter - 1]);
			}
		}
		return imageAsStringArray;
	}

	// getRGB() gibt Werte mit anderer Basis an, ich habe es noch nicht verstanden.
	// Nutzt man aber die einzelnen
	// Methoden getRed(), getGreen(), getBlue() bekommt man längere Zahlen heraus
	// als gewünscht.

	// private String convertRGBsToDecimal(int row, int column) {
	// Color color = new Color(image.getRGB(row, column));
	// String rgbToDecimal = Integer.toString(color.getAlpha());
	// rgbToDecimal += Integer.toString(color.getRed());
	// rgbToDecimal += Integer.toString(color.getGreen());
	// rgbToDecimal += Integer.toString(color.getBlue());
	// return rgbToDecimal;
	// }

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

}
