package in.amal.rpg.gameofstones.controller;

import in.amal.rpg.gameofstones.Application;
import in.amal.rpg.gameofstones.controller.commands.Command;
import in.amal.rpg.gameofstones.view.ExecuteCommandView;

public class RunCommandController extends BaseController<ExecuteCommandView> {

	public RunCommandController() {
		super(new ExecuteCommandView());
	}

	public void executePlayerCommand() {
		view.printMessage("game.command.ask.user.input");
		Command command = view.readCommand();
		view.clear();
		command.execute(Application.getGameInPlay(), view);
	}

}
