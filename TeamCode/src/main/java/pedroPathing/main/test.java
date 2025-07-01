package pedroPathing.main;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class test {
    public static void main(String[] args) throws IOException {
        File file = new File("paths\\path_ex.json");
        PathLoader pathLoader = new PathLoader(file);

        pathLoader.Parse();
    }
}
