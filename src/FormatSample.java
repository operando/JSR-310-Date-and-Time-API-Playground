import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;

public class FormatSample {

    public static void run() {
        System.out.println("==============FormatSample==============");

        // DateTimeFormatterBuilder#parseFieldあたりの実装みるとparseの感じがわかる
        // 仕様はhttps://docs.oracle.com/javase/jp/8/docs/api/java/time/format/DateTimeFormatterBuilder.html#appendPattern-java.lang.String- を見るとよい
        System.out.println(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy M dd ", Locale.ENGLISH)));
        System.out.println(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy MM dd ", Locale.ENGLISH)));

        // TextStyle.SHORT_STANDALONE
        System.out.println(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy MMM dd ", Locale.ENGLISH)));

        // TextStyle.FULL_STANDALONE
        System.out.println(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy MMMM dd ", Locale.ENGLISH)));

        // TextStyle.NARROW_STANDALONE
        System.out.println(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy MMMMM dd ", Locale.ENGLISH)));

        System.out.println(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy M dd ", Locale.JAPANESE)));// 12
        System.out.println(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy MM dd ", Locale.JAPANESE)));// 12
        System.out.println(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy MMM dd ", Locale.JAPANESE)));// 12
        System.out.println(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy MMMM dd ", Locale.JAPANESE)));// 12月. 月がつく
        System.out.println(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy MMMMM dd ", Locale.JAPANESE))); // 12
    }
}