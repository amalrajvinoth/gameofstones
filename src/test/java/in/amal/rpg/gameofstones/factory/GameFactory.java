package in.amal.rpg.gameofstones.factory;

import in.amal.rpg.gameofstones.model.Game;
import in.amal.rpg.gameofstones.model.planets.Earth;

import java.util.UUID;

public class GameFactory {

    public static Game createNewGame() {
        Game newGame = new Game(UUID.randomUUID().toString());
        return newGame;
    }

    public static Game createNewGameLastPlanet() {
        Game newGame = new Game(UUID.randomUUID().toString());
        newGame.setCurrentPlanet(new Earth());
        return newGame;
    }
}
