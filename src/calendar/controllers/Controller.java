package calendar.controllers;

import calendar.Enum.Views;
import calendar.interfaces.DateUpdate;
import calendar.interfaces.ViewUpdate;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Controller {
    private static Controller ourInstance = new Controller();

    public static Controller getInstance() {
        return ourInstance;
    }

    private List<DateUpdate> dateComponents = new ArrayList<>();

    private List<ViewUpdate> viewComponents = new ArrayList<>();

    private Controller() {}

    public void addDateComponents(DateUpdate component){
        dateComponents.add(component);
    }

    public void addViewComponents(ViewUpdate component){
        viewComponents.add(component);
    }

    public void updateDateDisplayComponents(LocalDate date){
        dateComponents.forEach(component -> {
            component.dateUpdate(date);
        });
    }

    public void updateViewDisplayComponents(Views View) {
        viewComponents.forEach(component -> {
            component.viewUpdate(View);
        });
    }
}
