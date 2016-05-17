package com.killerpc.game;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
*
* @author Justin Frasier
*/

public class Enemy extends GameObject{
	
	private BufferedImage enemy;
		
	@Override
	public void init() {
		try {
			enemy = ImageIO.read(new File("images/enemy.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}	
		
		setObject_x(getScreenSize_X()/2);
		setObject_y(getScreenSize_Y()/2);
		
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
		
		g.drawImage(enemy,getObject_x(),getObject_y(),null);
		
	}

}
