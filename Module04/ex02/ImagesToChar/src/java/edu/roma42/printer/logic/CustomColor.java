package edu.roma42.printer.logic;

import javax.swing.text.html.StyleSheet;
import java.awt.Color;

public class CustomColor {

	Color color;
	int r;
	int g;
	int b;

	public CustomColor(String col) {
		this.color = new StyleSheet().stringToColor(col);
		r = color.getRed();
		g = color.getGreen();
		b = color.getBlue();
	}

	public int getBlue() {
		return b;
	}

	public int getGreen() {
		return g;
	}

	public int getRed() {
		return r;
	}
}