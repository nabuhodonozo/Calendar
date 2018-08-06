package calendar.model;

import calendar.controllers.Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;


public class SkipButton extends JButton {
    private int dateMultiplierBasedOnDirection;

    public SkipButton(DatePicker datePicker, skipDirection skipDirection) {
        setPropertiesBasedOnSkipDirection(skipDirection);

        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LocalDate dateToPass = calculateDate(datePicker.getLocalDate());
                Controller.getInstance().updateDateDisplayComponents(dateToPass);
            }
        });
    }

    private void setPropertiesBasedOnSkipDirection(skipDirection skipDirection) {
        if (skipDirection.equals(SkipButton.skipDirection.BACKWARD)) {
            setButtonProperties("<", -1);
        } else {
            setButtonProperties(">", 1);
        }
    }

    private void setButtonProperties(String text, int dateMultiplierBasedOnDirection) {
        setText(text);
        this.dateMultiplierBasedOnDirection = dateMultiplierBasedOnDirection;
    }

    private LocalDate calculateDate(LocalDate localDate) {
        return localDate.plusDays(7 * dateMultiplierBasedOnDirection);
    }

    public enum skipDirection {
        FORWARD,
        BACKWARD
    }
}
