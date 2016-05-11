package com.killerpc.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.util.Random;

/**
 *
 * @author Justin Frasier
 */

public class Ball {
	private Random r = new Random();
	private Toolkit tk = Toolkit.getDefaultToolkit();
	private int ballSize = 80;
	private int screenX;
	private int screenY;
	private int ballX = r.nextInt(tk.getScreenSize().width);
	private int ballY = r.nextInt(tk.getScreenSize().height);
	private boolean xright = this.r.nextBoolean();
	private boolean yup = this.r.nextBoolean();
	private int move = this.r.nextInt(4);
	private Color color;

	public void thinkBall(int screen_x, int screen_y) {
		this.screenX = screen_x;
		this.screenY = screen_y;
		if (this.move == 0) {
			this.move = this.r.nextInt(4);
		}
		if (this.ballX < this.screenX - 80 - this.move - 1 && this.xright) {
			this.ballX += this.move;
		} else {
			this.xright = false;
		}
		if (this.ballX > this.move - 1 && !this.xright) {
			this.ballX -= this.move;
		} else {
			this.xright = true;
		}
		if (this.ballY > this.move - 1 && !this.yup) {
			this.ballY -= this.move;
		} else {
			this.yup = true;
		}
		if (this.ballY < this.screenY - 80 - this.move - 1 && this.yup) {
			this.ballY += this.move;
		} else {
			this.yup = false;
		}
	}

	public void paintBall(Graphics g) {
		g.setColor(color);
		g.fillOval(this.ballX, this.ballY, this.ballSize, this.ballSize);
	}

	public void setColor(Color color) {
		this.color = color;
	}

}
