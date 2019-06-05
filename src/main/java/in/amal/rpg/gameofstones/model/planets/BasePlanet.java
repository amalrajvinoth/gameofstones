package in.amal.rpg.gameofstones.model.planets;

import in.amal.rpg.gameofstones.model.stones.BaseStone;
import in.amal.rpg.gameofstones.model.villains.BaseVillain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class BasePlanet implements Planet {

    private static final long serialVersionUID = 5375202366367919309L;
    protected String planetName;
    protected String planetType;
    protected List<BaseVillain> villains;
    protected List<Planet> nearByPlanets;
    protected List<BaseStone> stones = new ArrayList<>();

    private Random random = new Random();

    public BasePlanet(String planetName, String planetType) {
        super();
        this.planetName = planetName;
        this.planetType = planetType;
    }

    public BasePlanet(String planetName, String planetType, List<BaseVillain> villains, List<Planet> nearByPlanets) {
        super();
        this.planetName = planetName;
        this.planetType = planetType;
        this.villains = villains;
        this.nearByPlanets = nearByPlanets;
    }

    public void setVillain(List<BaseVillain> villains) {
        this.villains = villains;
    }

    public void setNearByPlanets(List<Planet> nearByPlanets) {
        this.nearByPlanets = nearByPlanets;
    }

    public void setStones(List<BaseStone> stones){
        this.stones.addAll(stones);
    }

    @Override
    public boolean equals(Object arg0) {
        if (arg0 instanceof BasePlanet) {
            BasePlanet otherPhase = (BasePlanet) arg0;
            return getPlanetName().equals(otherPhase.getPlanetName());
        }
        return false;
    }

    @Override
    public String getPlanetName() {
        return this.planetName;
    }

    @Override
    public String getPlanetType() {
        return this.planetType;
    }

    @Override
    public BaseVillain getVillain() {
        int randomIdx = random.nextInt(villains.size());
        return villains.get(randomIdx);
    }

    @Override
    public int[] getNearByPlanetsIndexes() {
        int[] indexes = new int[nearByPlanets.size()];
        for (int i = 0; i < nearByPlanets.size(); i++) {
            indexes[i] = i;
        }
        return indexes;
    }

    @Override
    public int hashCode() {
        return getPlanetName().hashCode();
    }

    @Override
    public List<String> listNearByPlanets() {
        List<String> texts = new ArrayList<>();
        for (int i = 0; i < nearByPlanets.size(); i++) {
            texts.add(nearByPlanets.get(i) + "  [" + i + "]");
        }
        return texts;
    }

    @Override
    public boolean isStoneExist() {
        return !this.stones.isEmpty();
    }

    public List<BaseStone> getStones() {
        return this.stones;
    }

    @Override
    public Planet recoverNearPlanetByIndex(int index) {
        return nearByPlanets.get(index);
    }

    @Override
    public String toString() {
        return getPlanetName() + " - " + getPlanetType();
    }
}
