package calendar.model;

import calendar.controllers.Controller;
import calendar.interfaces.DateUpdate;
import org.jdesktop.swingx.JXDatePicker;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class DatePicker extends JXDatePicker implements DateUpdate {
    private static DatePicker ourInstance = new DatePicker();

    private DatePicker() {
        this.setDate(new Date());

        Controller.getInstance().addDateComponents(this);

        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Controller.getInstance().updateDateDisplayComponents(getLocalDate());
            }
        });
    }

    public static DatePicker getInstance() {
        return ourInstance;
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
