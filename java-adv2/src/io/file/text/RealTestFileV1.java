package io.file.text;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class RealTestFileV1 {

    private final static String PATH = "temp/hello2.txt";

    public static void main(String[] args) throws IOException {
        String writstring = "abc\n가나다";

        Path path = Path.of(PATH);

        Files.writeString(path, writstring, StandardCharsets.UTF_8);

        String readString = Files.readString(path, StandardCharsets.UTF_8);

        System.out.println(readString);
    }
}
