package in.amal.rpg.gameofstones.model.avengers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import in.amal.rpg.gameofstones.model.BaseCharactor;
import in.amal.rpg.gameofstones.model.Game;
import in.amal.rpg.gameofstones.model.Gauntlet;
import in.amal.rpg.gameofstones.model.planets.BasePlanet;
import in.amal.rpg.gameofstones.model.stones.BaseStone;
import in.amal.rpg.gameofstones.view.util.MessagesUtils;

public class Player extends BaseAvenger implements Serializable {
	private static final long serialVersionUID = -7326505656159139166L;

	private int level;
    private Gauntlet gauntlet;

	public Player(String name, Game game) {
		super(name, 75, 30, 100);
		this.level = 1;
		this.gauntlet = new Gauntlet();
		this.setGame(game);
	}

	public boolean addExperience(BaseCharactor villain) {
		exp += (villain.getExp() / level);
		boolean levelUp = exp >= 100;
		if (levelUp) {
			attack += (level * 1.2);
			level++;
			exp = 0;
			baseLife *= 1.1;
			restoreLife();
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
    }

    public Game getGame() {
        return game;
    }

    @Override
	public String toString() {
		return MessagesUtils.getText("game.setup.load.name") + " " + this.name + "  "
				+ MessagesUtils.getText("game.setup.load.level") + " " + +this.level;
	}
}