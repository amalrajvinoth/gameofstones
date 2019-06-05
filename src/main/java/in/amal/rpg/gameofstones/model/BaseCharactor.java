package in.amal.rpg.gameofstones.model;

import in.amal.rpg.gameofstones.view.util.MessagesUtils;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public abstract class BaseCharactor implements Serializable {
    private static final long serialVersionUID = -5407283321466867599L;

    protected int attack;
    protected int baseLife;
    protected int exp;
    protected int life;
    protected String name;

    public BaseCharactor(String name, int attack, int exp, int baseLife) {
        super();
        this.attack = attack;
        this.exp = exp;
        this.baseLife = baseLife;
        this.life = this.baseLife;
        this.name = name;
    }

    public void attacked(BaseCharactor attacker) {
        this.life -= attacker.getAttack();
        if (life < 0) {
            this.life = 0;
        }
    }

    public List<String> describe() {
        return Arrays.asList(MessagesUtils.getText("game.character.desc",name,attack, life, exp));
    }

    public int getAttack() {
        return attack;
    }

    public int getExp() {
        return exp;
    }

    public int getLife() {
        return life;
    }

    public String getName() {
        return name;
    }

    public boolean isAlive() {
        return life > 0;
    }

    public void restoreLife() {
        life = baseLife;
    }

    @Override
    public String toString() {
        return name;
    }
}