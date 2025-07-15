package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class Parser {
    public static Map<String, Object> parse(String filePath) throws Exception {
        Path path1 = Paths.get(filePath).toAbsolutePath().normalize();
        ObjectMapper mapper = MapperFactory.create(filePath);

        return mapper.readValue(Files.readAllBytes(path1),
                                 new TypeReference<HashMap<String, Object>>() { });
    }
}
