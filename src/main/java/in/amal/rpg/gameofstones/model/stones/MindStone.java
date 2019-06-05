package in.amal.rpg.gameofstones.model.stones;

import in.amal.rpg.gameofstones.view.util.MessagesUtils;

public class MindStone extends BaseStone {

    public MindStone() {
        super();
        this.name = MessagesUtils.getText("game.stone.mind");
        this.alias = MessagesUtils.getText("game.stone.mind.alias");
    }
}
