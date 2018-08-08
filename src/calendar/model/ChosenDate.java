package calendar.model;

import calendar.interfaces.DateUpdate;
import calendar.utils.DateConverter;

import java.time.LocalDate;
import java.util.Date;

public class ChosenDate implements DateUpdate {
    private LocalDate date = LocalDate.now();

    public Date getDate() {
        return DateConverter.LocalDatetoDate(date);
    }

    public LocalDate getLocalDate() {
        return date;
    }

    public void updateDate(LocalDate date) {
        this.date = date;
    }

    public void updateDate(Date date) {
        this.date = DateConverter.DateToLocalDate(date);
    }

    @Override
    public void dateUpdate(LocalDate date) {
        updateDate(date);
    }
}
