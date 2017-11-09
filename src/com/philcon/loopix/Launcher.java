package com.philcon.loopix;

/**
 * Loopix - Loop your picture!
 * 
 * @author Philpsc / Conriano
 * @version 0.1
 */
public class Launcher {

	public static void main(String[] args) {
		try {
			new ImageData(args[0]).getStringArray();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
