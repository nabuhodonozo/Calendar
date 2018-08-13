package calendar.model;

import calendar.controllers.Controller;
import calendar.interfaces.DateUpdate;

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

    public void setDayList(List<LocalDate> dayList) {
        this.dayList = dayList;
    }

    public abstract void updateDatesInList(LocalDate localDate);


    @Override
    public void dateUpdate(LocalDate localDate) {
        updateDatesInList(localDate);
    }
}