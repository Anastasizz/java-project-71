package hexlet.code.parser;

public class ParserFactory {
    public static Parser create(String format) {
        switch (format.toLowerCase()) {
            case "yaml", "yml":
                return new YamlParser();
            case "json":
                return new JsonParser();
            default:
                throw new IllegalArgumentException("Unsupported format: " + format);

        }
    }
}
