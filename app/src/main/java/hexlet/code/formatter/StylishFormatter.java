package hexlet.code.formatter;

import hexlet.code.differ.DiffEntry;

import java.util.List;

public class StylishFormatter implements DiffFormatter {
    @Override
    public String format(List<DiffEntry> diffEntries) {
        StringBuilder result = new StringBuilder();
        result.append("{\n");
        for (var entry : diffEntries) {
            var operation = entry.getOperation();
            var key = entry.getKey();
            var obj1 = entry.getValue1();
            var obj2 = entry.getValue2();

            if (operation.equals("added")) {
                result.append(" + ");
                result.append(key).append(": ").append(obj2);
                result.append("\n");
            } else if (operation.equals("deleted")) {
                result.append(" - ");
                result.append(key).append(": ").append(obj1);
                result.append("\n");
            } else if (operation.equals("changed")) {
                result.append(" - ");
                result.append(key).append(": ").append(obj1);
                result.append("\n");

                result.append(" + ");
                result.append(key).append(": ").append(obj2);
                result.append("\n");
            } else if (operation.equals("unchanged")) {
                result.append("   ");
                result.append(key).append(": ").append(obj1);
                result.append("\n");
            }
        }
        result.append("}");
        return result.toString();
    }
}
