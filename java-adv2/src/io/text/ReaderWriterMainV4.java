package io.text;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class ReaderWriterMainV4 {

    static final int BUFFER_SIZE = 8192;

    public static void main(String[] args) throws IOException {
        String writeString = "ABCD\n가나다";

        FileWriter fw = new FileWriter(TextConst.FILE_NAME, StandardCharsets.UTF_8);
        BufferedWriter bw = new BufferedWriter(fw, BUFFER_SIZE);
        bw.write(writeString);
        bw.close();

        FileReader fr = new FileReader(TextConst.FILE_NAME, StandardCharsets.UTF_8);
        BufferedReader br = new BufferedReader(fr, BUFFER_SIZE);

        String s;
        while ((s = br.readLine()) != null) {
            System.out.println(s);
        }
    }
}
