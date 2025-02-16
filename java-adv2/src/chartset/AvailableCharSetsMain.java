package chartset;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.SortedMap;

public class AvailableCharSetsMain {
    public static void main(String[] args) {
        SortedMap<String, Charset> charSets = Charset.availableCharsets();
        for (String s : charSets.keySet()) {
            System.out.println("charSet: " + s);
        }

        System.out.println("=========");
        //문자로 조회(대소 구분 X)
        Charset ms932 = Charset.forName("MS932");
        System.out.println("ms932: " + ms932);

        for (String alias : ms932.aliases()) {
            System.out.println("alias: " + alias);
        }

        Charset charset = Charset.forName("utf-8");
        System.out.println("charset: " + charset);

        for (String alias : charset.aliases()) {
            System.out.println("alias: " + alias);
        }

        Charset utf8 = StandardCharsets.UTF_8;
        System.out.println("utf8: " + utf8);

        Charset defaultSet = Charset.defaultCharset();
        System.out.println("defaultSet: " + defaultSet);

    }
}
