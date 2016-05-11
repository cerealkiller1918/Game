package com.killerpc.game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ObjectMove implements KeyListener{
	
	private Object O;
	
	public void setObject(Object O){
		this.O = O;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		if(e.getKeyCode() == KeyEvent.VK_LEFT){
			
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {}

	@Override
	public void keyTyped(KeyEvent e) {}
}
