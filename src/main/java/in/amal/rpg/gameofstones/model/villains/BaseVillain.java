package in.amal.rpg.gameofstones.model.villains;

import in.amal.rpg.gameofstones.model.BaseCharactor;

public abstract class BaseVillain extends BaseCharactor {
    public BaseVillain(String name, int attack, int exp, int baseLife) {
        super(name, attack, exp, baseLife);
    }
}