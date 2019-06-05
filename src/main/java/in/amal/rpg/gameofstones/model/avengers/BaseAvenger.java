package in.amal.rpg.gameofstones.model.avengers;

import in.amal.rpg.gameofstones.model.BaseCharactor;
import in.amal.rpg.gameofstones.model.Game;

public abstract class BaseAvenger extends BaseCharactor {

    protected Game game;

    public BaseAvenger(String name, int attack, int exp, int baseLife) {
        super(name, attack, exp, baseLife);
    }

    public void change(int attack, int exp, int life) {
        this.attack = attack;
        this.exp = exp;
        this.life = life;
    }

    public void setGame(Game game) {
        this.game = game;
    }
}