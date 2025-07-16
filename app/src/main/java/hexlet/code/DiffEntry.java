package hexlet.code;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class DiffEntry {
    private String key;
    private Object value1;
    private Object value2;
    private String operation;
}
