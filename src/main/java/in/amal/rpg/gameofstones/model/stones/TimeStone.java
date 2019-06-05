package in.amal.rpg.gameofstones.model.stones;

import in.amal.rpg.gameofstones.view.util.MessagesUtils;

public class TimeStone extends BaseStone {

    public TimeStone() {
        super();
        this.name = MessagesUtils.getText("game.time.space");
        this.alias = MessagesUtils.getText("game.time.space.alias");
    }
}
