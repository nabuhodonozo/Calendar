package pl.solsoft.calendar.views;

import pl.solsoft.calendar.controllers.Controller;
import pl.solsoft.calendar.views.panels.CalendarDisplayMainPanel;
import pl.solsoft.calendar.views.panels.MenuPanel;

import javax.swing.*;
import java.time.LocalDate;

public class MainView extends JFrame {
    public MainView() {
        initUI();
    }

    private void initUI() {
        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS));

        this.add(new MenuPanel());
        this.add(new CalendarDisplayMainPanel());

        setDateInAllDateUpdateComponents();

        setTitle("Calendar");
        setSize(1000, 700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void setDateInAllDateUpdateComponents() {
        Controller.getInstance().updateDateDisplayComponents(LocalDate.now());
    }
}