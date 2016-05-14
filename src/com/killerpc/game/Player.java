package com.killerpc.game;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Player extends GameObject{
	
	private BufferedImage player, playerMove, img;
	
	@Override
	public void init() {
		
		try {
			player = ImageIO.read(new File("images/player.1.png"));
			playerMove = ImageIO.read(new File("images/player.2.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		setObject_x(getScreenSize_X()/2);
		setObject_y(getScreenSize_Y()/2);
		img = player;
	}

	@Override
	public void tick() {
		
		if(getObjectMoveUp()){
			img = playerMove;
			if(getObject_y() > 0)
			setObject_y(getObject_y()-2);
		}else{
			img = player;
			if(getObject_y() < getScreenSize_Y()-80)
			setObject_y(getObject_y()+1);
		}
		
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(img, getObject_x(), getObject_y(), null);
		
	}

}
