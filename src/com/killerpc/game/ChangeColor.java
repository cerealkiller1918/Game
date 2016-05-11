package com.killerpc.game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

/**
 *
 * @author Justin Frasier
 */

public class ChangeColor implements KeyListener {

	private RandomColor rc = new RandomColor();
	private ArrayList<Ball> ballList;

	public void setBallList(ArrayList<Ball> ballList) {
		this.ballList = ballList;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			for (int i = 0; i < ballList.size(); i++) {
				ballList.get(i).setColor(rc.getColor());
			}

		} else if (e.getKeyCode() == KeyEvent.VK_W) {
			int i = ballList.size();
			ballList.add(new Ball());
			ballList.get(i).setColor(rc.getColor());
		} else if (e.getKeyCode() == KeyEvent.VK_E) {
			if (!ballList.isEmpty()) {
				int i = ballList.size() - 1;
				ballList.remove(i);
			}
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

}
