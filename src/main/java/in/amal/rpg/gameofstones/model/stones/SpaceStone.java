package in.amal.rpg.gameofstones.model.stones;

import in.amal.rpg.gameofstones.view.util.MessagesUtils;

public class SpaceStone extends BaseStone {

    public SpaceStone() {
        super();
        this.name = MessagesUtils.getText("game.stone.space");
        this.alias = MessagesUtils.getText("game.stone.space.alias");
    }
}
