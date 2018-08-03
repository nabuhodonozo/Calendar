package calendar.controllers;

import calendar.model.DateUpdate;
import calendar.model.ViewUpdate;

import java.util.List;

public class Controller {
    private static Controller ourInstance = new Controller();

    public static Controller getInstance() {
        return ourInstance;
    }

    private List<ViewUpdate> ViewComponents;

    private List<DateUpdate> DateComponents;

    private Controller() {}


/*    private void viewUpdate(){
        ViewComponents.forEach(component -> {
            component.update(View view);
        });
    }

    private void DateComponents(){
        DateComponents.forEach(component -> {
            component.update(LocalDate date);
        });
    }*/
}
