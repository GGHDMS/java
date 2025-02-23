package io.text;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class ReaderWriterMainV3 {
    public static void main(String[] args) throws IOException {
        String writeString = "ABCD";

        FileWriter fw = new FileWriter(TextConst.FILE_NAME, StandardCharsets.UTF_8);
        fw.write(writeString);
        fw.close();

        FileReader fr = new FileReader(TextConst.FILE_NAME, StandardCharsets.UTF_8);

        int ch;
        StringBuilder sb = new StringBuilder();
        while ((ch = fr.read()) != -1) {
            sb.append((char) ch);
        }
        System.out.println("read : " + sb);
    }
}
