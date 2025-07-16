package hexlet.code;

import static org.junit.jupiter.api.Assertions.assertEquals;

import hexlet.code.differ.Differ;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class DifferTest {
    private static List<String> extensions = new ArrayList<>();
    private static List<String> formats = new ArrayList<>();

    @BeforeAll
    public static void init() {
        extensions.addAll(List.of("json", "yaml"));
        formats.addAll(List.of("stylish", "plain"));
    }

    private static Path getFixturePath(String fileName) {
        return Paths.get("src", "test", "resources", "fixtures", fileName)
                .toAbsolutePath().normalize();
    }

    private static String readFixture(String fileName) throws Exception {
        var path = getFixturePath(fileName);
        return Files.readString(path).trim();
    }

    private void check(String caseName, String extension, String formatName) throws Exception {
        String expected = readFixture(caseName + "/expected_" + formatName + ".txt");
        String input1Path = getFixturePath(caseName + "/input1." + extension).toString();
        String input2Path = getFixturePath(caseName + "/input2." + extension).toString();
        var actual = Differ.generate(input1Path, input2Path, formatName);
        assertEquals(expected, actual,
                        "\nExtension: " + extension
                        + "\nFormat: " + formatName + "\n");
//                        + "\nExpected:\n" + expected
//                        + "\n\nActual:\n" + actual);
    }

    @Test
    public void addKey() throws Exception {
        for (var extension : extensions) {
            for (var format : formats) {
                check("addKey", extension, format);
            }
        }
    }

    @Test
    public void changeKey() throws Exception {
        for (var extension : extensions) {
            for (var format : formats) {
                check("changeKey", extension, format);
            }
        }
    }

    @Test
    public void deleteKey() throws Exception {
        for (var extension : extensions) {
            for (var format : formats) {
                check("deleteKey", extension, format);
            }
        }
    }

    @Test
    public void sameKey() throws Exception {
        for (var extension : extensions) {
            for (var format : formats) {
                check("sameKey", extension, format);
            }
        }
    }

    @Test
    public void combCase() throws Exception {
        for (var extension : extensions) {
            for (var format : formats) {
                check("combCase", extension, format);
            }
        }
    }
}
