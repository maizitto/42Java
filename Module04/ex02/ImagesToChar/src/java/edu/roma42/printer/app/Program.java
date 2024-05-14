package edu.roma42.printer.app;

import edu.roma42.printer.logic.CustomColor;
import edu.roma42.printer.logic.ImageTerm;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.Color;
import com.diogonunes.jcolor.Attribute;
import com.diogonunes.jcolor.Ansi;
import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;

public class Program {

	@Parameters(separators = "=")
	public static class CommandLineArgs {
		@Parameter(names = { "--white" }, description = "White color code")
		public String white;
		@Parameter(names = { "--black" }, description = "Black color code")
		public String black;
	}

	public static void main(String[] args) {
		CommandLineArgs cmdArgs = new CommandLineArgs();
		JCommander.newBuilder()
				.addObject(cmdArgs)
				.build()
				.parse(args);

		String white = cmdArgs.white != null ? cmdArgs.white : "W";
		String black = cmdArgs.black != null ? cmdArgs.black : "B";
		String imagePath = "target/resources/image.bmp";

		File imageFile = new File(imagePath);
		if (!imageFile.exists()) {
			System.out.println(Ansi.colorize("Image file not found", Attribute.RED_TEXT()));
			return;
		}

		ImageTerm imageTerm = new ImageTerm(white, black, imagePath);
		try {
			imageTerm.convert();
		} catch (IOException e) {
			System.out.println(Ansi.colorize("Error reading image file", Attribute.RED_TEXT()));
			return;
		}
	}
}