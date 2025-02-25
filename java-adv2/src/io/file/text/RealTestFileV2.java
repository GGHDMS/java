package io.file.text;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class RealTestFileV2 {

    private final static String PATH = "temp/hello2.txt";

    public static void main(String[] args) throws IOException {
        String writstring = "abc\n가나다";

        Path path = Path.of(PATH);

        Files.writeString(path, writstring, StandardCharsets.UTF_8);

        List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
        for (String line : lines) {
            System.out.println(line);
        }

        Files.lines(path, StandardCharsets.UTF_8).forEach(System.out::println);
    }
}
