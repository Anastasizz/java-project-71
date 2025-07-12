package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;


public class Differ {
    public static String generate(String filePath1, String filePath2) throws Exception {
        Path path1 = Paths.get(filePath1).toAbsolutePath().normalize();
        Path path2 = Paths.get(filePath2).toAbsolutePath().normalize();
        ObjectMapper mapper = new ObjectMapper();

        Map<String, Object> value1 = mapper.readValue(Files.readAllBytes(path1),
                                                      new TypeReference<HashMap<String, Object>>() { });
        Map<String, Object> value2 = mapper.readValue(Files.readAllBytes(path2),
                                                      new TypeReference<HashMap<String, Object>>() { });

        StringBuilder result = new StringBuilder();

        List<String> allKeys = new ArrayList<>(value1.keySet());
        for (var key : value2.keySet()) {
            if (!allKeys.contains(key)) {
                allKeys.add(key);
            }
        }

        result.append("{\n");
        for (var key : allKeys) {
            Object obj1 = value1.get(key);
            Object obj2 = value2.get(key);

            if (obj1 != null && obj2 == null) {
                result.append(" - ");
                result.append(key).append(": ").append(obj1);
                result.append("\n");
            } else if (obj1 == null && obj2 != null) {
                result.append(" + ");
                result.append(key).append(": ").append(obj2);
                result.append("\n");
            } else {
                if (obj1.equals(obj2)) {
                    result.append("   ");
                    result.append(key).append(": ").append(obj1);
                    result.append("\n");
                } else {
                    result.append(" - ");
                    result.append(key).append(": ").append(obj1);
                    result.append("\n");

                    result.append(" + ");
                    result.append(key).append(": ").append(obj2);
                    result.append("\n");
                }
            }
        }
        result.append("}\n");
        //System.out.println(result.toString());
        return result.toString();
    }
}



