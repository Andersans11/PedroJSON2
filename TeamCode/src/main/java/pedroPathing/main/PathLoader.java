package pedroPathing.main;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import com.pedropathing.pathgen.PathChain;

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

        ArrayList<PathChain>[] paths;
        
        try {

            JsonNode rootNode = objectMapper.readTree(file);
            System.out.println("Successfully loaded JSON file!");


            System.out.println("Number of pathchains: " + rootNode.path("pathchains").size());
                
            for (int chainNumber = 1; chainNumber <= rootNode.path("pathchains").size(); chainNumber++) {


                System.out.println("Pathchain " + chainNumber + ":");
                
                System.out.println("  Number of paths: " + rootNode.path("pathchains").get(chainNumber - 1).path("paths").size());

                for (int pathNumber = 1; pathNumber <= rootNode.path("pathchains").get(chainNumber - 1).path("paths").size(); pathNumber++) {

                    
                    JsonNode pathNode = rootNode.path("pathchains").get(chainNumber - 1).path("paths").get(pathNumber - 1);

                    System.out.println("  Path " + pathNumber + ":");
                    System.out.println("    ID: " + pathNode.path("id").asText());
                    System.out.println("    Type: " + pathNode.path("type").asText());
                
                    System.out.println("    Start: (" + pathNode.path("start").path("x").asDouble() + ", " + pathNode.path("start").path("y").asDouble() + ")");
                    System.out.println("    End: (" + pathNode.path("end").path("x").asDouble() + ", " + pathNode.path("end").path("y").asDouble() + ")");

                    switch (pathNode.path("type").asText()) {
                        case "QUADRATIC":
                            System.out.println("    Control: (" + pathNode.path("control1").path("x").asDouble() + ", " + pathNode.path("control1").path("y").asDouble() + ")");
                            break;
                        case "CUBIC":
                            System.out.println("    Control1: (" + pathNode.path("control1").path("x").asDouble() + ", " + pathNode.path("control1").path("y").asDouble() + ")");
                            System.out.println("    Control2: (" + pathNode.path("control2").path("x").asDouble() + ", " + pathNode.path("control2").path("y").asDouble() + ")");
                            break;
                        case "LINEAR":
                            break;
                    }

                    System.out.println("    Interpolation: " + pathNode.path("interpolation").path("type").asText());
                    switch (pathNode.path("interpolation").path("type").asText()) {
                        case "CONSTANT":
                            System.out.println("      Heading: " + pathNode.path("interpolation").path("heading1").asDouble());
                            break;
                        case "LINEAR":
                            System.out.println("      Heading Start: " + pathNode.path("interpolation").path("heading1").asDouble());
                            System.out.println("      Heading End: " + pathNode.path("interpolation").path("heading2").asDouble());
                            break;
                        case "TANGENT":
                            break;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}