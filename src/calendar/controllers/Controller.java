package calendar.controllers;

import calendar.interfaces.DateUpdate;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Controller {
    private static Controller ourInstance = new Controller();

    public static Controller getInstance() {
        return ourInstance;
    }

    private List<DateUpdate> DateComponents = new ArrayList<>();

    private Controller() {}

    public void addDateComponents(DateUpdate component){
        DateComponents.add(component);
    }

    public void updateDateDisplayComponents(LocalDate date){
        DateComponents.forEach(component -> {
            component.dateUpdate(date);
        });
    }
}
