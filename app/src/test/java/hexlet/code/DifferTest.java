package hexlet.code;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DifferTest {
    private static String resultStylish;
    private static String resultPlain;
    private static String resultJson;

    @BeforeAll
    static void init() throws Exception {
        resultStylish = readFixture("resultStylish.txt");
        resultPlain = readFixture("resultPlain.txt");
        resultJson = readFixture("resultJson.txt");
    }

    @ParameterizedTest
    @ValueSource(strings = {"json", "yaml"})
    public void generateTest(String format) throws Exception {
        String filePath1 = getFixturePath("input1." + format).toString();
        String filePath2 = getFixturePath("input2." + format).toString();

        String actualDefault = Differ.generate(filePath1, filePath2);
        String actualStylish = Differ.generate(filePath1, filePath2, "stylish");
        String actualPlain = Differ.generate(filePath1, filePath2, "plain");
        String actualJson = Differ.generate(filePath1, filePath2, "json");

        assertEquals(resultStylish, actualDefault,
                "\nExpected:\n" + resultStylish + "\n\nActual:\n" + actualDefault);
        assertEquals(resultStylish, actualStylish,
                "\nExpected:\n" + resultStylish + "\n\nActual:\n" + actualStylish);
        assertEquals(resultPlain, actualPlain,
                "\nExpected:\n" + resultPlain + "\n\nActual:\n" + actualPlain);
        assertEquals(resultJson, actualJson,
                "\nExpected:\n" + resultJson + "\n\nActual:\n" + actualJson);


    }

    private static Path getFixturePath(String fileName) {
        return Paths.get("src", "test", "resources", "fixtures", fileName)
                .toAbsolutePath().normalize();
    }

    private static String readFixture(String fileName) throws Exception {
        var path = getFixturePath(fileName);
        return Files.readString(path).trim();
    }
}
