package pl.solsoft.calendar.views.panels;

import pl.solsoft.calendar.model.CalendarDisplayMonthModel;
import pl.solsoft.calendar.utils.DateUtil;
import pl.solsoft.calendar.views.components.DayTextField;

import java.awt.*;
import java.time.LocalDate;

public class CalendarDisplayMonth extends CalendarDisplayAbstract {
    public CalendarDisplayMonth() {
        super(new CalendarDisplayMonthModel(), 6);
    }

    @Override
    void repaintFields(DayTextField textField, LocalDate chosenDate, LocalDate newDate) {
        if (textField.getText().equals(chosenDate.toString())) {
            textField.setBackground(Color.yellow);
        } else if (DateUtil.isItSameMonth(chosenDate, newDate)) {
            textField.setBackground(Color.white);
        } else {
            textField.setBackground(Color.gray);
        }
    }
}