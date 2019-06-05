package in.amal.rpg.gameofstones.controller;

import in.amal.rpg.gameofstones.Application;
import in.amal.rpg.gameofstones.controller.commands.Commands;
import in.amal.rpg.gameofstones.model.ASCIIArt;
import in.amal.rpg.gameofstones.view.BasicView;
import in.amal.rpg.gameofstones.view.util.MessagesUtils;

public class StartGameController extends BaseController<BasicView> {

	public StartGameController() {
		super(new BasicView());
	}

	public void startGame() {
		view.clear();
		Commands.SAVE.getExecuter().execute(Application.getGameInPlay(), view);
        MessagesUtils.drawAsciiArt("game.name");
		view.printMessage("game.welcome", Application.getGameInPlay());
		view.printMessage("game.goal");
	}
}
