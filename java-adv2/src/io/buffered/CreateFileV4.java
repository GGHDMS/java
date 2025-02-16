package io.buffered;

import java.io.FileOutputStream;
import java.io.IOException;

import static io.buffered.BufferedConst.FILE_NAME;
import static io.buffered.BufferedConst.FILE_SIZE;

public class CreateFileV4 {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream(FILE_NAME);

        byte[] bytes = new byte[FILE_SIZE];
        long start = System.currentTimeMillis();
        for (int i = 0; i < BufferedConst.FILE_SIZE; i++) {
            bytes[i] = 1;
        }

        fos.write(bytes);
        fos.close();
        long end = System.currentTimeMillis();

        System.out.println("File created " + FILE_NAME);
        System.out.println("File size " + BufferedConst.FILE_SIZE / 1024 / 1024 + "MB");
        System.out.println("Time taken " + (end - start) + "ms");
    }

}
