package in.amal.rpg.gameofstones.controller.commands.executors;

import in.amal.rpg.gameofstones.controller.commands.Command;
import in.amal.rpg.gameofstones.controller.commands.Commands;
import in.amal.rpg.gameofstones.model.BaseCharacter;
import in.amal.rpg.gameofstones.model.Game;
import in.amal.rpg.gameofstones.model.avengers.Player;
import in.amal.rpg.gameofstones.model.villains.BaseVillain;
import in.amal.rpg.gameofstones.view.BasicView;
import in.amal.rpg.gameofstones.view.util.MessagesUtils;

import java.util.Random;

public class AcquireStoneCommand implements Command {
    private Random random = new Random();

    private void attack(BaseCharacter attacker, BaseCharacter defender, BasicView view) {
        boolean attackBlocked = random.nextBoolean();
        if (attackBlocked) {
            view.printMessage("game.command.acquire.stone.attack.blocked", attacker.getName());
        } else {
            defender.attacked(attacker);
            view.printMessage("game.command.acquire.stone.attack.hit", defender.getName(), attacker.getAttack(),
                    defender.getLife());
        }
    }

    private void computeExperience(Player player, BaseCharacter villain, BasicView view) {
        boolean levelUp = player.addExperience(villain);
        if (levelUp) {
            if(player.getGame().getCurrentPlanet().isStoneExist()) {
                player.collectStones();
            }
            if(player.getGame().getPlayer().getGauntlet().isAllStonesCollected()) {
                view.printMessage("game.command.acquire.stone.win", villain.getExp(), player.getExp(), player.getLife());
                view.printMessage("game.winning.message", villain.getExp(), player.getExp(), player.getLife());
                return;
            }
            MessagesUtils.drawAsciiArt("game.level.up", player.getLevel());
            view.printText(player.describe());
        } else {
            view.printMessage("game.command.acquire.stone.win", villain.getExp(), player.getExp(), player.getLife());
        }
    }

    @Override
    public void execute(Game game, BasicView view) {
        BaseVillain villain = game.getCurrentPlanet().getVillain();
        Player player = game.getPlayer();
        view.printMessage("game.command.acquire.stone");
        view.printText(villain.describe());
        view.printMessage("game.command.protect.start");
        BaseCharacter winner = fight(player, villain, view);
        view.printMessage("game.command.protect.end");
        if (winner instanceof Player) {
            computeExperience(player, villain, view);
            player.setStatus(1);
        } else {
            player.setStatus(0);
            exitGame(game, view);
        }
        villain.restoreLife();
    }

    private void exitGame(Game game, BasicView view) {
        view.printMessage("game.command.acquire.stone.exit");
        Commands.EXIT.getExecuter().execute(game, view);
    }

    private BaseCharacter fight(BaseCharacter player, BaseCharacter villain, BasicView view) {
        while (villain.isAlive() && player.isAlive()) {
            attack(player, villain, view);
            attack(villain, player, view);
        }
        return player.isAlive() ? player : villain;
    }

}
