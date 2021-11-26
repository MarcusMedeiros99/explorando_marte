import controller.InputReader;
import navigation.Environment;
import view.OutputWriter;

public class App {
    public static void main(String[] args) throws Exception {
        Environment environment = InputReader.parseFile(args[0]);
        OutputWriter.writeOutput(environment);
    }
}
