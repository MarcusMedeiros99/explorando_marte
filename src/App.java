import controller.InputReader;
import controller.OutputWriter;
import navigation.Environment;

public class App {
    public static void main(String[] args) throws Exception {
        Environment environment = InputReader.parseFile(args[0]);
        OutputWriter.writeOutput(environment);
    }
}
