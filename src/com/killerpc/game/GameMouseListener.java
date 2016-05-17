package com.killerpc.game;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

/**
 *
 * @author Justin Frasier
 */

public class GameMouseListener implements MouseMotionListener, MouseListener, MouseWheelListener {

	Game game;
	Player player;

	public GameMouseListener(Game game, Player player) {
		this.game = game;
		this.player = player;
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON3) {
			player.setObjectMoveUp(true);
		}

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		player.setObjectMoveUp(false);

	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(MouseEvent e) {

		player.setObject_x(e.getX());

	}

}
