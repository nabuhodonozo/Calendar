package calendar.views.components;

import calendar.controllers.Controller;
import calendar.interfaces.DateUpdate;
import org.jdesktop.swingx.JXDatePicker;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class DatePicker extends JXDatePicker implements DateUpdate {
    public DatePicker() {
        Controller.getInstance().addDateComponents(this);

        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Controller.getInstance().updateDateDisplayComponents(getLocalDate());
            }
        });
    }

    private LocalDate convertDateToLocalDate(Date date) {
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    private Date converDatetoLocalDate(LocalDate localDate) {
        return java.util.Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
    }

    public LocalDate getLocalDate() {
        return convertDateToLocalDate(this.getDate());
    }

    @Override
    public void dateUpdate(LocalDate localDate) {
        this.setDate(converDatetoLocalDate(localDate));
    }
}
