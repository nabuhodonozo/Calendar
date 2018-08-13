package pl.solsoft.calendar.model;

import pl.solsoft.calendar.controllers.Controller;
import pl.solsoft.calendar.interfaces.DateUpdate;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class CalendarDisplayAbstractModel implements DateUpdate {
    protected List<LocalDate> dayList = new ArrayList<>();

    public CalendarDisplayAbstractModel() {
        Controller.getInstance().addDateComponents(this);
    }

    public List<LocalDate> getDayList() {
        return dayList;
    }

    public abstract void updateDatesInList(LocalDate localDate);

    @Override
    public void dateUpdate(LocalDate localDate) {
        updateDatesInList(localDate);
    }
}
