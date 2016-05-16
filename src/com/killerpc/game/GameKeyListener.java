package com.killerpc.game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameKeyListener implements KeyListener{

	private Game game;
	private Player player;
	private Controller cont;
	
	public GameKeyListener(Game game, Player player, Controller cont) {
		
		this.game = game;	
		this.player = player;
		this.cont = cont;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		
		if(e.getKeyCode() == KeyEvent.VK_ESCAPE){
			game.setRunning(false);
		}
		else if(e.getKeyCode() == KeyEvent.VK_UP){
			player.setObjectMoveUp(true);
		}
		else if (e.getKeyCode() == KeyEvent.VK_DOWN){
		   if(player.getObject_y() < player.getScreenSize_Y()-70)
			player.setObject_y(player.getObject_y()+5);
		}
		else if (e.getKeyCode() == KeyEvent.VK_LEFT){
			player.setObject_x(player.getObject_x()-5);
		}
		else if(e.getKeyCode() == KeyEvent.VK_RIGHT){
			player.setObject_x(player.getObject_x()+5);
		}else if(e.getKeyCode() == KeyEvent.VK_SPACE){
			cont.AddBullet();
		}
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
		if(e.getKeyCode() == KeyEvent.VK_UP){
			player.setObjectMoveUp(false);
		}
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
