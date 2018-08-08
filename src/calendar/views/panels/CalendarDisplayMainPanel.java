package calendar.views.panels;

import calendar.controllers.Controller;
import calendar.interfaces.DateUpdate;
import calendar.interfaces.ViewUpdate;
import calendar.views.View;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;

public class CalendarDisplayMainPanel extends JPanel implements ViewUpdate, DateUpdate {
    private CalendarDisplay week = new CalendarDisplay(1, 7);
    private CalendarDisplay month = new CalendarDisplay(6, 7);

    public CalendarDisplayMainPanel() {
        super(new CardLayout());
        Controller.getInstance().addViewComponents(this);
        Controller.getInstance().addDateComponents(this);
        add(week, "WEEK");
        add(month, "MONTH");
    }

    @Override
    public void viewUpdate(View view) {
        CardLayout cardLayout = (CardLayout) this.getLayout();
        cardLayout.show(this, view.toString());
    }

    @Override
    public void dateUpdate(LocalDate date) {
        LocalDate startOfWeek = date.minusDays(date.getDayOfWeek().getValue() - 1);
        week.setTextInTextFields(startOfWeek);
        
        int moveIndex = date.minusDays(date.getDayOfMonth()).getDayOfWeek().getValue() - 1;
        LocalDate startOfMonth = date.minusDays(date.getDayOfMonth() + moveIndex);
        month.setTextInTextFields(startOfMonth);
    }
}

