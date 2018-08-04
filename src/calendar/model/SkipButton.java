package calendar.model;

import calendar.controllers.Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;


public class SkipButton extends JButton {
    public SkipButton() {
    }

    public SkipButton(String text) {
        super(text);

        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Date date = DatePicker.getInstance().getDate();
                LocalDate LocalDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                Controller.getInstance().updateDateDisplayComponents(java.time.LocalDate.now());
            }
        });
    }
}
