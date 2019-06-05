package in.amal.rpg.gameofstones;

import in.amal.rpg.gameofstones.model.Storage;
import in.amal.rpg.gameofstones.view.BasicView;
import in.amal.rpg.gameofstones.view.util.MessagesUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertTrue;

public abstract class BaseTest {

    @BeforeClass
    public static void setupForClass() {
        MessagesUtils.load();
    }

    protected PrintStream originalOut;

    protected final ByteArrayOutputStream out = new ByteArrayOutputStream();

    protected void assertMessageIsPresent(String key) {
        assertTextIsPresent(MessagesUtils.getText(key));
    }

    protected void assertMessageIsPresent(String key, Object... params) {
        assertTextIsPresent(MessagesUtils.getText(key, params));
    }

    protected void assertTextIsPresent(String text) {
        assertTrue(this.out.toString().contains(text));
    }

    protected void deleteGames() {
        new Storage().deleteGames();
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Before
    public void setUpBeforeTest() {
        originalOut = System.out;
        this.out.reset();
        System.setOut(new PrintStream(this.out));
    }

    protected void setUserInput(byte[] bytes) {
        BasicView.changeDefaultInput(new ByteArrayInputStream(bytes));
    }

}