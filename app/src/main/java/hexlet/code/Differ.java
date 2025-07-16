package hexlet.code;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;


public class Differ {
    public static List<DiffEntry> generate(String filePath1, String filePath2) throws Exception {
        List<DiffEntry> diffEntries = new ArrayList<>();

        var value1 = Parser.parse(filePath1);
        var value2 = Parser.parse(filePath2);

        List<String> allKeys = new ArrayList<>(value1.keySet());
        for (var key : value2.keySet()) {
            if (!allKeys.contains(key)) {
                allKeys.add(key);
            }
        }
        Collections.sort(allKeys);

        for (var key : allKeys) {
            Object obj1 = value1.get(key);
            Object obj2 = value2.get(key);

            if (obj1 != null && obj2 == null) {
                diffEntries.add(new DiffEntry(key, obj1, obj2, "deleted"));
            } else if (obj1 == null && obj2 != null) {
                diffEntries.add(new DiffEntry(key, obj1, obj2, "added"));
            } else {
                if (obj1.equals(obj2)) {
                    diffEntries.add(new DiffEntry(key, obj1, obj2, "unchanged"));
                } else {
                    diffEntries.add(new DiffEntry(key, obj1, obj2, "changed"));
                }
            }
        }
        return diffEntries;
    }
}



