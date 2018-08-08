package calendar.utils;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class DateConverter {
    public LocalDate convertDateToLocalDate(Date date) {
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    public Date converDatetoLocalDate(LocalDate localDate) {
        return java.util.Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
    }
}
