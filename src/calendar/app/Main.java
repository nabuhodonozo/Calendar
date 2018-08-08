package calendar.app;

import calendar.views.MainView;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            MainView ex = new MainView();
            ex.setVisible(true);
        });
    }
}
