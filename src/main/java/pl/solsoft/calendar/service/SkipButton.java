package pl.solsoft.calendar.service;

import pl.solsoft.calendar.controllers.Controller;
import pl.solsoft.calendar.interfaces.ViewUpdate;
import pl.solsoft.calendar.views.ButtonType;
import pl.solsoft.calendar.views.ViewType;

import java.time.LocalDate;

public class SkipButton implements ViewUpdate {
    private ViewType viewType = ViewType.WEEK;


    public void skipButtonClicked(ButtonType buttonType, LocalDate localDate) {
        LocalDate dateToPass = calculateDate(localDate, buttonType);
        Controller.getInstance().updateDateDisplayComponents(dateToPass);
    }

    private LocalDate calculateDate(LocalDate localDate, ButtonType buttonType) {
        if (viewType == ViewType.WEEK) {
            return changeWeek(localDate, buttonType);
        }
        return changeMonth(localDate, buttonType);
    }

    private LocalDate changeWeek(LocalDate localDate, ButtonType buttonType) {
        if (buttonType == ButtonType.BACKWARD) {
            return localDate.minusDays(7);
        }
        return localDate.plusDays(7);
    }

    private LocalDate changeMonth(LocalDate localDate, ButtonType buttonType) {
        if (buttonType == ButtonType.BACKWARD) {
            return localDate.minusMonths(1);
        }
        return localDate.plusMonths(1);
    }


    @Override
    public void viewUpdate(ViewType viewType) {
        this.viewType = viewType;
    }
}
