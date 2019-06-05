package in.amal.rpg.gameofstones.controller.commands;

import in.amal.rpg.gameofstones.model.Game;
import in.amal.rpg.gameofstones.view.BasicView;

public interface Command {

	public void execute(Game game, BasicView view);

}
