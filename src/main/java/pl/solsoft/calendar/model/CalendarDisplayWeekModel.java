package pl.solsoft.calendar.model;

import pl.solsoft.calendar.utils.DateUtil;

import java.time.LocalDate;

public class CalendarDisplayWeekModel extends CalendarDisplayAbstractModel {


    public CalendarDisplayWeekModel() {
        super(7);
    }

    @Override
    LocalDate calculateStartingDate(LocalDate localDate) {
        return DateUtil.startOfWeek(localDate);
    }
}
