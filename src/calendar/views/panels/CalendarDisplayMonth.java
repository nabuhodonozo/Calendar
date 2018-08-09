package calendar.views.panels;

import calendar.model.CalendarDisplayMonthModel;
import calendar.utils.DateUtil;
import calendar.views.components.JTextField;

import java.awt.*;
import java.time.LocalDate;

public class CalendarDisplayMonth extends CalendarDisplayAbstract {
    public CalendarDisplayMonth() {
        super(new CalendarDisplayMonthModel(), 6);
    }

    @Override
    void repaintFields(JTextField textField, LocalDate chosenDate, LocalDate newDate) {
        if (textField.getText().equals(chosenDate.toString())) {
            textField.setBackground(Color.yellow);
        } else if (DateUtil.isItSameMonth(chosenDate, newDate)) {
            textField.setBackground(Color.white);
        } else {
            textField.setBackground(Color.gray);
        }
    }
}