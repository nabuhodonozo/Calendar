package calendar.model;

import calendar.controllers.Controller;
import calendar.interfaces.ViewUpdate;
import calendar.views.ButtonType;
import calendar.views.ViewType;

import java.time.LocalDate;

public class SkipButton implements ViewUpdate {
    private ViewType viewType = ViewType.WEEK;

    private LocalDate calculateDate(LocalDate localDate, ButtonType buttonType) {
        if (viewType == ViewType.WEEK) {
            return changeWeek(localDate, buttonType);
        }
        return changeMonth(localDate, buttonType);
    }

    public LocalDate changeWeek(LocalDate localDate, ButtonType buttonType) {
        if (buttonType == ButtonType.BACKWARD) {
            return localDate.minusDays(7);
        }
        return localDate.plusDays(7);
    }

    public LocalDate changeMonth(LocalDate localDate, ButtonType buttonType) {
        if (buttonType == ButtonType.BACKWARD) {
            return localDate.minusMonths(1);
        }
        return localDate.plusMonths(1);
    }

    public void skipButtonClicked(ButtonType buttonType, LocalDate localDate) {
        LocalDate dateToPass = calculateDate(localDate, buttonType);
        Controller.getInstance().updateDateDisplayComponents(dateToPass);
    }

    @Override
    public void viewUpdate(ViewType viewType) {
        this.viewType = viewType;
    }
}
