package hexlet.code;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;


public class Differ {
    public static String generate(String filePath1, String filePath2) throws Exception {
        var value1 = Parser.parse(filePath1);
        var value2 = Parser.parse(filePath2);

        StringBuilder result = new StringBuilder();

        List<String> allKeys = new ArrayList<>(value1.keySet());
        for (var key : value2.keySet()) {
            if (!allKeys.contains(key)) {
                allKeys.add(key);
            }
        }
        Collections.sort(allKeys);

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
        result.append("}");
        //System.out.println(result.toString());
        return result.toString();
    }
}



