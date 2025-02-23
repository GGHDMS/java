package io.text;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class ReaderWriterMainV1 {
    public static void main(String[] args) throws IOException {
        String writeString = "ABC";

        byte[] writeBytes = writeString.getBytes(StandardCharsets.UTF_8);

        FileOutputStream fos = new FileOutputStream(TextConst.FILE_NAME);
        fos.write(writeBytes);
        fos.close();

        FileInputStream fis = new FileInputStream(TextConst.FILE_NAME);
        byte[] readBytes = fis.readAllBytes();
        fis.close();

        String readString = new String(readBytes, StandardCharsets.UTF_8);
        System.out.println(readString);


    }
}
