package com.teststeps;
import static org.junit.Assert.assertEquals;

import java.awt.AWTException;
import java.awt.Robot;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Key;
import org.sikuli.script.Screen;

import com.TETOSOFT.tilegame.GameEngine;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinitions {

	Screen s = new Screen();
	
	public StepDefinitions() {
	}

	@Given("^the game is started$")
	public void the_game_is_started() {
		GameEngine.main(null);
	}

	@When("^I press the esc key$")
	public void i_push_the_esc_key() throws FindFailed, AWTException {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Robot robot = new Robot();
		robot.mouseMove(0,0);
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Clicking ESC Button ...");
		s.keyDown(Key.ESC);
		
	}

	@Then("^the game should stop$")
	public void the_game_should_stop() throws FindFailed {
		assertEquals(true, s.find("src/main/resources/images/result4.JPG") != null ? true : false);
	}
	
	
	
}
