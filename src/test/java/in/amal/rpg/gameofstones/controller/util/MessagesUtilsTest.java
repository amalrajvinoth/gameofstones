package in.amal.rpg.gameofstones.controller.util;

import in.amal.rpg.gameofstones.controller.commands.Commands;
import in.amal.rpg.gameofstones.view.util.MessagesUtils;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class MessagesUtilsTest {

    private void loadMessagesEn() {
        MessagesUtils.load();
    }

    @Test
    public void loadMessagesEnTest() {
        String message = MessagesUtils.load();
        assertEquals(message, "Messages loaded with success");
    }


    @Test
    public void messagesRecoveryByPrefixTest() {
        loadMessagesEn();
        List<String> messages = MessagesUtils.getAllByPrefix("game.command.list.commands.describe");
        assertEquals(messages.size(), Commands.values().length);
    }

    @Test
    public void messagesRecoveryTest() {
        loadMessagesEn();
        String message = MessagesUtils.getText("service.storage.save.success");
        assertEquals(message, "Game saved with success");
    }

    @Test
    public void messagesRecoveryWithParamsTest() {
        loadMessagesEn();
        String message = MessagesUtils.getText("game.setup.new.start", "Cristiano Passos");
        assertEquals(message, "Staring now Cristiano Passos!");
    }
}