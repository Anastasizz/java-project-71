package hexlet.code.formatters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import hexlet.code.differ.DiffEntry;

import java.util.List;

public final class JsonFormatter implements DiffFormatter {
    @Override
    public String format(List<DiffEntry> diffEntries) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(diffEntries);
    }
}
