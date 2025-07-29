package hexlet.code.formatters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import hexlet.code.differ.DiffEntry;

import java.util.List;
import java.util.stream.Collectors;

public class JsonFormatter implements DiffFormatter {
    @Override
    public String format(List<DiffEntry> diffEntries) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        return diffEntries.stream()
                .map(entry -> {
                    try {
                        return objectMapper.writeValueAsString(entry);
                    } catch (JsonProcessingException e) {
                        throw new RuntimeException(e);
                    }
                })
                .collect(Collectors.joining(",\n", "[\n", "\n]"));
    }
}
