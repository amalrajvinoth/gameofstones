package in.amal.rpg.gameofstones.model.avengers;

import in.amal.rpg.gameofstones.model.BaseCharacter;
import in.amal.rpg.gameofstones.model.Game;
import in.amal.rpg.gameofstones.model.Gauntlet;
import in.amal.rpg.gameofstones.model.planets.BasePlanet;
import in.amal.rpg.gameofstones.model.planets.Planet;
import in.amal.rpg.gameofstones.model.stones.BaseStone;
import in.amal.rpg.gameofstones.view.util.MessagesUtils;
import in.amal.rpg.gameofstones.view.util.Randomizer;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Player extends BaseAvenger implements Serializable {

	private int level;
	private int status = -1; // 0 = Lost, 1 = Won
    private Gauntlet gauntlet;
    private List<Planet> exploredPlanets = new ArrayList<>();

	public Player(String name, Game game) {
		super(name, 75, 30, 100);
		this.level = 1;
		this.gauntlet = new Gauntlet();
		this.setGame(game);
	}

	public boolean addExperience(BaseCharacter villain) {
		boolean levelUp = (villain.getExp() / level) >= 100;
		if (levelUp) {
			attack += (level * 1.2);
			level++;
			exp = (villain.getExp() / level) * 2;
			baseLife *= 1.1;
			restoreLife();
		} else {
            exp+= (villain.getExp() / level);
        }
		return levelUp;
	}

	@Override
	public List<String> describe() {
		List<String> describe = new ArrayList<>(super.describe());
		describe.add(MessagesUtils.getText("game.character.level", level));
        describe.addAll(getGauntlet().describe());
		return describe;
	}

	public int getLevel() {
		return level;
	}

    public Gauntlet getGauntlet() {
        return gauntlet;
    }

    public void collectStones() {
	    for(BaseStone stone : ((BasePlanet)this.getGame().getCurrentPlanet()).getStones()) {
            this.getGauntlet().addStone(stone);
        }
	    this.exploredPlanets.add(this.getGame().getCurrentPlanet());
    }

    public Game getGame() {
        return game;
    }

    @Override
	public String toString() {
		return MessagesUtils.getText("game.setup.load.name") + " " + this.name + "  "
				+ MessagesUtils.getText("game.setup.load.level") + " " + +this.level;
	}

    public boolean isAllPlanetsExplored() {
        return Randomizer.allExplored(exploredPlanets);
    }

    public void set(String name, int attack, int exp, int baseLife) {
        this.name = name;
        this.attack = attack;
        this.exp = exp;
        this.baseLife = baseLife;
    }

    public void setStatus(int won) {
	    this.status = won;
    }

    public int getStatus() {
        return this.status;
    }
}