package in.amal.rpg.gameofstones.model.planets;

import in.amal.rpg.gameofstones.model.stones.PowerStone;

public class Xandar extends BasePlanet {

    public Xandar() {
        super("Xandar", "Planet");
        this.stones.add(new PowerStone());
    }

}
