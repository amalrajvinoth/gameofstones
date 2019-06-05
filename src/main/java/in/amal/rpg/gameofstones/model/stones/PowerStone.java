package in.amal.rpg.gameofstones.model.stones;

import in.amal.rpg.gameofstones.view.util.MessagesUtils;

public class PowerStone extends BaseStone {

    public PowerStone() {
        super();
        this.name = MessagesUtils.getText("game.stone.power");
        this.alias = MessagesUtils.getText("game.stone.power.alias");
    }
}
