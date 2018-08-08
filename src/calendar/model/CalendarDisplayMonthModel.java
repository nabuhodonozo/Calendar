package calendar.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CalendarDisplayMonthModel extends CalendarDisplayAbstractModel {
    public CalendarDisplayMonthModel() {
    }

    @Override
    public void updateDatesInList(LocalDate localDate) {
        LocalDate startOfMonth = startOfMonth(localDate);

        List<LocalDate> list = new ArrayList<>();

        for (int i = 0; i < 42; i++) {
            list.add(localDate);
        }

        dayList = list;
    }

    public LocalDate startOfMonth(LocalDate localDate) {
        int moveIndex = localDate.minusDays(localDate.getDayOfMonth()).getDayOfWeek().getValue() - 1;
        return localDate.minusDays(localDate.getDayOfMonth() + moveIndex);
    }
}
