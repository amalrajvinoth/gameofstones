package in.amal.rpg.gameofstones.controller.commands.executors;

import static in.amal.rpg.gameofstones.view.util.MessagesUtils.getText;

import java.util.Optional;

import in.amal.rpg.gameofstones.controller.commands.Command;
import in.amal.rpg.gameofstones.model.Game;
import in.amal.rpg.gameofstones.model.planets.Planet;
import in.amal.rpg.gameofstones.view.BasicView;
import in.amal.rpg.gameofstones.view.util.MessagesUtils;

public class MoveCommand implements Command {

	@Override
	public void execute(Game game, BasicView view) {
		view.printText(MessagesUtils.getText("game.list.near.by.cities"));
		Planet currentPhase = game.getCurrentPlanet();
		view.printText(currentPhase.listNearByPlanets());
		view.printText(MessagesUtils.getText("game.command.move.where"));
		int nextPhaseIndex = view.readIntUserInput(Optional.empty(), currentPhase.getNearByPlanetsIndexes());
		game.setCurrentPlanet(currentPhase.recoverNearPlanetByIndex(nextPhaseIndex));
		view.clear();
		view.printText(getText("game.command.move.welcome", game.getCurrentPlanet()));
	}

}
