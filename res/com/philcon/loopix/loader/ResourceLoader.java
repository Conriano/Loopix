package com.philcon.loopix.loader;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ResourceLoader {
	static ResourceLoader rl = new ResourceLoader();
	
	/**
	 * Speichert ein Bild im "images"-Ordner als BufferedImage
	 * @param fileName ist der Name der Datei
	 * @return ist das Bild als BufferedImage
	 */
	public static BufferedImage getImage(String fileName) {
		BufferedImage img = null;
		try {
			img = ImageIO.read(ResourceLoader.class.getResource("/images/"+ fileName));
		} catch (IOException e) {
			System.err.println("ResourceLoader: File not found!");
		}
		return img;
	}
}
