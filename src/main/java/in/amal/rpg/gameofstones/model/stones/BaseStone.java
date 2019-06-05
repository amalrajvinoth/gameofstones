package in.amal.rpg.gameofstones.model.stones;

import in.amal.rpg.gameofstones.model.planets.Planet;

import java.io.Serializable;

public abstract class BaseStone implements Serializable {
    protected String name;
    protected String alias;
    protected Planet planet;

    public String describe() {
        return name+"("+alias+") at "+planet.getPlanetName()+" - "+planet.getPlanetType();
    }

    @Override
    public String toString() {
        return name;
    }
}
