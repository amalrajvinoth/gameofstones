package in.amal.rpg.gameofstones.view.util;

import in.amal.rpg.gameofstones.model.ASCIIArt;

import java.io.IOException;
import java.io.InputStream;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.function.Predicate;

public class MessagesUtils {

    private static final Properties messages = new Properties();

    private static Predicate<Object> createPredicate(String prefix) {
        return new Predicate<Object>() {
            @Override
            public boolean test(Object t) {
                return t.toString().contains(prefix);
            }
        };
    }

    public static List<String> getAllByPrefix(String prefix) {
        List<String> output = new ArrayList<>();
        Predicate<Object> predicate = createPredicate(prefix);
        messages.keySet().stream().filter(predicate).forEach(key -> output.add(getText(key.toString())));
        return output;
    }

    public static String getText(String key) {
        return messages.getProperty(key);
    }

    public static String getText(String key, Object... params) {
        return MessageFormat.format(getText(key), params);
    }

    public static String load() {
        try {
            loadMessages();
            return messages.getProperty("messages.loaded.success");
        } catch (IOException e) {
            return "### Error while Loading Messages File ###\n" + e.getMessage();
        }
    }

    private static void loadMessages() throws IOException {
        InputStream input = MessagesUtils.class.getClassLoader()
                .getResourceAsStream("messages_EN.properties");
        messages.load(input);
        input.close();
    }

    private MessagesUtils() {
        super();
    }

    public static void drawAsciiArt(String key, Object ... args) {
        try {
            new ASCIIArt().printTextArt(MessagesUtils.getText(key, args), ASCIIArt.ART_SIZE_SMALL);
        } catch (Exception e) {
            System.out.println(getText("game.exit"));
        }
    }

    public static String getText(String text, Style style, Color color) {
        if(text == null || text.isEmpty()) {
            return "";
        }
        String textStyle = ";0m"+text;
        if(Style.BOLD == style) {
            textStyle = ";1m"+text;
        }
        return MessageFormat.format("\033[0m"+color.get(), textStyle);
    }

    public enum Style {
        NORMAL, BOLD
    }
    // https://stackoverflow.com/questions/5762491/how-to-print-color-in-console-using-system-out-println
    public enum Color {
        RED("\033[31{0}"),
        GREEN("\033[32{0}"),
        BLUE("\033[34{0}"),
        YELLOW("\033[33{0}"),
        PURPLE("\033[35{0}"),
        CYAN("\033[36{0}"),
        WHITE("\033[37{0}"),
        BLACK("\033[0{0}");

        private String ascii;
        Color(String ascii) {
            this.ascii = ascii;
        }

        public String get() {
            return this.ascii;
        }
    }

}
