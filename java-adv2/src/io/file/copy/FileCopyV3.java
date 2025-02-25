package io.file.copy;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class FileCopyV3 {
    public static void main(String[] args) throws IOException {
        long startTime = System.currentTimeMillis();

        Path path = Path.of("temp/copy.dat");
        Path target = Path.of("temp/new_copy.dat");

        Files.copy(path, target, StandardCopyOption.REPLACE_EXISTING);

        long endTime = System.currentTimeMillis();
        System.out.println("File created in " + (endTime - startTime) + "ms");


    }
}
