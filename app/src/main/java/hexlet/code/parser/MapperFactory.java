package hexlet.code.parser;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

public class MapperFactory {
    public static ObjectMapper create(String filePath) {
        if (filePath.endsWith(".yaml") || filePath.endsWith(".yml")) {
            return new YAMLMapper();
        }
        return new ObjectMapper();
    }
}
