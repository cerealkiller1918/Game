package com.killerpc.game;

import java.awt.Graphics;
import java.io.IOException;
import java.util.ArrayList;

public class Controller {
	
	private ArrayList<Bullet> bulletList;
	
	public Controller(){
		bulletList = new ArrayList<Bullet>();
	}
	
	public void AddBullet(){
		bulletList.add(new Bullet());
		bulletList.get(bulletList.size()-1).init();
	}
	
	public void RemoveBullet(int index){
		if(!bulletList.isEmpty()){
			bulletList.remove(index);
		}
	}

	public void OffScreen(int i){
		if(bulletList.get(i).getObject_y()<4){
			RemoveBullet(i);
		}
	
	}
	
	public void tick(){
		bulletList.trimToSize();
		for(int i=0; i<bulletList.size(); i++){
			OffScreen(i);
			bulletList.get(i).tick();
		}
		
	}
	
	public void render(Graphics g){
		
		for(int i=0; i<bulletList.size(); i++){
			bulletList.get(i).render(g);
		}
		
		
	}
}
