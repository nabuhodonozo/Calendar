package calendar.views.panels;

import calendar.controllers.Controller;
import calendar.interfaces.ViewUpdate;
import calendar.views.ViewType;

import javax.swing.*;
import java.awt.*;

public class CalendarDisplayMainPanel extends JPanel implements ViewUpdate {
    private CalendarDisplayAbstract week = new CalendarDisplayWeek();
    private CalendarDisplayAbstract month = new CalendarDisplayMonth();

    public CalendarDisplayMainPanel() {
        super(new CardLayout());
        Controller.getInstance().addViewComponents(this);
        add(week, ViewType.WEEK.toString());
        add(month, ViewType.MONTH.toString());
    }

    @Override
    public void viewUpdate(ViewType viewType) {
        CardLayout cardLayout = (CardLayout) this.getLayout();
        cardLayout.show(this, viewType.toString());
    }
}

