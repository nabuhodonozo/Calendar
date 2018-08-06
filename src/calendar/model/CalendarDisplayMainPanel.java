package calendar.model;

import calendar.controllers.Controller;
import calendar.interfaces.DateUpdate;
import calendar.interfaces.ViewUpdate;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;

public class CalendarDisplayMainPanel extends JPanel implements ViewUpdate, DateUpdate {
    private CalendarDisplay Week = new CalendarDisplay(1, 7);
    private CalendarDisplay Month = new CalendarDisplay(6, 7);

    private CalendarDisplay currentViewPanel = Week;

    public CalendarDisplayMainPanel() {
        super(new CardLayout());
        Controller.getInstance().addViewComponents(this);
        Controller.getInstance().addDateComponents(this);
        add(Week, "Week");
        add(Month, "Month");
    }

    @Override
    public void viewUpdate(Object View) {
        CardLayout cardLayout = (CardLayout) this.getLayout();
        cardLayout.next(this);
    }

    @Override
    public void dateUpdate(LocalDate date) {
        Week.setTextInTextFields(date);
        Month.setTextInTextFields(date);
    }
}

