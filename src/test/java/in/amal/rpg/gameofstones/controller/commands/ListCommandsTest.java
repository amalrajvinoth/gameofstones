package in.amal.rpg.gameofstones.controller.commands;

import org.junit.Test;

import in.amal.rpg.gameofstones.controller.commands.executors.ListCommand;

public class ListCommandsTest extends BaseCommandTest {
	public ListCommandsTest() {
		super(new ListCommand());
	}

	@Test
	public void listCommandsTest() {
		this.command.execute(null, view);
		assertMessageIsPresent("game.command.list.commands.describe.exit");
		assertMessageIsPresent("game.command.list.commands.describe.list.commands");
		assertMessageIsPresent("game.command.list.commands.describe.save");
	}

}
