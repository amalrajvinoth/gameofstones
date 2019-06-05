package in.amal.rpg.gameofstones.controller;

import in.amal.rpg.gameofstones.BaseTest;

public abstract class BaseControllerTest<T extends BaseController<?>> extends BaseTest {

	protected final T controller;

	public BaseControllerTest(T controller) {
		super();
		this.controller = controller;
	}

}