package in.amal.rpg.gameofstones.model;

import in.amal.rpg.gameofstones.BaseTest;
import in.amal.rpg.gameofstones.view.util.MessagesUtils;
import org.junit.Test;

public class ASCIIArtTest extends BaseTest {

    @Test
    public void printLevelUpTest() {
        MessagesUtils.drawAsciiArt("game.level.up");
    }

    @Test
    public void printWakandaTest() {
        MessagesUtils.drawAsciiArt("game.name");
    }
}
