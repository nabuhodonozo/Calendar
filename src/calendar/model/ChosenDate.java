package calendar.model;

import calendar.interfaces.DateUpdate;
import calendar.utils.DateConverter;

import java.time.LocalDate;
import java.util.Date;

public class ChosenDate implements DateUpdate {
    private LocalDate date = LocalDate.now();

    public Date getDate() {
        DateConverter dateConverter = new DateConverter();
        return dateConverter.LocalDatetoDate(date);
    }

    public LocalDate getLocalDate() {
        return date;
    }

    public void updateDate(LocalDate date) {
        this.date = date;
    }

    public void updateDate(Date date) {
        DateConverter dateConverter = new DateConverter();
        this.date = dateConverter.DateToLocalDate(date);
    }

    @Override
    public void dateUpdate(LocalDate date) {
        updateDate(date);
    }
}
