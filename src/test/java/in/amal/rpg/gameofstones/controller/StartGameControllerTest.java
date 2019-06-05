package in.amal.rpg.gameofstones.controller;

import in.amal.rpg.gameofstones.Application;
import in.amal.rpg.gameofstones.factory.GameFactory;
import org.junit.Test;

public class StartGameControllerTest extends BaseControllerTest<StartGameController> {

	public StartGameControllerTest() {
		super(new StartGameController());
	}

	@Test
	public void startGameTest() {
		Application.setGameInPlay(GameFactory.createNewGame());
		controller.startGame();
		assertMessageIsPresent("game.goal");
	}

}
