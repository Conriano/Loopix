package com.philcon.loopix.display;

import javax.swing.*;

import com.philcon.loopix.utils.GetPixel;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

/**
 * Screen-Klasse, zeichnet das Bild
 */
public class Screen extends JFrame{

	private int[] pixel;
	private int width;
	private int height;
	
	/**
	 * Erstellt anhand der Width und Height eines Bildes ein JFrame
	 * @param img ist das Bild
	 */
	public Screen(BufferedImage img) {	
		this.width = img.getWidth();
		this.height = img.getHeight();
		this.pixel = new int[width * height];
		
		initFrame();
		pixel = GetPixel.getPixelArray(img);
	}
	
	
	/**
	 * initialisiert das JFrame
	 */
	private void initFrame() {
		setSize(width, height);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Loopix");
        setResizable(false);
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
