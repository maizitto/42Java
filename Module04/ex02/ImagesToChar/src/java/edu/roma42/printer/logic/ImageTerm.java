package edu.roma42.printer.logic;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import com.diogonunes.jcolor.Attribute;
import com.diogonunes.jcolor.Ansi;

import javax.imageio.ImageIO;
import java.awt.Color;

public class ImageTerm {

	private final String white;
	private final String black;
	private final String imagePath;

	public ImageTerm(String white, String black, String imagePath) {
		this.white = white;
		this.black = black;
		this.imagePath = imagePath;
	}

	public void convert() throws IOException {

		File file = new File(this.imagePath);
		BufferedImage image = ImageIO.read(file);
		int w = image.getWidth();
		int h = image.getHeight();
		char[][] mat = new char[h][w];

		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				int color = image.getRGB(j, i);
				if (color == Color.BLACK.getRGB()) {
					mat[i][j] = this.black.charAt(0);
				} else {
					mat[i][j] = this.white.charAt(0);
				}
			}
		}
		printImage(mat, this.white, this.black);
	}

	public void printImage(char[][] matrix, String white, String black) {
		Attribute bkgColor;
		CustomColor c1, c2;
		c1 = new CustomColor(white);
		c2 = new CustomColor(black);

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] == white.charAt(0)) {
					bkgColor = Attribute.BACK_COLOR(c1.getRed(), c1.getGreen(), c1.getBlue());
				} else {
					bkgColor = Attribute.BACK_COLOR(c2.getRed(), c2.getGreen(), c2.getBlue());
				}
				System.out.print(Ansi.colorize(" ", bkgColor));
			}
			System.out.println();
		}
	}

	@Override
	public String toString() {
		return "ImageTerm{" +
				"white='" + white + '\'' +
				", black='" + black + '\'' +
				", imagePath='" + imagePath + '\'' +
				'}';
	}
}
