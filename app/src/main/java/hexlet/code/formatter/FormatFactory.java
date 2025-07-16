package hexlet.code.formatter;

public class FormatFactory {
    public static DiffFormatter create(String format) {
        if (format.equals("stylish")) {
            return new StylishFormatter();
        }

        return new StylishFormatter();
    }
}
