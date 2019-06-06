package in.amal.rpg.gameofstones.model.planets;

import in.amal.rpg.gameofstones.model.stones.MindStone;
import in.amal.rpg.gameofstones.model.stones.TimeStone;

public class Earth extends BasePlanet {

    public Earth() {
        super("Earth", "Planet");
        this.stones.add(new MindStone());
        this.stones.add(new TimeStone());
    }

    @Override
    public String getPlanetName() {
        return this.planetName;
    }

    @Override
    public String getPlanetType() {
        return this.planetType;
    }
}
