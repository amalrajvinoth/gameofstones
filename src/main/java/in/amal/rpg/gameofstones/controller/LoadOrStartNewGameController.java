package in.amal.rpg.gameofstones.controller;

import java.util.List;
import java.util.Optional;

import in.amal.rpg.gameofstones.Application;
import in.amal.rpg.gameofstones.controller.util.MyListUtils;
import in.amal.rpg.gameofstones.model.Game;
import in.amal.rpg.gameofstones.model.Storage;
import in.amal.rpg.gameofstones.view.BasicView;

public class LoadOrStartNewGameController extends BaseController<BasicView> {
	private Storage storage = new Storage();

	public LoadOrStartNewGameController() {
		super(new BasicView());
	}

	private void loadGame() {
		List<Game> games = storage.loadGames();
		if (games.isEmpty()) {
			view.printMessage("service.storage.load.empty.games");
			startNewGame();
		} else {
			selectGame(games);
		}
	}

	public void newOrLoadGame() {
		view.printMessage("game.setup.new.or.load");
		int option = view.readIntUserInput(Optional.of(0), new int[] { 0, 1 });
		if (option == 1) {
			loadGame();
		} else {
			startNewGame();
		}
	}

	private void selectGame(List<Game> games) {
		view.printMessage("game.setup.load.select.game");
		for (int i = 0; i < games.size(); i++) {
			view.printText(games.get(i) + "  [" + i + "]");
		}
		int indexSelectedGame = view.readIntUserInput(Optional.empty(), MyListUtils.indexesToArray(games));
		Application.setGameInPlay(games.get(indexSelectedGame));
		view.printMessage("game.setup.load.success");
	}

	private void startNewGame() {
		view.printMessage("game.setup.new");
		Application.setGameInPlay(new Game(view.readStringUserInput()));
		view.clear();
		view.printMessage("game.setup.new.start", Application.getGameInPlay());
	}
}
