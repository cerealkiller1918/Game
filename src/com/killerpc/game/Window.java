package com.killerpc.game;

import java.awt.Toolkit;
import javax.swing.JFrame;

/**
 *
 * @author Justin Frasier
 */

public class Window extends JFrame {

	private static final long serialVersionUID = 1L;

	public void loadWindow() {

		Game game = new Game();
		this.add(game);
		this.setUndecorated(true);
		this.setAlwaysOnTop(true);
		this.setResizable(false);
		this.pack();
		this.setVisible(true);
		game.setJFrame(this);
		Toolkit tk = Toolkit.getDefaultToolkit();
		this.setSize((int) tk.getScreenSize().getWidth(), (int) tk.getScreenSize().getHeight());
		game.start();

	}

}
