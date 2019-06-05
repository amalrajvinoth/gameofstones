package in.amal.rpg.gameofstones.controller.commands.executors;

import in.amal.rpg.gameofstones.Application;
import in.amal.rpg.gameofstones.controller.commands.Command;
import in.amal.rpg.gameofstones.model.ASCIIArt;
import in.amal.rpg.gameofstones.model.Game;
import in.amal.rpg.gameofstones.view.BasicView;
import in.amal.rpg.gameofstones.view.util.MessagesUtils;

public class ExitCommand implements Command {

	@Override
	public void execute(Game game, BasicView view) {
        MessagesUtils.drawAsciiArt("game.exit");
		view.printMessage(("game.exit.author"));
		Application.setExit(1);
	}

}
