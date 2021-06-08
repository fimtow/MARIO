Feature: Test game

	Scenario Outline: the game should stop once we click on ESC button
		Given the game is started
		When I press the esc key
		Then the game should stop
