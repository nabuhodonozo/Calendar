package pl.solsoft.calendar.views.panels;

import pl.solsoft.calendar.controllers.Controller;
import pl.solsoft.calendar.interfaces.ViewUpdate;
import pl.solsoft.calendar.views.ViewType;

import javax.swing.*;
import java.awt.*;

public class CalendarDisplayMainPanel extends JPanel implements ViewUpdate {
    private CalendarDisplayAbstract week = new CalendarDisplayWeek();
    private CalendarDisplayAbstract month = new CalendarDisplayMonth();

    public CalendarDisplayMainPanel() {
        super(new CardLayout());
        Controller.getInstance().addViewComponents(this);
        add(week, ViewType.WEEK.getViewType());
        add(month, ViewType.MONTH.getViewType());
    }

    @Override
    public void viewUpdate(ViewType viewType) {
        CardLayout cardLayout = (CardLayout) this.getLayout();
        cardLayout.show(this, viewType.getViewType());
    }
}

