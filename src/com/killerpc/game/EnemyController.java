package com.killerpc.game;

import java.awt.Graphics;
import java.util.ArrayList;

/**
*
* @author Justin Frasier
*/

public class EnemyController {
	
	private ArrayList<Enemy> enemyList;
	
	public EnemyController(){
		enemyList = new ArrayList<Enemy>();
	}
	
	public void AddEnemy(){
		if(enemyList.size()<10){
			if(enemyList.isEmpty()){
				enemyList.add(new Enemy());
				enemyList.get(0).init();
			}
		}else{
			enemyList.add(new Enemy());
			enemyList.get(enemyList.size()).init();
		}
	}
	
	public void RemoveEnemy(int index){
		if(!enemyList.isEmpty()){
			enemyList.remove(index);
		}		
	}
	
	public void tick(){
		int i = 0;
		while(!enemyList.isEmpty() && enemyList.size() > i){
			enemyList.get(i).tick();
			i++;
		}
		
	}
	
	public void render(Graphics g){
		if(!enemyList.isEmpty()){
			for (int i=0; i< enemyList.size(); i++){
				enemyList.get(i).render(g);
			}
		}
	}
	
}
