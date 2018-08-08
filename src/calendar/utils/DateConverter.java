package calendar.utils;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public final class DateConverter {
    //TODO google how to make Util
    private DateConverter() {
    }

    public static Date LocalDatetoDate(LocalDate localDate) {
        return java.util.Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
    }

    public static LocalDate DateToLocalDate(Date date) {
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }
}
