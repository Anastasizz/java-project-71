package hexlet.code.parser;

import java.util.Map;

public interface Parser {
    Map<String, Object> parse(String content) throws Exception;
}
