package hexlet.code;

public class FormatFactory {
    public static Formater create(String format) {
        Formater formater = null;
        if (format.equals("stylish")) {
            formater = new FormaterStylish();
        }
        return formater;
    }
}
