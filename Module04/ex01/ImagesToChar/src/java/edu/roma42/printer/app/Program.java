package edu.roma42.printer.app;
import edu.roma42.printer.logic.ImageTerm;

import java.io.IOException;

public class Program {

	public static void printImage(char[][] image) {
		for (char[] row : image) {
			for (char pixel : row) {
				System.out.print(pixel);
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		if (args.length != 2 || args[0].length() != 1 || args[1].length() != 1) {
            System.out.println("Usage: java Program <whiteChar> <blackChar>");
            System.exit(1);
        }

		char W = args[0].charAt(0);
        char B = args[1].charAt(0); 
		String path = "target/resources/image.bmp";

		try {
			
			ImageTerm img = new ImageTerm(W, B, path);
			char[][] image = img.convert();
			printImage(image);

		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}

	}
}