package in.amal.rpg.gameofstones.model.planets;

import java.io.Serializable;
import java.util.List;

import in.amal.rpg.gameofstones.model.BaseCharactor;
import in.amal.rpg.gameofstones.model.avengers.BaseAvenger;
import in.amal.rpg.gameofstones.model.stones.BaseStone;
import in.amal.rpg.gameofstones.model.villains.BaseVillain;

public interface Planet extends Serializable {

	String getPlanetName();

	String getPlanetType();

    void setVillain(List<BaseVillain> villains);

    void setNearByPlanets(List<Planet> planets);

    void setStones(List<BaseStone> stones);

	BaseVillain getVillain();

	int[] getNearByPlanetsIndexes();

	List<String> listNearByPlanets();

	Planet recoverNearPlanetByIndex(int id);

	boolean isStoneExist();

}
