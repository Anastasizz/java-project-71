package hexlet.code.formatters;

import com.fasterxml.jackson.core.JsonProcessingException;
import hexlet.code.differ.DiffEntry;
import java.util.List;

public interface DiffFormatter {
    String format(List<DiffEntry> diffEntries) throws JsonProcessingException;
}
