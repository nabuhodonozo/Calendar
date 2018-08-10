package calendar.views.panels;

import calendar.model.CalendarDisplayWeekModel;
import calendar.views.components.DayTextField;

import java.awt.*;
import java.time.LocalDate;

public class CalendarDisplayWeek extends CalendarDisplayAbstract {
    public CalendarDisplayWeek() {
        super(new CalendarDisplayWeekModel(), 1);
    }

    @Override
    void repaintFields(DayTextField textField, LocalDate chosenDate, LocalDate newDate) {
        if (textField.getText().equals(chosenDate.toString())) {
            textField.setBackground(Color.yellow);
        } else {
            textField.setBackground(Color.white);
        }
    }
}