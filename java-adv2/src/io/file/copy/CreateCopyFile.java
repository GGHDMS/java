package io.file.copy;

import java.io.FileOutputStream;
import java.io.IOException;

public class CreateCopyFile {
    private static final int FILE_SIZE = 1024 * 1024 * 200;

    public static void main(String[] args) throws IOException {
        String filName = "temp/copy.dat";

        long startTime = System.currentTimeMillis();

        FileOutputStream fos = new FileOutputStream(filName);
        byte[] bytes = new byte[FILE_SIZE];

        fos.write(bytes);
        fos.close();

        long endTime = System.currentTimeMillis();
        System.out.println("File created in " + (endTime - startTime) + "ms");
    }

}
