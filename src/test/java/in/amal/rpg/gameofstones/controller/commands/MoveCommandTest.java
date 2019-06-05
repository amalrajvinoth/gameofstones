package in.amal.rpg.gameofstones.controller.commands;

import in.amal.rpg.gameofstones.factory.GameFactory;
import org.junit.Test;

import in.amal.rpg.gameofstones.controller.commands.executors.MoveCommand;
import in.amal.rpg.gameofstones.model.Game;

public class MoveCommandTest extends BaseCommandTest {
	public MoveCommandTest() {
		super(new MoveCommand());
	}

	@Test
	public void moveCommandTest() {
		setUserInput("0".getBytes());
		Game game = GameFactory.createNewGame();
		this.command.execute(game, view);
		assertTextIsPresent("Birnin Azzaria - Planet  [0]");
		assertMessageIsPresent("game.command.move.welcome", "Birnin Azzaria - Planet");
	}

	@Test
	public void wrongInputMoveCommandTest() {
		setUserInput("55\n55\n0".getBytes());
		Game game = GameFactory.createNewGame();
		this.command.execute(game, view);
		assertTextIsPresent("Birnin Azzaria - Planet  [0]");
		assertMessageIsPresent("game.command.move.welcome", "Birnin Azzaria - Planet");
	}

}
