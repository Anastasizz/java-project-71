package hexlet.code.differ;

import java.util.Comparator;
import java.util.Objects;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class DiffGenerator {
    public static List<DiffEntry> generate(Map<String, Object> map1,
                                           Map<String, Object> map2) {
        Set<String> allKeys = new TreeSet<>(Comparator.naturalOrder());
        allKeys.addAll(map1.keySet());
        allKeys.addAll(map2.keySet());

        return allKeys.stream()
                .map(key -> {
                    Object obj1 = map1.get(key);
                    Object obj2 = map2.get(key);

                    if (!map1.containsKey(key)) {
                        return new DiffEntry(key, obj1, obj2, "added");
                    } else if (!map2.containsKey(key)) {
                        return new DiffEntry(key, obj1, obj2, "deleted");
                    } else if (Objects.equals(obj1, obj2)) {
                        return new DiffEntry(key, obj1, obj2, "unchanged");
                    } else {
                        return new DiffEntry(key, obj1, obj2, "changed");
                    }
                })
                .toList();
    }
}
