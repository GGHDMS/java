package io.buffered;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

import static io.buffered.BufferedConst.FILE_NAME;

public class ReadFileV3 {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream(FILE_NAME);
        BufferedInputStream bis = new BufferedInputStream(fis);

        long start = System.currentTimeMillis();

        int fileSize = 0;
        while (bis.read() != -1) {
            fileSize++;
        }
        bis.close();
        long end = System.currentTimeMillis();

        System.out.println("File name " + FILE_NAME);
        System.out.println("File size " + fileSize / 1024 / 1024 + "MB");
        System.out.println("Time taken " + (end - start) + "ms");


    }

}
