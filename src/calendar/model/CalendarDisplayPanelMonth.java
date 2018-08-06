package calendar.model;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class CalendarDisplayPanelMonth extends JPanel {
    private List<JTextField> display = new ArrayList<>();

    public CalendarDisplayPanelMonth() {
        GridLayout experimentLayout = new GridLayout(6, 7);
        setLayout(experimentLayout);

        createTextFields(42);

        display.forEach(jTextField -> this.add(jTextField));
    }

    public List<JTextField> getDisplay() {
        return display;
    }

    private void createTextFields(int numberOfFields) {
        for (int i = 0; i < numberOfFields; i++) {
            JTextField textField = new TextField();
            display.add(textField);
        }
    }

}
