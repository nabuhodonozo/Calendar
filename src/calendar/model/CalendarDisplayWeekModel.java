package calendar.model;

import calendar.utils.DateUtil;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CalendarDisplayWeekModel extends CalendarDisplayAbstractModel {
    @Override
    public void updateDatesInList(LocalDate localDate) {
        LocalDate startOfWeek = DateUtil.startOfWeek(localDate);

        List<LocalDate> list = new ArrayList<>();

        for (int i = 0; i < 7; i++) {
            list.add(startOfWeek.plusDays(i));
        }

        dayList = list;
    }
}
