package calendar.View;

import javax.swing.*;
import java.awt.*;

public class View extends JFrame {
    public View() {
        initUI();
    }

    private void initUI() {

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