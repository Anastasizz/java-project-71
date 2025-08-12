package hexlet.code;

import hexlet.code.formatters.DiffFormatter;
import hexlet.code.formatters.JsonFormatter;
import hexlet.code.formatters.PlainFormatter;
import hexlet.code.formatters.StylishFormatter;

public class Formatter {
    public static DiffFormatter create(String format) {
        return switch (format) {
            case "plain" -> new PlainFormatter();
            case "json" -> new JsonFormatter();
            default -> new StylishFormatter();
        };

    }
}
