package calendar.model;

import calendar.controllers.Controller;
import calendar.interfaces.DateUpdate;
import calendar.interfaces.ViewUpdate;

import javax.swing.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class CalendarDisplayPanel extends JPanel implements DateUpdate, ViewUpdate {
    private List<JTextField> display = new ArrayList<>();

    public CalendarDisplayPanel(int numberOfFields) {
        super();
        Controller.getInstance().addDateComponents(this);

        createTextFields(numberOfFields);

        display.forEach(jTextField -> this.add(jTextField));
    }


    @Override
    public void dateUpdate(LocalDate date) {
        LocalDate startOfWeek = date.minusDays(date.getDayOfWeek().getValue() - 1);
        for(int i=0; i<display.size();i++){
            display.get(i).setText(startOfWeek.plusDays(i).toString());
        }
    }

    private void createTextFields(int numberOfFields) {
        for (int i = 0; i < numberOfFields; i++) {
            JTextField textField = new JTextField();
            textField.setColumns(10);
            display.add(textField);
        }
    }

    @Override
    public void viewUpdate() {

    }
}
