package hexlet.code;

import hexlet.code.differ.DiffGenerator;
import hexlet.code.parser.Parser;
import hexlet.code.parser.ParserFactory;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class Differ {
    public static String generate(String filePath1, String filePath2, String formatName) throws Exception {
        Path path1 = Paths.get(filePath1).toAbsolutePath().normalize();
        Path path2 = Paths.get(filePath2).toAbsolutePath().normalize();

        String content1 = Files.readString(path1);
        String content2 = Files.readString(path2);

        String extension1 = getExtension(path1);
        String extension2 = getExtension(path2);

        Parser parser1 = ParserFactory.create(extension1);
        Parser parser2 = ParserFactory.create(extension2);

        var map1 = parser1.parse(content1);
        var map2 = parser2.parse(content2);

        var formatter = Formatter.create(formatName);
        return formatter.format(DiffGenerator.generate(map1, map2));
    }

    public static String generate(String filePath1, String filePath2) throws Exception {
        return generate(filePath1, filePath2, "stylish");
    }

    private static String getExtension(Path path) {
        String fileName = path.getFileName().toString();
        int dotIndex = fileName.lastIndexOf('.');
        return (dotIndex == -1) ? "" : fileName.substring(dotIndex + 1);
    }
}



