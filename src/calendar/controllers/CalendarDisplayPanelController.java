package calendar.controllers;

import calendar.interfaces.DateUpdate;
import calendar.interfaces.ViewUpdate;
import calendar.model.CalendarDisplayPanelMonth;

import javax.swing.*;
import java.time.LocalDate;

public class CalendarDisplayPanelController implements DateUpdate, ViewUpdate {
    private static CalendarDisplayPanelController ourInstance = new CalendarDisplayPanelController();


    private CalendarDisplayPanelMonth calendarDisplayPanelMonth = new CalendarDisplayPanelMonth();
    private CalendarDisplayPanelMonth currentViewPanel = calendarDisplayPanelMonth;


    private CalendarDisplayPanelController() {
        super();
        Controller.getInstance().addDateComponents(this);
    }

    public static CalendarDisplayPanelController getInstance() {
        return ourInstance;
    }

    @Override
    public void dateUpdate(LocalDate date) {
        updateDateInJpanel(date);
    }

    private void updateDateInJpanel(LocalDate date) {
        if (currentViewPanel.getClass().getSimpleName().equals(CalendarDisplayPanelMonth.class.getSimpleName())) {
            LocalDate startOfMonth = date.minusDays(date.getDayOfMonth());
            setTextInTextFields(startOfMonth);
        } else {
            LocalDate startOfWeek = date.minusDays(date.getDayOfWeek().getValue() - 1);
            setTextInTextFields(startOfWeek);
        }
    }

    private void setTextInTextFields(LocalDate date) {
        for (int i = 0; i < currentViewPanel.getDisplay().size(); i++) {
            currentViewPanel.getDisplay().get(i).setText(date.plusDays(i).toString());
        }
    }

    @Override
    public void viewUpdate(Object View) {
        if (currentViewPanel.getClass().getSimpleName().equals(CalendarDisplayPanelMonth.class.getSimpleName())) {

        } else {

        }
    }

    public JPanel getView() {
        return currentViewPanel;
    }
}
