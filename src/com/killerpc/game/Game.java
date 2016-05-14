package com.killerpc.game;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;

/**
 *
 * @author Justin Frasier
 */

public class Game extends Canvas implements Runnable {

	private static final long serialVersionUID = 1L;
	public static final int WIDTH = 600;
	public static final int HEIGHT = WIDTH / 12 * 9;
	public static final int SCALE = 2;
	private boolean running = false;
	private Thread thread;
	private BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
	private GameKeyListener GKL;
	private GameMouseListener GML;
	private JFrame jf;
	private String Frames = "";
	private String Ticks = "";
	private Count count = new Count();
	private Player player = new Player();
	private Bullet bullet = new Bullet();

	public void setJFrame(JFrame jf) {
		this.jf = jf;
	}

	public void setRunning(boolean running) {
		this.running = running;
	}

	public synchronized void start() {
		if (running)
			return;
		GML = new GameMouseListener(this, player);
		GKL = new GameKeyListener(this, player);
		player.init();
		bullet.init();
		addMouseMotionListener(GML);
		addMouseListener(GML);
		addMouseWheelListener(GML);
		addKeyListener(GKL);
		running = true;
		System.out.println("Started Game");
		thread = new Thread(this);
		thread.start();

	}

	public synchronized void stop() {
		if (running)
			return;
		jf.setVisible(false);
		jf.dispose();
		System.out.println("Ended Game");
		running = false;
		thread.interrupt();
		System.exit(1);
	}

	@Override
	public void run() {
		long lastTime = System.nanoTime();
		final double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		int updates = 0;
		int frames = 0;
		long timer = System.currentTimeMillis();

		while (running) {
			// Game Loop
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			if (delta >= 1) {
				tick();
				updates++;
				delta--;
			}
			render();
			frames++;

			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				Frames = Integer.toString(frames);
				Ticks = Integer.toString(updates);
				System.out.println("Ticks " + updates + "|FPS " + frames);
				updates = 0;
				frames = 0;
			}

		}
		stop();
	}

	private void tick() {
		player.tick();
		bullet.tick();
	}

	private void render() {

		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(3);
			return;
		}

		Graphics g = bs.getDrawGraphics();
		//////////////////////////////////

		g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
		
		bullet.render(g);
		player.render(g);
		

		count.paint(g, Frames, Ticks);
		//////////////////////////////////
		g.dispose();
		bs.show();
	}

}
