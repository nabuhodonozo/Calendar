package pl.solsoft.calendar.views.components;

import pl.solsoft.calendar.controllers.Controller;
import pl.solsoft.calendar.interfaces.DateUpdate;
import pl.solsoft.calendar.utils.DateUtil;
import org.jdesktop.swingx.JXDatePicker;

import java.time.LocalDate;

public class DatePicker extends JXDatePicker implements DateUpdate {
    public DatePicker() {
        Controller.getInstance().addDateComponents(this);

        this.addActionListener(e -> {
            Controller controller = Controller.getInstance();
            controller.updateDateDisplayComponents(DateUtil.dateToLocalDate(getDate()));
        });
    }

    @Override
    public void dateUpdate(LocalDate localDate) {
        this.setDate(DateUtil.localDatetoDate(localDate));
    }
}
