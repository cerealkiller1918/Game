package com.killerpc.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.util.Random;

public abstract class GameObject {
	
	public abstract void init();
	public abstract void tick();
	public abstract void render(Graphics g);
	public Toolkit toolkit = Toolkit.getDefaultToolkit();
	public Random random = new Random();
	public int screenSize_X = toolkit.getScreenSize().width;
	public int screenSize_Y = toolkit.getScreenSize().height;
	public Color color;
	public boolean moveRight, moveUp;
	public int object_x,object_y, moveSpeed, objectSize;
	
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
	public void setObjectColor(Color color){
		this.color = color;}
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

}
