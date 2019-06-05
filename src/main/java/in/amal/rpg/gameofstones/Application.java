package in.amal.rpg.gameofstones;

import in.amal.rpg.gameofstones.controller.LoadOrStartNewGameController;
import in.amal.rpg.gameofstones.controller.RunCommandController;
import in.amal.rpg.gameofstones.controller.StartGameController;
import in.amal.rpg.gameofstones.model.Game;
import in.amal.rpg.gameofstones.view.util.MessagesUtils;

public class Application {
	private static int exit = 0;
	private static Game gameInPlay = null;
	private static LoadOrStartNewGameController loadOrStartNewGameController = new LoadOrStartNewGameController();
	private static RunCommandController runCommandController = new RunCommandController();
	private static StartGameController startGameController = new StartGameController();

	public static Game getGameInPlay() {
		return gameInPlay;
	}

	public static void main(String[] args) {
        MessagesUtils.load();
		loadOrStartNewGameController.newOrLoadGame();
		startGameController.startGame();
		while (exit != 1) {
			runCommandController.executePlayerCommand();
		}
	}

	public static void setExit(int exit) {
		Application.exit = exit;
	}

	public static void setGameInPlay(Game gameInPlay) {
		Application.gameInPlay = gameInPlay;
	}
}