package hexlet.code;

import static org.junit.jupiter.api.Assertions.*;

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
    public void generateTest() {

    }
}
