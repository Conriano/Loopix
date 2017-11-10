package com.philcon.loopix;

import java.awt.image.BufferedImage;

import com.philcon.loopix.display.Screen;
import com.philcon.loopix.loader.ResourceLoader;
import com.philcon.loopix.utils.GetPixel;


/**
 * Loopix - Loop your picture!
 * @author Philpsc / Conriano
 * @version 0.1
 */
public class Launcher {

	/**
	 * Startet das Programm indem zuerst ein Bild eingelesen wird.
	 * Anschliessend wird auf dem Screen das Bild gelooped
	 * @param args 
	 */
	public static void main(String[] args) {
		BufferedImage img = ResourceLoader.getImage("test2.png");
		Screen screen = new Screen(img);
	}

}
