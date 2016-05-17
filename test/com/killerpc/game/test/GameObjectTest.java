package com.killerpc.game.test;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.killerpc.game.GameObject;
import com.killerpc.game.Player;

public class GameObjectTest {

	GameObject game;
	
	@Before
	public void setUp() throws Exception {
		game = new Player();
	}

	@After
	public void tearDown() throws Exception {
	
	}

	@Test
	public void testSetObject_x() {
		game.setObject_x(23);
		assertEquals(23, game.getObject_x());
	}

	@Test
	public void testSetObject_y() {
		game.setObject_y(44);
		assertEquals(44, game.getObject_y());
	}

	@Test
	public void testGetObject_x() {
		game.setObject_x(10);
		assertEquals(10,game.getObject_x());
	}

	@Test
	public void testGetObject_y() {
		game.setObject_y(109);
		assertEquals(109, game.getObject_y());
	}

	@Test
	public void testSetObjectSize() {
		game.setObjectSize(20);
		assertEquals(20, game.getObjectSize());
	}

	@Test
	public void testGetObjectSize() {
		game.setObjectSize(108);
		assertEquals(108, game.getObjectSize());
	}

	@Test
	public void testSetObjectMoveRight() {
		game.setObjectMoveRight(true);
		assertEquals(true, game.getObjectMoveRight());
	}

	@Test
	public void testGetObjectMoveRight() {
		game.setObjectMoveRight(false);
		assertEquals(false, game.getObjectMoveRight());
	}

	@Test
	public void testSetObjectMoveUp() {
		game.setObjectMoveUp(true);
		assertEquals(true, game.getObjectMoveUp());
	}

	@Test
	public void testGetObjectMoveUp() {
		game.setObjectMoveUp(false);
		assertEquals(false, game.getObjectMoveUp());
	}

	@Test
	public void testSetObjectMoveSpeed() {
		game.setObjectMoveSpeed(16);
		assertEquals(16, game.getObjectMoveSpeed());
	}

	@Test
	public void testGetObjectMoveSpeed() {
		game.setObjectMoveSpeed(67);
		assertEquals(67, game.getObjectMoveSpeed());
	}


	

}
