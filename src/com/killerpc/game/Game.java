package com.killerpc.game;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;
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
	private Random r = new Random();
	private ArrayList<Ball> BallList = new ArrayList<>();
	private RandomColor rc = new RandomColor();
	private ChangeColor changeColor = new ChangeColor();
	private ExitGame exitgame = new ExitGame();
	private JFrame jf;
	private String Frames = "";
	private String Ticks = "";
	private String ballCount = "";
	private Count count = new Count();

	public void setJFrame(JFrame jf) {
		this.jf = jf;
	}

	public void setRunning(boolean running) {
		this.running = running;
	}

	public synchronized void start() {
		if (running)
			return;
		int numBall = r.nextInt(25);
		while (numBall < 8) {
			numBall = r.nextInt(25);
		}
		for (int i = 0; i < numBall; i++) {
			BallList.add(new Ball());
		}
		for (int i=0; i<BallList.size(); i++){
			BallList.get(i).init();
		}
		for (int i = 0; i < BallList.size(); i++) {
			BallList.get(i).setObjectColor(rc.getColor());
		}
		changeColor.setBallList(BallList);
		addKeyListener(changeColor);
		exitgame.setGame(this);
		addKeyListener(exitgame);
		running = true;
		thread = new Thread(this);
		thread.start();

	}

	public synchronized void stop() {
		if (running)
			return;
		jf.setVisible(false);
		jf.dispose();
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

		for (int i = 0; i < BallList.size(); i++) {
			BallList.get(i).tick();
		}
		ballCount = Integer.toString(BallList.size());
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

		for (int i = 0; i < BallList.size(); i++) {
			BallList.get(i).render(g);
		}

		count.paint(g, Frames, Ticks, ballCount);
		//////////////////////////////////
		g.dispose();
		bs.show();
	}

}
