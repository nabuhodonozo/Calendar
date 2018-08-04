package calendar.model;

import calendar.controllers.Controller;
import org.jdesktop.swingx.JXDatePicker;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class DatePicker extends JXDatePicker {
    private static DatePicker ourInstance = new DatePicker();

    private DatePicker() {
        this.setDate(new Date());

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

    public LocalDate getLocalDate() {
        return convertDateToLocalDate(this.getDate());
    }
}
