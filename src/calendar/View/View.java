package calendar.View;

import calendar.model.CalendarDisplayPanel;
import calendar.model.MenuPanel;

import javax.swing.*;
import java.awt.*;

public class View extends JFrame {
    public View() {
        initUI();
    }

    private void initUI() {
        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS));

        //FIXME It should be probably singletone cuz I am gonna use it again when switching View
        this.add(new MenuPanel());
        this.add(new CalendarDisplayPanel(7));

        setTitle("Calendar");
        setSize(1000, 700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void run(){
        EventQueue.invokeLater(() -> {
            View ex = new View();
            ex.setVisible(true);
        });
    }
}