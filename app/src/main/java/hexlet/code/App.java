package hexlet.code;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;
import java.util.concurrent.Callable;


@Command(name = "gendiff", mixinStandardHelpOptions = true, version = "gendiff 1.0",
         description = "Compares two configuration files and shows a difference.")
public class App implements Callable<Integer> {
    @Option(names = {"-f", "--format"}, defaultValue = "stylish", description = "output format", paramLabel = "format")
    private String formatName;

    @Parameters(index = "0", description = "path to first file")
    private String filePath1;

    @Parameters(index = "1", description = "path to second file")
    private String filePath2;


    public Integer call() throws Exception {
        var diff = Differ.generate(filePath1, filePath2, formatName);
        System.out.println(diff);
        return 0;
    }

    public static void main(String[] args) throws Exception {
        //args = new String[] {"temp/file1.json", "temp/file2.json"};
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }
}
