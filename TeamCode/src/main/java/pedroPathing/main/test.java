package pedroPathing.main;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class test {
    public static void main(String[] args) {
        // Try different possible paths for the JSON file
        String[] possiblePaths = {
            "TeamCode\\src\\main\\java\\pedroPathing\\data\\path_ex.json",
            "src\\main\\java\\pedroPathing\\data\\path_ex.json",
            "..\\..\\data\\path_ex.json",
            "data\\path_ex.json"
        };
        
        File file = null;
        for (String path : possiblePaths) {
            File testFile = new File(path);
            System.out.println("Trying path: " + testFile.getAbsolutePath());
            if (testFile.exists()) {
                file = testFile;
                System.out.println("Found file at: " + path);
                break;
            }
        }
        
        if (file == null) {
            System.out.println("Could not find path_ex.json file!");
            return;
        }
        
        PathLoader pathLoader = new PathLoader(file);

        pathLoader.Parse();
    }
}
