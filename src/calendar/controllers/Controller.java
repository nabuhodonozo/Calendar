package calendar.controllers;

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

    private List<DateUpdate> DateComponents = new ArrayList<>();

    private List<ViewUpdate> ViewComponents = new ArrayList<>();

    private Controller() {}

    public void addDateComponents(DateUpdate component){
        DateComponents.add(component);
    }

    public void addViewComponents(ViewUpdate component){
        ViewComponents.add(component);
    }

    public void updateDateDisplayComponents(LocalDate date){
        DateComponents.forEach(component -> {
            component.dateUpdate(date);
        });
    }

    public void updateViewDisplayComponents(){
        ViewComponents.forEach(component -> {
            component.viewUpdate();
        });
    }
}
