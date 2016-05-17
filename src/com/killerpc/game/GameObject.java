package com.killerpc.game;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 *
 * @author Justin Frasier
 */

public abstract class GameObject {

	// abstract methods
	public abstract void init();

	public abstract void tick();

	public abstract void render(Graphics g);

	// Variable
	private Toolkit toolkit = Toolkit.getDefaultToolkit();
	private Random random = new Random();
	private int screenSize_X = toolkit.getScreenSize().width;
	private int screenSize_Y = toolkit.getScreenSize().height;
	private boolean moveRight, moveUp;
	private int object_x, object_y, moveSpeed, objectSize;

	// Public Methods
	public void setObject_x(int object_x) { // Sets the X point
		this.object_x = object_x;
	}

	public void setObject_y(int object_y) { // Sets the Y point
		this.object_y = object_y;
	}

	public int getObject_x() { // Sends the X point
		return this.object_x;
	}

	public int getObject_y() { // Sends the Y point
		return this.object_y;
	}

	public void setObjectSize(int objectSize) { // Set the size of the object
		this.objectSize = objectSize;
	}

	public int getObjectSize() { // Gets the size of the object
		return this.objectSize;
	}

	public void setObjectMoveRight(boolean moveRight) {
		this.moveRight = moveRight;
	}

	public boolean getObjectMoveRight() {
		return this.moveRight;
	}

	public void setObjectMoveUp(boolean moveUp) {
		this.moveUp = moveUp;
	}

	public boolean getObjectMoveUp() {
		return this.moveUp;
	}

	public void setObjectMoveSpeed(int moveSpeed) {
		this.moveSpeed = moveSpeed;
	}

	public int getObjectMoveSpeed() {
		return this.moveSpeed;
	}

	public int getScreenSize_Y() {
		return screenSize_Y;
	}

	public int getScreenSize_X() {
		return screenSize_X;
	}

	public int getRandom(int i) {
		return random.nextInt(i);
	}

	public double getRandom(double i) {
		return random.nextDouble();
	}

	public float getRandom(float i) {
		return random.nextFloat();
	}

	public long getRandom(long i) {
		return random.nextLong();
	}

	public static BufferedImage ImageResize(BufferedImage img, int newW, int newH) {
		Image tmp = img.getScaledInstance(newW, newH, Image.SCALE_SMOOTH);
		BufferedImage dimg = new BufferedImage(newW, newH, BufferedImage.TYPE_INT_ARGB);

		Graphics2D g2d = dimg.createGraphics();
		g2d.drawImage(tmp, 0, 0, null);
		g2d.dispose();

		return dimg;
	}

	public static BufferedImage RotateImage(BufferedImage img, double angle) {

		AffineTransform tx = new AffineTransform();

		tx.rotate(angle, img.getWidth() / 2, img.getHeight() / 2);

		AffineTransformOp op = new AffineTransformOp(tx, AffineTransform.TYPE_GENERAL_ROTATION);

		return op.filter(img, null);
	}
}
