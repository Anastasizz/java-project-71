package hexlet.code.formatters;

import hexlet.code.differ.DiffEntry;

import java.util.List;
import java.util.Map;


public class PlainFormatter implements DiffFormatter {
    @Override
    public String format(List<DiffEntry> diffEntries) {
        StringBuilder result = new StringBuilder();

        for (var diffEntry : diffEntries) {
            var key = diffEntry.getKey();
            var obj1 = diffEntry.getValue1();
            var obj2 = diffEntry.getValue2();
            var operation = diffEntry.getOperation();

            if (operation.equals("added")) {
                result.append(String.format("Property '%s' was added with value: %s\n", key, getFormatValue(obj2)));
            } else if (operation.equals("deleted")) {
                result.append(String.format("Property '%s' was removed\n", key));
            } else if (operation.equals("changed")) {
                result.append(String.format("Property '%s' was updated. From %s to %s\n", key,
                                             getFormatValue(obj1), getFormatValue(obj2)));
            }
        }

        if (!result.isEmpty()) {
            result.deleteCharAt(result.length() - 1);
        }

        return result.toString();
    }

    private String getFormatValue(Object object) {
        if (object instanceof Map || object instanceof List) {
            return "[complex value]";
        } else if (object instanceof String) {
            return "'" + object + "'";
        } else {
            return String.valueOf(object);
        }
    }
}
