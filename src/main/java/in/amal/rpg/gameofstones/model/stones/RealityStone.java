package in.amal.rpg.gameofstones.model.stones;

import in.amal.rpg.gameofstones.view.util.MessagesUtils;

public class RealityStone extends BaseStone {

    public RealityStone() {
        super();
        this.name = MessagesUtils.getText("game.stone.reality");
        this.alias = MessagesUtils.getText("game.stone.reality.alias");
    }
}
