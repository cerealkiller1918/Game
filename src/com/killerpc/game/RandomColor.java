package com.killerpc.game;

import java.awt.Color;
import java.util.Random;

/**
 *
 * @author Justin Frasier
 */

public class RandomColor {

	private Random r = new Random();

	public Color getColor() {

		int key = r.nextInt(11);

		switch (key) {
		case 1:
			return Color.BLUE;
		case 2:
			return Color.CYAN;
		case 3:
			return Color.GRAY;
		case 4:
			return Color.GREEN;
		case 5:
			return Color.LIGHT_GRAY;
		case 6:
			return Color.MAGENTA;
		case 7:
			return Color.ORANGE;
		case 8:
			return Color.PINK;
		case 9:
			return Color.RED;
		case 10:
			return Color.WHITE;
		case 11:
			return Color.YELLOW;
		}
		return null;

	}
}
