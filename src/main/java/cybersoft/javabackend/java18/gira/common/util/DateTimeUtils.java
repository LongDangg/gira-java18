package cybersoft.javabackend.java18.gira.common.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeUtils {
    public static final String DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern(DATETIME_FORMAT);
    public static String now() {
        return LocalDateTime.now().format(DATE_TIME_FORMATTER);
    }
}
