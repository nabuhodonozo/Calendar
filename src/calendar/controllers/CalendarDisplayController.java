package calendar.controllers;

import calendar.interfaces.DateUpdate;
import calendar.interfaces.ViewUpdate;
import calendar.model.CalendarDisplay;

import javax.swing.*;
import java.time.LocalDate;

public class CalendarDisplayController implements ViewUpdate, DateUpdate {
    private CalendarDisplay Week = new CalendarDisplay(1, 7);
    private CalendarDisplay Month = new CalendarDisplay(6, 7);

    private CalendarDisplay currentViewPanel = Month;

    @Override
    public void dateUpdate(LocalDate date) {
        updateDateInJpanel(date);
    }

    private void updateDateInJpanel(LocalDate date) {
        if (currentViewPanel.equals(Month)) {
            LocalDate startOfMonth = date.minusDays(date.getDayOfMonth());
            setTextInTextFields(startOfMonth);
        } else {
            LocalDate startOfWeek = date.minusDays(date.getDayOfWeek().getValue() - 1);
            setTextInTextFields(startOfWeek);
        }
    }

    private void setTextInTextFields(LocalDate date) {
        for (int i = 0; i < currentViewPanel.getTextFieldDisplay().getDisplay().size(); i++) {
            currentViewPanel.getTextFieldDisplay().getDisplay().get(i).setText(date.plusDays(i).toString());
        }
    }

    @Override
    public void viewUpdate(Object View) {
    }

    public JPanel getView() {
        return currentViewPanel;
    }
}

