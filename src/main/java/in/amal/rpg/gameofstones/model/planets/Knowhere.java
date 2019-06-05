package in.amal.rpg.gameofstones.model.planets;

import in.amal.rpg.gameofstones.model.stones.RealityStone;

public class Knowhere extends BasePlanet {

    public Knowhere() {
        super("Knowhere", "Planet");
        this.stones.add(new RealityStone());
    }

}
