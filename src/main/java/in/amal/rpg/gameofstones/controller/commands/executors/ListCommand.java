package in.amal.rpg.gameofstones.controller.commands.executors;

import in.amal.rpg.gameofstones.controller.commands.Command;
import in.amal.rpg.gameofstones.model.Game;
import in.amal.rpg.gameofstones.view.BasicView;
import in.amal.rpg.gameofstones.view.util.MessagesUtils;

public class ListCommand implements Command {

	@Override
	public void execute(Game game, BasicView view) {
		view.printMessage("game.command.list.commands");
		view.printText(MessagesUtils.getAllByPrefix("game.command.list.commands.describe"));
	}

}
