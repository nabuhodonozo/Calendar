package calendar.views.panels;

import calendar.controllers.Controller;
import calendar.interfaces.DateUpdate;
import calendar.interfaces.ViewUpdate;
import calendar.views.Views;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;

public class CalendarDisplayMainPanel extends JPanel implements ViewUpdate, DateUpdate {
    private CalendarDisplay Week = new CalendarDisplay(1, 7);
    private CalendarDisplay Month = new CalendarDisplay(6, 7);

    public CalendarDisplayMainPanel() {
        super(new CardLayout());
        Controller.getInstance().addViewComponents(this);
        Controller.getInstance().addDateComponents(this);
        add(Week, "WEEK");
        add(Month, "MONTH");
    }

    @Override
    public void viewUpdate(Views View) {
        CardLayout cardLayout = (CardLayout) this.getLayout();
        cardLayout.show(this, View.toString());
    }

    @Override
    public void dateUpdate(LocalDate date) {
        LocalDate startOfWeek = date.minusDays(date.getDayOfWeek().getValue() - 1);
        Week.setTextInTextFields(startOfWeek);
        
        int moveIndex = date.minusDays(date.getDayOfMonth()).getDayOfWeek().getValue() - 1;
        LocalDate startOfMonth = date.minusDays(date.getDayOfMonth() + moveIndex);
        Month.setTextInTextFields(startOfMonth);
    }
}

