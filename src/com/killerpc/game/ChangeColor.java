package com.killerpc.game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

/**
 *
 * @author Justin Frasier
 */

public class ChangeColor implements KeyListener {

	private RandomColor rc = new RandomColor();
	private ArrayList<Ball> ballList;

	public void setBallList(ArrayList<Ball> ballList) {
		this.ballList = ballList;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			for (int i = 0; i < ballList.size(); i++) {
				ballList.get(i).setObjectColor(rc.getColor());
			}

		} else if (e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode() == KeyEvent.VK_UP) {
			for (int x=0; x<10; x++){
				ballList.add(new Ball());
				ballList.get(ballList.size()-1).init();
				ballList.get(ballList.size()-1).setObjectColor(rc.getColor());
			}
		} else if (e.getKeyCode() == KeyEvent.VK_E || e.getKeyCode() == KeyEvent.VK_DOWN) {
			if (!ballList.isEmpty()) {
				for(int i=0; i <10; i++){
					ballList.remove(ballList.size()-1);
				}
			}
		}else if (e.getKeyCode()==KeyEvent.VK_Z){
			if(ballList.size()>10){
				while(ballList.size()>10){
					ballList.remove(ballList.size()-1);
				}
			}else if(ballList.size()<10){
				while(ballList.size()<10){
					ballList.add(new Ball());
					ballList.get(ballList.size()-1).setObjectColor(rc.getColor());
				}
			}
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

}
