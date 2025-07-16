package hexlet.code.formatter;

import hexlet.code.differ.DiffEntry;
import java.util.List;

public interface DiffFormatter {
    String format(List<DiffEntry> diffEntries);
}
