package calendar.app;

import calendar.controllers.CalendarDisplayPanelController;
import calendar.controllers.Controller;
import calendar.model.MenuPanel;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;

public class Main extends JFrame {
    public Main() {
        initUI();
    }

    private void initUI() {
        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS));

        this.add(new MenuPanel());
        this.add(CalendarDisplayPanelController.getInstance().getView());

        setDateInAllDateUpdateComponents();

        setTitle("Calendar");
        setSize(1000, 700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            Main ex = new Main();
            ex.setVisible(true);
        });
    }

    private void setDateInAllDateUpdateComponents() {
        Controller.getInstance().updateDateDisplayComponents(LocalDate.now());
    }
}