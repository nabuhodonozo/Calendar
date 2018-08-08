package calendar.views.panels;

import calendar.controllers.Controller;
import calendar.interfaces.DateUpdate;
import calendar.model.CalendarDisplayAbstractModel;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class CalendarDisplayAbstract extends JPanel implements DateUpdate {
    private int columns = 7;
    private List<JTextField> textFieldsDipslay = new ArrayList<>();
    private CalendarDisplayAbstractModel model;

    public CalendarDisplayAbstract(CalendarDisplayAbstractModel model, int rows) {
        Controller.getInstance().addDateComponents(this);
        GridLayout experimentLayout = new GridLayout(rows, columns);
        setLayout(experimentLayout);
        this.model = model;

        createTextFieldDisplay(rows * columns);

        textFieldsDipslay.forEach(jTextField -> this.add(jTextField));
    }

    public void updateTextInTextFields(List<LocalDate> dayList) {
        List<LocalDate> list = model.getDayList();
        for (int i = 0; i < textFieldsDipslay.size(); i++) {
            textFieldsDipslay.get(i).setText(list.get(i).toString());
        }
    }

    public void createTextFieldDisplay(int numberOfTextFields) {
        for (int i = 0; i < numberOfTextFields; i++) {
            JTextField textField = new TextField();
            textFieldsDipslay.add(textField);
        }
    }

    @Override
    public void dateUpdate(LocalDate date) {
        updateTextInTextFields(model.getDayList());
    }

    class TextField extends JTextField {
        public TextField() {
            this.setColumns(10);
        }
    }
}
