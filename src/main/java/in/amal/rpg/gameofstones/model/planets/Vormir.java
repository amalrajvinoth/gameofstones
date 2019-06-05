package in.amal.rpg.gameofstones.model.planets;

import in.amal.rpg.gameofstones.model.stones.SoulStone;

public class Vormir extends BasePlanet {

    public Vormir() {
        super("Vormir", "Planet");
        this.stones.add(new SoulStone());
    }

}
