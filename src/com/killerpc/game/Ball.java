package com.killerpc.game;
import java.awt.Graphics;



public class Ball extends GameObject {
	
	private RandomColor rc;
	
	@Override
	public void init() {
		this.object_x = random.nextInt(screenSize_X);
		this.object_y = random.nextInt(screenSize_Y);
		this.objectSize = 80;
		this.moveSpeed = random.nextInt(4);
		this.moveRight = random.nextBoolean();
		this.moveUp = random.nextBoolean();
		rc = new RandomColor();
		this.color = rc.getColor();
	}


	@Override
	public void tick() {
		
		while (this.moveSpeed < 1){
			this.moveSpeed = random.nextInt(4);}
		
		if(this.object_x < this.screenSize_X- 80 - this.moveSpeed && this.moveRight){
			this.object_x += this.moveSpeed;
		}else{ this.moveRight = false;}
		if(this.object_x > this.moveSpeed -1 && !this.moveRight){
			this.object_x -= this.moveSpeed;
		}else{this.moveRight = true;}
		if(this.object_y > this.moveSpeed -1 && !this.moveUp){
			this.object_y -= this.moveSpeed;
		}else{this.moveUp = true;}
		if(this.object_y < this.screenSize_Y - 80 - this.moveSpeed -1 && this.moveUp){
			this.object_y += this.moveSpeed;
		}else{this.moveUp = false;}
		
	}

	@Override
	public void render(Graphics g) {
		g.setColor(color);
		g.fillOval(this.object_x, this.object_y, this.objectSize, this.objectSize);
		
	}


	
	

}
