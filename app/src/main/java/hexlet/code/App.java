package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.concurrent.Callable;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Command(name = "gendiff", mixinStandardHelpOptions = true, version = "gendiff 1.0",
         description = "Compares two configuration files and shows a difference.")
public class App implements Callable<Integer> {
    @Option(names = {"-f", "--format"}, description = "output format", paramLabel = "format")
    private String format = "stylish";

    @Parameters(index = "0", description = "path to first file")
    private String filePath1;

    @Parameters(index = "1", description = "path to second file")
    private String filePath2;


    public Integer call() throws Exception {
        Path path1 = Paths.get(filePath1).toAbsolutePath().normalize();
        Path path2 = Paths.get(filePath2).toAbsolutePath().normalize();

        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> value1 = mapper.readValue(Files.readAllBytes(path1), new TypeReference<Map<String,Object>>(){});
        printMap(value1);
        Map<String, Object> value2 = mapper.readValue(Files.readAllBytes(path2), new TypeReference<Map<String,Object>>(){});
        printMap(value2);

        return 0;
    }

    public void printMap(Map<String, Object> map) {
        System.out.println("{");
        map.forEach((key, value) -> {
            System.out.println("  \"" + key + "\": " + value);
        });
        System.out.println("}");
    }

    public static void main(String[] args) throws Exception{
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);

    }
}