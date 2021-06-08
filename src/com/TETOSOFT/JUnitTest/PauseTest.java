package com.TETOSOFT.JUnitTest;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.Test;

import com.TETOSOFT.tilegame.GameEngine;

public class PauseTest {

	@Test
	public void testPause() {
		GameEngine gameEngine = new GameEngine();
		gameEngine.pause();
		int outScene = gameEngine.getScene();
		assertEquals(0, outScene);
	}

}
