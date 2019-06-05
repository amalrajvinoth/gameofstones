package in.amal.rpg.gameofstones.view;

import java.util.Optional;

import in.amal.rpg.gameofstones.controller.commands.Command;
import in.amal.rpg.gameofstones.controller.commands.Commands;

public class ExecuteCommandView extends BasicView {

	public Command readCommand() {
		int idCommand = readIntUserInput(Optional.empty(), Commands.getIds());
		return Commands.getExecuter(idCommand).get();
	}
}
