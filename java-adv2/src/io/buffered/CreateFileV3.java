package io.buffered;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import static io.buffered.BufferedConst.BUFFER_SIZE;
import static io.buffered.BufferedConst.FILE_NAME;

public class CreateFileV3 {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream(FILE_NAME);
        BufferedOutputStream bos = new BufferedOutputStream(fos, BUFFER_SIZE);

        long start = System.currentTimeMillis();
        for (int i = 0; i < BufferedConst.FILE_SIZE; i++) {
            bos.write(1);
        }
        bos.close();
        long end = System.currentTimeMillis();

        System.out.println("File created " + FILE_NAME);
        System.out.println("File size " + BufferedConst.FILE_SIZE / 1024 / 1024 + "MB");
        System.out.println("Time taken " + (end - start) + "ms");
    }

}
