package edu.roma42.printer.app;

import java.io.IOException;

import edu.roma42.printer.logic.ImageTerm;

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
		if (args.length != 3 || args[0].length() != 1 || args[1].length() != 1) {
            System.out.println("Usage: java Program <whiteChar> <blackChar> <PathToIMG>");
            System.exit(1);
        }

		char W = args[0].charAt(0);
        char B = args[1].charAt(0); 

		try {
			
			ImageTerm img = new ImageTerm(W, B, args[2]);
			char[][] image = img.convert();
			printImage(image);

		} catch (IOException e) {
			
		}

	}
}