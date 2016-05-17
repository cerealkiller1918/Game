package com.killerpc.game;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Justin Frasier
 */

public class Count {

	public void paint(Graphics g, String frames, String ticks , String BulletLeft, int Screen_x, int Screen_y) {
		g.setColor(Color.YELLOW);
		g.drawString("FPS: " + frames + " TICKS: " + ticks, 40, 40);
		g.drawString("Bullets "+ BulletLeft, Screen_x-80, Screen_y -80);
	}
}
