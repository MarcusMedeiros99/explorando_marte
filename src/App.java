import java.net.ServerSocket;
import java.net.http.WebSocket;

import controller.InputReader;
import controller.web.HttpServerWrapper;
import navigation.Environment;
import view.OutputWriter;

public class App {
    public static void main(String[] args) throws Exception {
        Environment environment = InputReader.parseFile(args[0]);
        // OutputWriter.writeOutput(environment);


    }
}
