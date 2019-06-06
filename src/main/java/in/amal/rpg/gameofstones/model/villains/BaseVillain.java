package in.amal.rpg.gameofstones.model.villains;

import in.amal.rpg.gameofstones.model.BaseCharacter;

public abstract class BaseVillain extends BaseCharacter implements Comparable<BaseVillain>{
    public BaseVillain(String name, int attack, int exp, int baseLife) {
        super(name, attack, exp, baseLife);
    }

    // Compare employees based on their IDs
    @Override
    public int compareTo(BaseVillain v) {
        return this.getAttack() - v.getAttack();
    }
}