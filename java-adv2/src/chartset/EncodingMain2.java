package chartset;


import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class EncodingMain2 {

    private static final Charset EUC_KR = Charset.forName("EUC-KR");
    private static final Charset MS_949 = Charset.forName("MS949");

    public static void main(String[] args) {
        System.out.println("====== ASCII ENCODING ======");
        test("A", StandardCharsets.US_ASCII, StandardCharsets.US_ASCII);
        test("A", StandardCharsets.US_ASCII, StandardCharsets.ISO_8859_1);
        test("A", StandardCharsets.US_ASCII, EUC_KR);
        test("A", StandardCharsets.US_ASCII, MS_949);
        test("A", StandardCharsets.US_ASCII, StandardCharsets.UTF_8);
        test("A", StandardCharsets.US_ASCII, StandardCharsets.UTF_16);

        System.out.println("====== 한글 인코딩 ======");
        test("가", StandardCharsets.US_ASCII, StandardCharsets.US_ASCII);
        test("가", StandardCharsets.ISO_8859_1, StandardCharsets.ISO_8859_1);
        test("가", EUC_KR, EUC_KR);
        test("가", MS_949, MS_949);
        test("가", StandardCharsets.UTF_8, StandardCharsets.UTF_8);
        test("가", StandardCharsets.UTF_16, StandardCharsets.UTF_16);

        System.out.println("====== 한글 복잡한 글자 ======");
        test("쀍", EUC_KR, EUC_KR);
        test("가", StandardCharsets.UTF_8, StandardCharsets.UTF_8);
        test("가", StandardCharsets.UTF_16, StandardCharsets.UTF_16);

        System.out.println("====== 한글 인코딩 - 디코딩 다른 경우 ======");
        test("쀍", MS_949, EUC_KR);
        test("쀍", EUC_KR, MS_949);
        test("쀍", EUC_KR, StandardCharsets.UTF_8);
        test("쀍", MS_949, StandardCharsets.UTF_16);
    }

    private static void test(String test, Charset encoding, Charset decoding) {
        byte[] bytes = test.getBytes(encoding);

        String decoded = new String(bytes, decoding);
        System.out.printf("%s -> [%s] 인코딩 -> %s %sbyte -> [%s] 디코딩 -> %s \n", test, encoding, Arrays.toString(bytes), bytes.length, decoding, decoded);
    }
}
