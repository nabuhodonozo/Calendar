package calendar.service;

import calendar.interfaces.DateUpdate;

import java.time.LocalDate;

public class ChosenDate implements DateUpdate {
    private LocalDate date = LocalDate.now();

    public LocalDate getLocalDate() {
        return date;
    }

    public void updateDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public void dateUpdate(LocalDate date) {
        updateDate(date);
    }
}
