package hexlet.code.differ;

import hexlet.code.Formatter;
import hexlet.code.parser.Parser;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;


public class Differ {
    public static String generate(String filePath1, String filePath2, String formatName) throws Exception {
        var value1 = Parser.parse(filePath1);
        var value2 = Parser.parse(filePath2);
        var formatter = Formatter.create(formatName);

        List<String> allKeys = new ArrayList<>(value1.keySet());
        for (var key : value2.keySet()) {
            if (!allKeys.contains(key)) {
                allKeys.add(key);
            }
        }
        Collections.sort(allKeys);

        var diff = allKeys.stream()
                    .map(key -> {
                        Object obj1 = value1.get(key);
                        Object obj2 = value2.get(key);

                        if (!value1.containsKey(key)) {
                            return new DiffEntry(key, obj1, obj2, "added");
                        } else if (!value2.containsKey(key)) {
                            return new DiffEntry(key, obj1, obj2, "deleted");
                        } else if (Objects.equals(obj1, obj2)) {
                            return new DiffEntry(key, obj1, obj2, "unchanged");
                        } else {
                            return new DiffEntry(key, obj1, obj2, "changed");
                        }
                    })
                    .toList();

        return formatter.format(diff);
    }
}



