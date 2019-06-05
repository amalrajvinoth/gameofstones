package in.amal.rpg.gameofstones.model;

import in.amal.rpg.gameofstones.model.avengers.Player;
import in.amal.rpg.gameofstones.model.planets.Earth;
import in.amal.rpg.gameofstones.model.planets.Planet;
import in.amal.rpg.gameofstones.view.util.Randomizer;

import java.io.Serializable;
import java.util.concurrent.ThreadLocalRandom;

public class Game implements Serializable {

    private static final long serialVersionUID = -1459703123591010134L;
    private Planet currentPlanet;
    private final Integer id;
    private Player player;

    public Game(String playerName) {
        super();
        this.id = ThreadLocalRandom.current().nextInt();
        this.currentPlanet = new Earth();
        this.player = new Player(playerName, this);

        Randomizer.prepareGamePlay(this);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Game) {
            Game other = (Game) obj;
            return this.id.equals(other.id);
        }
        return false;
    }

    public void levelUp(int level) {
        if(level > 1) {
            this.player = Randomizer.getRandomAvenger(this.getPlayer());
        }
    }

    public Planet getCurrentPlanet() {
        return this.currentPlanet;
    }

    public Integer getId() {
        return this.id;
    }

    public Player getPlayer() {
        return player;
    }

    @Override
    public int hashCode() {
        return this.id.hashCode();
    }

    public void setCurrentPlanet(Planet currentPlanet) {
        this.currentPlanet = currentPlanet;
        Randomizer.prepareGamePlay(this, this.currentPlanet);
    }

    @Override
    public String toString() {
        return player.getName();
    }
}
