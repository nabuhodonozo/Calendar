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
                LocalDate localDate = DatePicker.super.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                Controller.getInstance().updateDateDisplayComponents(localDate);
            }
        });
    }

    public static DatePicker getInstance() {
        return ourInstance;
    }
}
