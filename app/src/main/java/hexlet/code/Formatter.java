package hexlet.code;

import hexlet.code.formatters.DiffFormatter;
import hexlet.code.formatters.JsonFormatter;
import hexlet.code.formatters.PlainFormatter;
import hexlet.code.formatters.StylishFormatter;

public class Formatter {
    public static DiffFormatter create(String format) {
        if (format.equals("stylish")) {
            return new StylishFormatter();
        } else if (format.equals("plain")) {
            return new PlainFormatter();
        } else if (format.equals("json")) {
            return new JsonFormatter();
        }

        return new StylishFormatter();
    }
}
