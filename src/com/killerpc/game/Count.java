package com.killerpc.game;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Justin Frasier
 */

public class Count {

	public void paint(Graphics g, String frames, String ticks, String ball) {
		g.setColor(Color.YELLOW);
		g.drawString("FPS: " + frames + " TICKS: " + ticks + " Ball: " + ball, 40, 40);
	}
}
