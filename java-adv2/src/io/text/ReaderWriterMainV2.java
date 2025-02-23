package io.text;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

public class ReaderWriterMainV2 {
    public static void main(String[] args) throws IOException {
        String writeString = "ABC";
        FileOutputStream fos = new FileOutputStream(TextConst.FILE_NAME);
        OutputStreamWriter osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8);

        osw.write(writeString);
        osw.close();

        FileInputStream fis = new FileInputStream(TextConst.FILE_NAME);
        InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);

        int ch;
        StringBuilder sb = new StringBuilder();
        while ((ch = isr.read()) != -1) {
            sb.append((char) ch);
        }

        System.out.println("read : " + sb);
    }
}
