package io.buffered;

import java.io.FileOutputStream;
import java.io.IOException;

import static io.buffered.BufferedConst.BUFFER_SIZE;
import static io.buffered.BufferedConst.FILE_NAME;
import static io.buffered.BufferedConst.FILE_SIZE;

public class CreateFileV2 {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream(FILE_NAME);

        byte[] buffer = new byte[BUFFER_SIZE];

        long start = System.currentTimeMillis();
        int bufferIndex = 0;

        for (int i = 0; i < FILE_SIZE; i++) {
            buffer[bufferIndex++] = 1;

            if (bufferIndex == BUFFER_SIZE) {
                fos.write(buffer);

            }
        }


        if (bufferIndex != 0) {
            fos.write(buffer);
        }

        long end = System.currentTimeMillis();

        System.out.println("File created " + FILE_NAME);
        System.out.println("File size " + BufferedConst.FILE_SIZE / 1024 / 1024 + "MB");
        System.out.println("Time taken " + (end - start) + "ms");
    }

}
