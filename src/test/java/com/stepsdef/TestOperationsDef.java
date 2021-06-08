package com.stepsdef;

import static org.junit.Assert.assertEquals;

import java.awt.AWTException;
import java.awt.Robot;
import java.time.LocalDateTime;

import com.TETOSOFT.tilegame.GameEngine;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TestOperationsDef {

	public TestOperationsDef() {
	}

	@Given("^the game is started$")
	public void the_game_is_started() throws Throwable {
		System.out.println("Game started !" + LocalDateTime.now());
		Thread testTh = new Thread() {
			public void run() {
				GameEngine.main(null);
			}
		};
		testTh.start();
	}

	@When("^I press the esc key$")
	public void i_push_the_esc_key() throws Throwable {

		try {
			Thread.sleep(2000);
			Robot robot = new Robot();
			robot.mouseMove(0, 0);
		} catch (AWTException e) {
			e.printStackTrace();
		}
		System.out.println("Clicking ESC Button ..." + LocalDateTime.now());
	}

	@Then("^the game should stop$")
	public void the_game_should_stop() throws Throwable {
		System.out.println("Stoping ..." + LocalDateTime.now());

		assertEquals(true, GameEngine.isStopped);
	}
	
	
}