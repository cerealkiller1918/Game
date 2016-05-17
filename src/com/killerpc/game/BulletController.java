package com.killerpc.game;

import java.awt.Graphics;
import java.util.ArrayList;

/**
 *
 * @author Justin Frasier
 */

public class BulletController {

	private ArrayList<Bullet> bulletList;
	private Player player;

	public BulletController(Player player) {
		bulletList = new ArrayList<Bullet>();
		this.player = player;
	}

	public void AddBullet() {
		if (bulletList.size() < 10) {
			if (bulletList.isEmpty()) {
				bulletList.add(new Bullet());
				bulletList.get(0).init();
				bulletList.get(0).setObject_x(player.getObject_x() + 13);
				bulletList.get(0).setObject_y(player.getObject_y() + 10);
			} else {
				bulletList.add(new Bullet());
				bulletList.get(bulletList.size() - 1).init();
				bulletList.get(bulletList.size() - 1).setObject_x(player.getObject_x() + 13);
				bulletList.get(bulletList.size() - 1).setObject_y(player.getObject_y() + 10);
			}
		}
	}

	public void RemoveBullet(int index) {
		if (!bulletList.isEmpty()) {
			bulletList.remove(index);
		}
	}

	public void OffScreen(int i) {
		if (!bulletList.isEmpty() && bulletList.get(i).getObject_y() < 4) {
			RemoveBullet(i);
		}

	}

	public int AmountOfBullets() {
		return bulletList.size();
	}

	public int AmountOfBulletLeft() {
		int bullet = 10;

		return bullet - AmountOfBullets();
	}

	public void tick() {
		int i = 0;
		while (!bulletList.isEmpty() && bulletList.size() > i) {

			bulletList.get(i).tick();
			OffScreen(i);
			i++;
		}
	}

	public void render(Graphics g) {
		if (!bulletList.isEmpty()) {
			for (int i = 0; i < bulletList.size(); i++) {
				bulletList.get(i).render(g);
			}
		}

	}
}
