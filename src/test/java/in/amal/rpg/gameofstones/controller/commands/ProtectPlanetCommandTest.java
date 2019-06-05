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
		assertEquals(0, game.getPlayer().getExp());
		assertEquals(3, game.getPlayer().getAttack());
		assertEquals(110, game.getPlayer().getLife());
	}

	@Test
	public void playerLoseTest() {
		command.execute(GameFactory.createNewGameLastCity(), view);
		assertMessageIsPresent("game.command.acquire.stone.exit");
	}

	@Test
	public void playerWinsTest() {
		command.execute(GameFactory.createNewGame(), view);
		assertTextIsPresent("Congratulation you have won the battle!");
	}
}
