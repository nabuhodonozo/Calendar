package calendar.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CalendarDisplayWeekModel extends CalendarDisplayAbstractModel {
    public CalendarDisplayWeekModel() {
    }

    @Override
    public void updateDatesInList(LocalDate localDate) {
        LocalDate startOfWeek = startOfWeek(localDate);

        List<LocalDate> list = new ArrayList<>();

        for (int i = 0; i < 7; i++) {
            list.add(localDate);
        }

        dayList = list;
    }

    public LocalDate startOfWeek(LocalDate localDate) {
        return localDate.minusDays(localDate.getDayOfWeek().getValue() - 1);
    }
}
