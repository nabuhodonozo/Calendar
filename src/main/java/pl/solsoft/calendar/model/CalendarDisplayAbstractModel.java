package pl.solsoft.calendar.model;

import pl.solsoft.calendar.controllers.Controller;
import pl.solsoft.calendar.interfaces.DateUpdate;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class CalendarDisplayAbstractModel implements DateUpdate {
    protected List<LocalDate> textFieldsList = new ArrayList<>();

    int numberOfTextFields;

    public CalendarDisplayAbstractModel(int numberOfTextFields) {
        this.numberOfTextFields = numberOfTextFields;
        Controller.getInstance().addDateComponents(this);
    }

    public List<LocalDate> getTextFieldsList() {
        return textFieldsList;
    }

    public void updateDatesInList(LocalDate localDate) {
        List<LocalDate> list = new ArrayList<>();

        LocalDate startingDate = calculateStartingDate(localDate);

        for (int i = 0; i < numberOfTextFields; i++) {
            list.add(startingDate.plusDays(i));
        }

        textFieldsList = list;
    }

    abstract LocalDate calculateStartingDate(LocalDate localDate);

    @Override
    public void dateUpdate(LocalDate localDate) {
        updateDatesInList(localDate);
    }
}
