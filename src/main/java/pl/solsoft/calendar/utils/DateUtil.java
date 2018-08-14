package pl.solsoft.calendar.utils;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public final class DateUtil {
    private DateUtil() {
    }

    public static Date localDatetoDate(LocalDate localDate) {
        return java.util.Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
    }

    public static LocalDate dateToLocalDate(Date date) {
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    public static LocalDate startOfWeek(LocalDate localDate) {
        return localDate.minusDays(localDate.getDayOfWeek().getValue() - 1);
    }

    public static boolean isItSameMonth(LocalDate date1, LocalDate date2) {
        return date1.getMonth().equals(date2.getMonth());
    }
}
