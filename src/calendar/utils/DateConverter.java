package calendar.utils;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public final class DateConverter {
    private DateConverter() {
    }

    public static Date localDatetoDate(LocalDate localDate) {
        return java.util.Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
    }

    public static LocalDate dateToLocalDate(Date date) {
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }
}
