package hexlet.code;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DifferTest {

    private static String json1;
    private static String json2;

    @BeforeAll
    public static void beforeAll() throws Exception {
        json1 = readFixture("file1.json");
        json2 = readFixture("file2.json");
    }

    private static Path getFixturePath(String fileName) {
        return Paths.get("src", "test", "resources", "fixtures", fileName)
                .toAbsolutePath().normalize();
    }

    private static String readFixture(String fileName) throws Exception {
        var path = getFixturePath(fileName);
        return Files.readString(path).trim();
    }


    @Test
    public void changeKeyJson() throws Exception {
        String expected = readFixture("changeKey/expected.txt");
        String input1Path = getFixturePath("changeKey/input1.json").toString();
        String input2Path = getFixturePath("changeKey/input2.json").toString();
        String actual = Differ.generate(input1Path, input2Path);
        assertEquals(expected, actual);
    }
    @Test
    public void changeKeyYaml() throws Exception {
        String expected = readFixture("changeKey/expected.txt");
        String input1Path = getFixturePath("changeKey/input1.yaml").toString();
        String input2Path = getFixturePath("changeKey/input2.yaml").toString();
        String actual = Differ.generate(input1Path, input2Path);
        assertEquals(expected, actual);
    }
    @Test
    public void deleteKeyJson() throws Exception {
        String expected = readFixture("deleteKey/expected.txt");
        String input1Path = getFixturePath("deleteKey/input1.json").toString();
        String input2Path = getFixturePath("deleteKey/input2.json").toString();
        String actual = Differ.generate(input1Path, input2Path);
        assertEquals(expected, actual);
    }
    @Test
    public void deleteKeyYaml() throws Exception {
        String expected = readFixture("deleteKey/expected.txt");
        String input1Path = getFixturePath("deleteKey/input1.yaml").toString();
        String input2Path = getFixturePath("deleteKey/input2.yaml").toString();
        String actual = Differ.generate(input1Path, input2Path);
        assertEquals(expected, actual);
    }
    @Test
    public void sameKeyJson() throws Exception {
        String expected = readFixture("sameKey/expected.txt");
        String input1Path = getFixturePath("sameKey/input1.json").toString();
        String input2Path = getFixturePath("sameKey/input2.json").toString();
        String actual = Differ.generate(input1Path, input2Path);
        assertEquals(expected, actual);
    }
    @Test
    public void sameKeyYaml() throws Exception {
        String expected = readFixture("sameKey/expected.txt");
        String input1Path = getFixturePath("sameKey/input1.yaml").toString();
        String input2Path = getFixturePath("sameKey/input2.yaml").toString();
        String actual = Differ.generate(input1Path, input2Path);
        assertEquals(expected, actual);
    }
    @Test
    public void combCaseJson() throws Exception {
        String expected = readFixture("combCase/expected.txt");
        String input1Path = getFixturePath("combCase/input1.json").toString();
        String input2Path = getFixturePath("combCase/input2.json").toString();
        String actual = Differ.generate(input1Path, input2Path);
        assertEquals(expected, actual);
    }
    @Test
    public void combCaseYaml() throws Exception {
        String expected = readFixture("combCase/expected.txt");
        String input1Path = getFixturePath("combCase/input1.yaml").toString();
        String input2Path = getFixturePath("combCase/input2.yaml").toString();
        String actual = Differ.generate(input1Path, input2Path);
        assertEquals(expected, actual);
    }
}
