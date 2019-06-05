package in.amal.rpg.gameofstones.model.stones;

import in.amal.rpg.gameofstones.view.util.MessagesUtils;

public class SoulStone extends BaseStone {

    public SoulStone() {
        super();
        this.name = MessagesUtils.getText("game.stone.soul");
        this.alias = MessagesUtils.getText("game.stone.soul.alias");
    }
}
