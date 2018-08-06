package calendar.model;

import calendar.controllers.Controller;
import calendar.interfaces.DateUpdate;
import calendar.interfaces.ViewUpdate;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CalendarDisplay extends JPanel implements ViewUpdate, DateUpdate {
    private List<JTextField> display = new ArrayList<>();

    public CalendarDisplay(int numberOfRows, int numberOfColumns, int numberOfTextFields) {
        Controller.getInstance().addDateComponents(this);

        GridLayout experimentLayout = new GridLayout(numberOfRows, numberOfColumns);
        setLayout(experimentLayout);

        createTextFields(numberOfTextFields);

        display.forEach(jTextField -> this.add(jTextField));
    }

    private void createTextFields(int numberOfFields) {
        for (int i = 0; i < numberOfFields; i++) {
            JTextField textField = new TextField();
            display.add(textField);
        }
    }

    @Override
    public void dateUpdate(LocalDate date) {
        for (int i = 0; i < display.size(); i++) {
            display.get(i).setText(date.plusDays(i).toString());
        }
    }

    @Override
    public void viewUpdate(Object View) {

    }
}
