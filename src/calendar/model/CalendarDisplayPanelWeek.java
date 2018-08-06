package calendar.model;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class CalendarDisplayPanelWeek extends JPanel {
    private List<JTextField> display = new ArrayList<>();

    public CalendarDisplayPanelWeek() {
        GridLayout experimentLayout = new GridLayout(1, 7);
        setLayout(experimentLayout);

        createTextFields(7);

        display.forEach(jTextField -> this.add(jTextField));
    }

    private void createTextFields(int numberOfFields) {
        for (int i = 0; i < numberOfFields; i++) {
            JTextField textField = new TextField();
            display.add(textField);
        }
    }
}
