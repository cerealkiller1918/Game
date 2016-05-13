package com.killerpc.game;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.util.Random;

public abstract class GameObject {
	
	public abstract void init();
	public abstract void tick();
	public abstract void render(Graphics g);
	private Toolkit toolkit = Toolkit.getDefaultToolkit();
	public Random random = new Random();
	private int screenSize_X = toolkit.getScreenSize().width;
	private int screenSize_Y = toolkit.getScreenSize().height;
	private boolean moveRight, moveUp;
	private int object_x,object_y, moveSpeed, objectSize;
	
	public void setObject_x(int object_x){
		this.object_x = object_x;}
	public void setObject_y(int object_y){
		this.object_y = object_y;}
	public int getObject_x(){
		return this.object_x;}
	public int getObject_y(){
		return this.object_y;}
	public void setObjectSize(int objectSize){
		this.objectSize = objectSize;}
	public int getObjectSize(){
		return this.objectSize;}
	public void setObjectMoveRight(boolean moveRight){
		this.moveRight = moveRight;}
	public boolean getObjectMoveRight(){
		return this.moveRight;}
	public void setObjectMoveUp(boolean moveUp){
		this.moveUp = moveUp;}
	public boolean getObjectMoveUp(){
		return this.moveUp;}
	public void setObjectMoveSpeed(int moveSpeed){
		this.moveSpeed = moveSpeed;}
	public int getObjectMoveSpeed(){
		return this.moveSpeed;}
	public int getScreenSize_Y(){
		return screenSize_Y;}
	public int getScreenSize_X(){
		return screenSize_X;}
	public static BufferedImage ImageResize(BufferedImage img, int newW, int newH) { 
	    Image tmp = img.getScaledInstance(newW, newH, Image.SCALE_SMOOTH);
	    BufferedImage dimg = new BufferedImage(newW, newH, BufferedImage.TYPE_INT_ARGB);

	    Graphics2D g2d = dimg.createGraphics();
	    g2d.drawImage(tmp, 0, 0, null);
	    g2d.dispose();

	    return dimg;
	} 
	
	public static BufferedImage RotateImage(BufferedImage img, double angle){
		
		AffineTransform tx = new AffineTransform();
		
		tx.rotate(angle, img.getWidth()/2, img.getHeight()/2);
		
		AffineTransformOp op = new AffineTransformOp(tx, AffineTransform.TYPE_GENERAL_ROTATION);
		
		
		return op.filter(img, null);
	}
}
