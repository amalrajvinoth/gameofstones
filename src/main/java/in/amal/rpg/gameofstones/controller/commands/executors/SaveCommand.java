package in.amal.rpg.gameofstones.controller.commands.executors;

import java.io.IOException;

import in.amal.rpg.gameofstones.controller.commands.Command;
import in.amal.rpg.gameofstones.model.Game;
import in.amal.rpg.gameofstones.model.Storage;
import in.amal.rpg.gameofstones.view.BasicView;

public class SaveCommand implements Command {

	private Storage service = new Storage();

	@Override
	public void execute(Game game, BasicView view) {
		try {
			view.printMessage(this.service.saveGame(game));
		} catch (IOException e) {
			view.printMessage("service.command.save.error");
		}
	}

}
