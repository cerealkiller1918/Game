package com.killerpc.game;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Bullet extends GameObject{
	
	private BufferedImage bullet, img;

	@Override
	public void init() {
		
		try{
			bullet = ImageIO.read(new File("images/bullet.png"));
		} catch(IOException e){
			e.printStackTrace();
		}
		setObject_x(getScreenSize_X()/2);
		setObject_y(getScreenSize_Y()-20);
		img = ImageResize(bullet, 10/2, 40/2);
	}

	@Override
	public void tick() {
		if(getObject_y()>0)
			setObject_y(getObject_y()-2);
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(img, getObject_x(), getObject_y(), null);
		
	}

}
