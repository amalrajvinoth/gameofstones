package in.amal.rpg.gameofstones.controller.commands;

import static org.junit.Assert.assertEquals;

import in.amal.rpg.gameofstones.factory.GameFactory;
import org.junit.Test;

import in.amal.rpg.gameofstones.controller.commands.executors.AcquireStoneCommand;
import in.amal.rpg.gameofstones.model.Game;

public class AcquireStoneCommandTest extends BaseCommandTest {

	public AcquireStoneCommandTest() {
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
        Game game = GameFactory.createNewGameLastPlanet();
        game.getPlayer().set("Loser", 0,0,0);
        while(game.getPlayer().getStatus() != -1) {
            command.execute(game, view);
        }
	}

	@Test
	public void playerWinsTest() {
        Game game = GameFactory.createNewGame();
        game.getPlayer().set("Winner", 1000,1000,1000);

        while(game.getPlayer().getStatus() != -1) {
            command.execute(game, view);
        }
	}
}
