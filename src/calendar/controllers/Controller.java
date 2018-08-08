package calendar.controllers;

import calendar.interfaces.DateUpdate;
import calendar.interfaces.ViewUpdate;
import calendar.model.ChosenDate;
import calendar.model.SkipButton;
import calendar.views.ButtonType;
import calendar.views.View;

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
        //TODO is this the proper place for registering them?
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
        dateComponents.forEach(component -> {
            component.dateUpdate(date);
        });
    }

    public void updateViewDisplayComponents(View View) {
        viewComponents.forEach(component -> {
            component.viewUpdate(View);
        });
    }


    //TODO Spirng mvc approach on the other hand View can directly tell model that it was clicked. But should View be able to interact with model?
    public void skipButtonClicked(ButtonType buttonType) {
        skipButton.skipButtonClicked(buttonType, chosenDate.getLocalDate());
    }
}
