package in.amal.rpg.gameofstones.controller.commands;

import in.amal.rpg.gameofstones.factory.GameFactory;
import org.junit.Test;

import in.amal.rpg.gameofstones.controller.commands.executors.SaveCommand;

public class SaveCommandTest extends BaseCommandTest {
	public SaveCommandTest() {
		super(new SaveCommand());
	}

	@Test
	public void listNearByCitiesTest() {
		this.command.execute(GameFactory.createNewGame(), view);
		assertMessageIsPresent("service.storage.save.success");
	}

}
