package com.TETOSOFT.JUnitTest;

import static org.junit.Assert.*;

import org.junit.Test;

import com.TETOSOFT.tilegame.GameEngine;

public class StopTest {

	@Test
	public void testStop() {
		GameEngine gameEngine = new GameEngine();
		gameEngine.stop();
		boolean isRunning = gameEngine.isRunning();
		assertEquals(false, isRunning);
	}

}
