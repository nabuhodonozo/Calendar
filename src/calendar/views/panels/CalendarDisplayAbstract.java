package calendar.views.panels;

import calendar.controllers.Controller;
import calendar.interfaces.DateUpdate;
import calendar.model.CalendarDisplayAbstractModel;
import calendar.views.components.DayTextField;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class CalendarDisplayAbstract extends JPanel implements DateUpdate {
    private int columns = 7;
    private List<DayTextField> textFieldsDipslay = new ArrayList<>();
    private CalendarDisplayAbstractModel model;

    public CalendarDisplayAbstract(CalendarDisplayAbstractModel model, int rows) {
        Controller.getInstance().addDateComponents(this);
        GridLayout experimentLayout = new GridLayout(rows, columns);
        setLayout(experimentLayout);
        this.model = model;

        createTextFieldDisplay(rows * columns);

        textFieldsDipslay.forEach(dayTextField -> this.add(dayTextField));
    }


    public void createTextFieldDisplay(int numberOfTextFields) {
        for (int i = 0; i < numberOfTextFields; i++) {
            DayTextField textField = new DayTextField();
            textFieldsDipslay.add(textField);
        }
    }

    public void updateFields(List<LocalDate> dayList, LocalDate chosenDate) {
        List<LocalDate> list = model.getDayList();
        for (int i = 0; i < textFieldsDipslay.size(); i++) {
            DayTextField textField = textFieldsDipslay.get(i);
            textField.setText(list.get(i).toString());
            repaintFields(textField, chosenDate, list.get(i));

        }
    }

    abstract void repaintFields(DayTextField textField, LocalDate chosenDate, LocalDate newDate);



    @Override
    public void dateUpdate(LocalDate date) {
        updateFields(model.getDayList(), date);
    }
}
