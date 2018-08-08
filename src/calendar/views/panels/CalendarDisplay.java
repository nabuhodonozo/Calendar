package calendar.views.panels;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CalendarDisplay extends JPanel {
    private List<JTextField> display = new ArrayList<>();

    public CalendarDisplay(int numberOfRows, int numberOfColumns) {
        GridLayout experimentLayout = new GridLayout(numberOfRows, numberOfColumns);
        setLayout(experimentLayout);

        createTextFieldDisplay(numberOfRows * numberOfColumns);

        display.forEach(jTextField -> this.add(jTextField));
    }

    public void setTextInTextFields(LocalDate date) {
        for (int i = 0; i < display.size(); i++) {
            display.get(i).setText(date.plusDays(i).toString());
        }
    }

    public void createTextFieldDisplay(int numberOfTextFields) {
        for (int i = 0; i < numberOfTextFields; i++) {
            JTextField textField = new TextField();
            display.add(textField);
        }
    }

    class TextField extends JTextField {
        public TextField() {
            this.setColumns(10);
        }
    }
}
