import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.SignStyle;
import java.util.Calendar;
import java.util.Date;

import static java.time.temporal.ChronoField.HOUR_OF_DAY;
import static java.time.temporal.ChronoField.YEAR;

public class Main {

    public static final DateTimeFormatter SAMPLE_DATE_TIME;

    public static final DateTimeFormatter OPTIONAL_START_SAMPLE_FORMAT;

    static {
        OPTIONAL_START_SAMPLE_FORMAT = new DateTimeFormatterBuilder()
                .appendValue(YEAR, 4, 10, SignStyle.EXCEEDS_PAD)
                .appendLiteral("年")
                .optionalStart() // オプションのセクションの開始(あれば出るって感じ)
                .appendLiteral(' ')
                .appendValue(HOUR_OF_DAY, 2)
                .appendLiteral("時")
                .toFormatter();


        SAMPLE_DATE_TIME = new DateTimeFormatterBuilder()
                .append(DateTimeFormatter.ISO_LOCAL_DATE_TIME)
//                .optionalStart() // オプションのセクションの開始(あれば出るって感じ)
//                .appendOffsetId() // appendOffset("+HH:MM:ss", "Z")と同等
                .appendOffset("+HH:MM", "Z") // 内部でOffsetIdPrinterParserが処理をしてる
                .toFormatter();
    }

    public static void main(String[] s) {
        ZonedDateTime now = ZonedDateTime.now();
        Instant instantNow = Instant.from(now);
        System.out.println(instantNow.toEpochMilli());
        System.out.println(Instant.now().toEpochMilli());
        System.out.println(Calendar.getInstance().getTimeInMillis());

        Calendar c = Calendar.getInstance();
        c.set(1896, 0, 1, 0, 0, 0);
        c.setTimeInMillis(instantNow.toEpochMilli());
        System.out.println(LocalDate.of(1896, 1, 1).atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli());
        System.out.println(new Date(LocalDate.of(1896, 1, 1).atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli()));
        System.out.println(c.getTimeInMillis());
        System.out.println(LocalDate.of(1896, 1, 1));
//        System.out.println(LocalDateTime.now());
        System.out.println(LocalDate.now().atStartOfDay(ZoneId.systemDefault()));
        System.out.println(DateTimeFormatter.ISO_INSTANT.withZone(ZoneId.systemDefault()).format(LocalDate.now().atStartOfDay(ZoneId.systemDefault())));
        DateTimeFormatter formatter = DateTimeFormatter.ISO_INSTANT.withZone(ZoneId.systemDefault());
        System.out.println(formatter.format(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant()));

        System.out.println(ZonedDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));

        System.out.println(ZonedDateTime.now().format(SAMPLE_DATE_TIME));
//        System.out.println(LocalDateTime.now().format(SAMPLE_DATE_TIME)); // error
        System.out.println(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).format(SAMPLE_DATE_TIME));

        System.out.println(LocalDate.now().format(OPTIONAL_START_SAMPLE_FORMAT));
        System.out.println(LocalDateTime.now().format(OPTIONAL_START_SAMPLE_FORMAT));

//        System.out.println(DateTimeFormatter.ISO_INSTANT.format(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant()));
//        System.out.println(DateTimeFormatter.ISO_INSTANT.parse("2006-01-02T15:04:05Z07:00"));
    }
}
