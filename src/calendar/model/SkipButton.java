package calendar.model;

import calendar.controllers.Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;


public class SkipButton extends JButton {
    public SkipButton() {
    }

    public SkipButton(String text) {
        super(text);

        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Controller.getInstance().updateDateDisplayComponents(LocalDate.now());
            }
        });
    }
}
