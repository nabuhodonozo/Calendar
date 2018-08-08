package calendar.model;

import calendar.controllers.Controller;
import calendar.interfaces.ViewUpdate;
import calendar.views.ButtonType;
import calendar.views.View;

import java.time.LocalDate;

public class SkipButton implements ViewUpdate {
    private View view = View.WEEK;

    private LocalDate calculateDate(LocalDate localDate, ButtonType buttonType) {
        if (view == View.WEEK) {
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
            return localDate.minusDays(1);
        }
        return localDate.plusMonths(1);
    }


    public void skipButtonClicked(ButtonType buttonType, LocalDate localDate) {
        LocalDate dateToPass = calculateDate(localDate, buttonType);
        Controller.getInstance().updateDateDisplayComponents(dateToPass);
    }

    @Override
    public void viewUpdate(View view) {
        this.view = view;
    }
}
