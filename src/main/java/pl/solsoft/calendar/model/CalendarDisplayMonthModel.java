package pl.solsoft.calendar.model;

import java.time.LocalDate;

public class CalendarDisplayMonthModel extends CalendarDisplayAbstractModel {

    public CalendarDisplayMonthModel() {
        super(42);
    }

    public LocalDate startOfMonth(LocalDate localDate) {
        int moveIndex = localDate.minusDays(localDate.getDayOfMonth()).getDayOfWeek().getValue() - 1;
        return localDate.minusDays(localDate.getDayOfMonth() + moveIndex);
    }

    @Override
    LocalDate calculateStartingDate(LocalDate localDate) {
        int moveIndex = localDate.minusDays(localDate.getDayOfMonth()).getDayOfWeek().getValue() - 1;
        return localDate.minusDays(localDate.getDayOfMonth() + moveIndex);
    }
}
