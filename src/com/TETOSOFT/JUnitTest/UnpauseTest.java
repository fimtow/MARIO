package com.TETOSOFT.JUnitTest;

import static org.junit.Assert.*;

import org.junit.Test;

import com.TETOSOFT.tilegame.GameEngine;

public class UnpauseTest {

	@Test
	public void test() {
		GameEngine gameEngine = new GameEngine();
		gameEngine.unPause();
		int outScene = gameEngine.getScene();
		assertEquals(-1, outScene);
	}

}
