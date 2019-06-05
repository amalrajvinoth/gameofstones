package in.amal.rpg.gameofstones.model.planets;


import in.amal.rpg.gameofstones.model.stones.SpaceStone;

public class Asgard extends BasePlanet {
    public Asgard() {
        super("Asgard", "Planet");
        this.stones.add(new SpaceStone());
    }
}
