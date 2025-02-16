package io.buffered;

import java.io.FileInputStream;
import java.io.IOException;

import static io.buffered.BufferedConst.FILE_NAME;

public class ReadFileV1 {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream(FILE_NAME);

        long start = System.currentTimeMillis();

        int fileSize = 0;
        int data;
        while (fis.read() != -1) {
            fileSize++;
        }

        fis.close();
        long end = System.currentTimeMillis();

        System.out.println("File name " + FILE_NAME);
        System.out.println("File size " + fileSize / 1024 / 1024 + "MB");
        System.out.println("Time taken " + (end - start) + "ms");


    }

}
