package calendar.app;

import calendar.model.CalendarDisplayPanel;
import calendar.model.MenuPanel;

import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {
    public Main() {
        initUI();
    }

    private void initUI() {
        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS));

        this.add(new MenuPanel());
        this.add(new CalendarDisplayPanel(7));

        setTitle("Calendar");
        setSize(1000, 700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void run(){
        EventQueue.invokeLater(() -> {
            Main ex = new Main();
            ex.setVisible(true);
        });
    }
}