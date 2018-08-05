package calendar.model;

import calendar.controllers.Controller;
import org.jdesktop.swingx.JXDatePicker;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class DatePicker extends JXDatePicker {
    public DatePicker() {
        this.setDate(new Date());

        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Controller.getInstance().updateDateDisplayComponents(DatePicker.super.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
            }
        });
    }
}
