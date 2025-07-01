package pedroPathing.main;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class PathLoader {

    File file;

    public PathLoader(File file) {
        this.file = file;
    }

    public PathLoader(String filePath) {
        this.file = new File(filePath);
    }

    public void Parse() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            JsonNode rootNode = objectMapper.readTree(file);

            for (int pathNumber = 1; pathNumber <= rootNode.path("paths").size(); pathNumber++) {
                JsonNode pathNode = rootNode.path("paths").get(pathNumber - 1);
                System.out.println(pathNode.path("name").asText());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}