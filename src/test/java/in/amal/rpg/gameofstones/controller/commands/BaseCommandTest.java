package in.amal.rpg.gameofstones.controller.commands;

import in.amal.rpg.gameofstones.BaseTest;
import in.amal.rpg.gameofstones.view.BasicView;

public abstract class BaseCommandTest extends BaseTest {

	protected Command command;
	protected BasicView view = new BasicView();

	public BaseCommandTest(Command command) {
		super();
		this.command = command;
	}

}