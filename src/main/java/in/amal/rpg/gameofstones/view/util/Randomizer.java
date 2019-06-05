package in.amal.rpg.gameofstones.view.util;

import in.amal.rpg.gameofstones.model.BaseCharactor;
import in.amal.rpg.gameofstones.model.Game;
import in.amal.rpg.gameofstones.model.avengers.*;
import in.amal.rpg.gameofstones.model.planets.*;
import in.amal.rpg.gameofstones.model.stones.*;
import in.amal.rpg.gameofstones.model.villains.*;

import java.util.*;

public class Randomizer {

    private static final List<BaseCharactor> AVENGERS = Arrays.asList(new IronMan(), new CaptainAmerica(), new CaptainMarvel(), new Thor(),
            new Hulk(), new BlackWidow(), new BlackPanther(), new SpiderMan(), new DoctorStrange(), new WinterSoldier());

    private static final List<BaseVillain> VILLAINS = Arrays.asList(new Thanos(), new BlackOrder(), new Ultron(), new RedSkull(),
            new ScarletWitch(), new Hela(), new Loki(), new Ronan(), new Nebula(), new WinterSoldier());

    private static final List<Planet> PLANETS = Arrays.asList(new Asgard(), new Earth(), new Ego(), new Knowhere(),
            new Nidavellir(), new Sokovia(), new Titan(), new Vormir(), new ZenWhoberi(), new Xandar());

    private static final List<BaseStone> STONES = Arrays.asList(new PowerStone(), new TimeStone(), new MindStone(), new RealityStone(),
            new SoulStone(), new SpaceStone());

    public static void prepareGamePlay(Game game) {
        game.setCurrentPlanet(getNextRandomPlanet());
        game.getCurrentPlanet().setNearByPlanets(getRandomPlanets());
        game.getCurrentPlanet().setVillain(getRandomVillains());
        game.getCurrentPlanet().setStones(Arrays.asList(getRandomStone()));
    }

    public static void prepareGamePlay(Game game, Planet planet) {
        planet.setNearByPlanets(getRandomPlanets());
        planet.setVillain(getRandomVillains());
    }

    private static List<BaseVillain> getRandomVillains() {
        return getRandomCharacters(2);
    }

    private static List<Planet> getRandomPlanets() {
        return getRandomPlanets(PLANETS, 2);
    }

    private static Planet getNextRandomPlanet() {
        Random rand = new Random();
        int randomIndex = rand.nextInt(PLANETS.size());
        return PLANETS.get(randomIndex);
    }

    public static List<BaseVillain> getRandomCharacters(int totalItems) {
        Random rand = new Random();
        List newList = new ArrayList<>();
        for (int i = 0; i < totalItems; i++) {
            int randomIndex = rand.nextInt(VILLAINS.size());
            newList.add(VILLAINS.get(randomIndex));
        }
        return newList;
    }

    private static List<Planet> getRandomPlanets(List<Planet> planets, int totalItems) {
        Random rand = new Random();
        List newList = new ArrayList<>();
        for (int i = 0; i < totalItems; i++) {
            int randomIndex = rand.nextInt(planets.size());
            newList.add(planets.get(randomIndex));
        }
        return newList;
    }

    public static Player getRandomAvenger(Player player) {
        Random rand = new Random();
        int randomIndex = rand.nextInt(AVENGERS.size());
        BaseCharactor character = AVENGERS.get(randomIndex);
        player.change(character.getAttack(), character.getExp(), character.getLife());
        return player;
    }

    public static BaseStone getRandomStone() {
        Random rand = new Random();
        int randomIndex = rand.nextInt(STONES.size());
        return STONES.get(randomIndex);
    }
}
