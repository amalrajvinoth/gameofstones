package in.amal.rpg.gameofstones.controller;

import in.amal.rpg.gameofstones.view.BasicView;

public abstract class BaseController<T extends BasicView> {

	protected T view;

	public BaseController(T view) {
		super();
		this.view = view;
	}

}
