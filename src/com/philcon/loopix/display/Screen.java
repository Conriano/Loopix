package com.philcon.loopix.display;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;

/**
 * Draw-Klasse, zeichnet das Bild
 */
public class Screen extends JFrame{

	private int[] pixel;
	private int width;
	private int height;
	
	/**
	 * Erstell anhand der Width und Height eines Bildes ein JFrame
	 * @param pixel ist ein int-Array der Groesse Width*Height
	 * @param width ist die Breite des Bildes
	 * @param height ist die Hoehe des Bildes
	 */
	public Screen(int[] pixel, int width, int height) {	
		setSize(width, height);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Loopix");
        setResizable(false);
        this.pixel = pixel;
        this.width = width;
        this.height = height;
        setVisible(true);
	}
	
	/**
	 * ist die von setVisible aufgerufene Zeichnen-Funktion
	 * @param g ist das implizite Grafik-Objekt, mit dem gezeichnet werden kann
	 */
	@Override
	public void paint(Graphics g) {
		
		createBufferStrategy(3);
		BufferStrategy bs = getBufferStrategy();
		g = bs.getDrawGraphics();
		
		do {
			int i = -1;
			
			for(int y = 0; y < height; y++) {
				for(int x = 0; x < width; x++) {
					i++;
					g.setColor(new Color(pixel[i]));
					g.fillRect(x, y, 1, 1);
				}
			}
			
			bs.show();
			
			int[] savedCol = new int[height];
			savedCol = saveLeftCol(savedCol);
			shiftPixelsToLeft();
			fillRightCol(savedCol);	
			
		}while(true);	
	}
	
	
	/**
	 * Speichert die rechte Pixel-Spalte des Hintergrundbildes
	 * @param firstCol ist die erste Spalte des Arrays
	 * @return the int[] ist das neue Array
	 */
	private int[] saveLeftCol(int[] firstCol){
		for(int i = 0; i < height; i++){
			firstCol[i] = pixel[i * width];
		}
		return firstCol;
	}
	
	/**
	 * Verschiebt alle Pixelspalten des Hintergrundbildes nach links
	 */
	private void shiftPixelsToLeft(){
		int m = 0;
		int n = 0;
		do{
			pixel[m] = pixel[m + 1];
			if(n != width - 2){
				m++;
				n++;
			}
			else{
				m = m + 2;
				n = 0;
			}
		}while(m < pixel.length - 1);		
	}
	
	
	/**
	 * Fuellt die rechte Pixelspalte des Hintergrundbildes
	 * @param firstCol die erste Spalte
	 */
	public void fillRightCol(int[] firstCol){
		int y = width - 1;
		int s = 0;
		do{
			pixel[y] = firstCol[s];
			y += width;
			s++;
		}while(y < pixel.length);
	}
	
	
	
}
