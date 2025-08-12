package hexlet.code.parser;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.Map;

public class JsonParser implements Parser {
    private final ObjectMapper mapper = new ObjectMapper();
    @Override
    public Map<String, Object> parse(String content) throws Exception {
        return mapper.readValue(content, new TypeReference<HashMap<String, Object>>() { });
    }
}
