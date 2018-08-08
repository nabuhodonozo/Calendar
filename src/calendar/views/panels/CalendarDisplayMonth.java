package calendar.views.panels;

import calendar.model.CalendarDisplayMonthModel;

public class CalendarDisplayMonth extends CalendarDisplayAbstract {
    public CalendarDisplayMonth() {
        super(new CalendarDisplayMonthModel(), 6);
    }
}