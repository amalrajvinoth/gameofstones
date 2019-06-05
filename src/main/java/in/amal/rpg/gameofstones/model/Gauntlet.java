package in.amal.rpg.gameofstones.model;

import in.amal.rpg.gameofstones.model.stones.BaseStone;
import in.amal.rpg.gameofstones.view.util.MessagesUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Gauntlet implements Serializable {
    private Collection<BaseStone> stones = new ArrayList<>();

    public void addStone(BaseStone stone) {
        this.stones.add(stone);
    }

    public boolean isAllStonesCollected() {
        return stones.size() == 6;
    }

    public List<String> describe() {
        return Arrays.asList(MessagesUtils.getText("game.character.stones", this.stones.size(), this.stones));
    }
}
