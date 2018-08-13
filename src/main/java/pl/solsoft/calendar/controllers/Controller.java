package pl.solsoft.calendar.controllers;

import pl.solsoft.calendar.interfaces.DateUpdate;
import pl.solsoft.calendar.interfaces.ViewUpdate;
import pl.solsoft.calendar.service.ChosenDate;
import pl.solsoft.calendar.service.SkipButton;
import pl.solsoft.calendar.views.ButtonType;
import pl.solsoft.calendar.views.ViewType;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Controller {
    private static Controller ourInstance = new Controller();

    private List<DateUpdate> dateComponents = new ArrayList<>();
    private List<ViewUpdate> viewComponents = new ArrayList<>();

    private ChosenDate chosenDate = new ChosenDate();
    private SkipButton skipButton = new SkipButton();

    private Controller() {
        addDateComponents(chosenDate);
        addViewComponents(skipButton);
    }

    public static Controller getInstance() {
        return ourInstance;
    }

    public void addDateComponents(DateUpdate component) {
        dateComponents.add(component);
    }

    public void addViewComponents(ViewUpdate component) {
        viewComponents.add(component);
    }

    public void updateDateDisplayComponents(LocalDate date) {
        dateComponents.forEach(component -> component.dateUpdate(date));
    }

    public void updateViewDisplayComponents(ViewType viewType) {
        viewComponents.forEach(component -> component.viewUpdate(viewType));
    }

    public void skipButtonClicked(ButtonType buttonType) {
        skipButton.skipButtonClicked(buttonType, chosenDate.getLocalDate());
    }
}
