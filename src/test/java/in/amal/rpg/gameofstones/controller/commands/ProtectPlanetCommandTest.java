package in.amal.rpg.gameofstones.controller.commands;

import static org.junit.Assert.assertEquals;

import in.amal.rpg.gameofstones.factory.GameFactory;
import org.junit.Test;

import in.amal.rpg.gameofstones.controller.commands.executors.AcquireStoneCommand;
import in.amal.rpg.gameofstones.model.Game;

public class ProtectPlanetCommandTest extends BaseCommandTest {

	public ProtectPlanetCommandTest() {
		super(new AcquireStoneCommand());
	}

	@Test
	public void playerLevelUpTest() {
		Game game = GameFactory.createNewGame();
		while (game.getPlayer().getLevel() != 2) {
			command.execute(game, view);
		}
		assertEquals(2, game.getPlayer().getLevel());
	}

	@Test
	public void playerLoseTest() {
		command.execute(GameFactory.createNewGameLastPlanet(), view);
		//massertMessageIsPresent("game.command.acquire.stone.exit");
	}

	@Test
	public void playerWinsTest() {
		command.execute(GameFactory.createNewGame(), view);
		assertTextIsPresent("Congratulation you have won the battle!");
	}
}
