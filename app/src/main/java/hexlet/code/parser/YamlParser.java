package hexlet.code.parser;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.util.HashMap;
import java.util.Map;

public class YamlParser implements Parser {
    private final ObjectMapper mapper = new YAMLMapper();

    @Override
    public Map<String, Object> parse(String content) throws Exception {
        return mapper.readValue(content, new TypeReference<HashMap<String, Object>>() { });
    }
}
