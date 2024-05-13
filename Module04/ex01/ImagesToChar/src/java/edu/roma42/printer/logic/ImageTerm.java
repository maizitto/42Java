package edu.roma42.printer.logic;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.Color;

public class ImageTerm {

	private final char white;
    private final char black;
    private final String imagePath;
 
     public ImageTerm(char whiteChar, char blackChar, String imagePath){
		this.white = whiteChar;
		this.black = blackChar;
		this.imagePath = imagePath;
     }

	 public char[][] convert() throws IOException{

		File file = new File(imagePath);
        BufferedImage image = ImageIO.read(file);
        int w = image.getWidth();
        int h = image.getHeight();
        char[][] mat = new char[h][w];

		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				int color = image.getRGB(j, i);
				if (color == Color.BLACK.getRGB()) {
					mat[i][j] = black;
				} else {
					mat[i][j] = white;
				}
			}
		}
		return mat;
	 }
}
