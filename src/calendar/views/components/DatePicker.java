package calendar.views.components;

import calendar.controllers.Controller;
import calendar.interfaces.DateUpdate;
import calendar.utils.DateUtil;
import org.jdesktop.swingx.JXDatePicker;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class DatePicker extends JXDatePicker implements DateUpdate {
    public DatePicker() {
        Controller.getInstance().addDateComponents(this);

        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Controller controller = Controller.getInstance();
                controller.updateDateDisplayComponents(DateUtil.dateToLocalDate(getDate()));
            }
        });
    }

    @Override
    public void dateUpdate(LocalDate localDate) {
        this.setDate(DateUtil.localDatetoDate(localDate));
    }
}
