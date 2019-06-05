package in.amal.rpg.gameofstones.controller.commands;

import org.junit.Test;

import in.amal.rpg.gameofstones.controller.commands.executors.ExitCommand;

public class ExitCommandTest extends BaseCommandTest {
	public ExitCommandTest() {
		super(new ExitCommand());
	}

	@Test
	public void exitTest() {
		command.execute(null, view);
		assertMessageIsPresent("game.exit.author");
	}

}
