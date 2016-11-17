import java.time.*;
import java.time.chrono.IsoChronology;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.ResolverStyle;
import java.util.Calendar;
import java.util.Date;

public class Main {

    public static final DateTimeFormatter ISO_DATE_TIME;
    static {
        ISO_DATE_TIME = new DateTimeFormatterBuilder()
                .append(DateTimeFormatter.ISO_LOCAL_DATE_TIME)
                .optionalStart()
                .appendOffsetId()
                .optionalStart()
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
        DateTimeFormatter f = ISO_DATE_TIME;
        ZonedDateTime zdt = ZonedDateTime.parse("2014-09-02T08:05:23.653Z", f);
        System.out.println(zdt.toString());
        System.out.println(ZonedDateTime.now().format(f));
//        System.out.println(DateTimeFormatter.ISO_INSTANT.format(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant()));
//        System.out.println(DateTimeFormatter.ISO_INSTANT.parse("2006-01-02T15:04:05Z07:00"));
    }
}
