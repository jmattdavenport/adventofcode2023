package dev.mdavenport.adventofcode2023.util;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Input {
    public static Stream<String> asLines(String filename) {
        try {
            URL file = Input.class.getClassLoader().getResource(filename);
            if (file == null) {
                throw new IllegalArgumentException(STR."File not found: \{ filename }");
            }
            return Files.lines(Paths.get(file.toURI()));
        } catch (IOException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}
