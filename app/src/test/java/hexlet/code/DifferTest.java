package hexlet.code;

import static org.junit.jupiter.api.Assertions.assertEquals;

import hexlet.code.differ.Differ;
import hexlet.code.formatter.FormatFactory;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DifferTest {

    private static Path getFixturePath(String fileName) {
        return Paths.get("src", "test", "resources", "fixtures", fileName)
                .toAbsolutePath().normalize();
    }

    private static String readFixture(String fileName) throws Exception {
        var path = getFixturePath(fileName);
        return Files.readString(path).trim();
    }

    private void check(String caseName, String extension, String format) throws Exception {
        String expected = readFixture(caseName + "/expected.txt");
        String input1Path = getFixturePath(caseName + "/input1." + extension).toString();
        String input2Path = getFixturePath(caseName + "/input2." + extension).toString();
        var diff = Differ.generate(input1Path, input2Path);
        var formater = FormatFactory.create(format);
        var actual = formater.format(diff);
        assertEquals(expected, actual,
                "\nExpected:\n" + expected
                        + "\n\nActual:\n" + actual);
    }

    @Test
    public void addKeyJson() throws Exception {
        check("addKey", "json", "stylish");
    }
    @Test
    public void addKeyYaml() throws Exception {
        check("addKey", "yaml", "stylish");
    }
    @Test
    public void changeKeyJson() throws Exception {
        check("changeKey", "json", "stylish");
    }
    @Test
    public void changeKeyYaml() throws Exception {
        check("changeKey", "yaml", "stylish");
    }
    @Test
    public void deleteKeyJson() throws Exception {
        check("deleteKey", "json", "stylish");
    }
    @Test
    public void deleteKeyYaml() throws Exception {
        check("deleteKey", "yaml", "stylish");
    }
    @Test
    public void sameKeyJson() throws Exception {
        check("sameKey", "json", "stylish");
    }
    @Test
    public void sameKeyYaml() throws Exception {
        check("sameKey", "yaml", "stylish");
    }
    @Test
    public void combCaseJson() throws Exception {
        check("combCase", "json", "stylish");
    }
    @Test
    public void combCaseYaml() throws Exception {
        check("combCase", "yaml", "stylish");
    }
}
