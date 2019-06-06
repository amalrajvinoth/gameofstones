package in.amal.rpg.gameofstones.model.stones;

import in.amal.rpg.gameofstones.model.planets.Planet;

import java.io.Serializable;
import java.util.Objects;

public abstract class BaseStone implements Serializable {
    protected String name;
    protected String alias;
    protected Planet planet;

    public String describe() {
        return name+"("+alias+") at "+planet.getPlanetName()+" - "+planet.getPlanetType();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseStone stone = (BaseStone) o;
        return this.name == stone.name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return name;
    }
}
