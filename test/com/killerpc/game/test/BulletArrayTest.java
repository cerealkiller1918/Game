package com.killerpc.game.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.killerpc.game.Bullet;

public class BulletArrayTest {

	ArrayList<Bullet> bullet;

	@Before
	public void setUp() throws Exception {
		bullet = new ArrayList<Bullet>();
	}

	@After
	public void tearDown() throws Exception {
		bullet.clear();
	}

	@Test
	public void ArrayTestAdding() {

		for (int i = 0; i < 200; i++) {
			bullet.add(new Bullet());
			bullet.get(i).init();
		}
		assertEquals(200, bullet.size());
	}

	@Test
	public void ArrayTickTest() {
		for (int i = 0; i < 20; i++) {
			bullet.add(new Bullet());
			bullet.get(i).init();
		}
		for (int i = 0; i < 20; i++) {
			bullet.get(i).tick();
		}

	}

}
