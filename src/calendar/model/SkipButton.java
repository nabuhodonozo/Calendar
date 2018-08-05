package calendar.model;

import calendar.controllers.Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class SkipButton extends JButton {
    public SkipButton(skipDirection skipDirection) {
        setText(skipDirection);

        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Controller.getInstance().updateDateDisplayComponents(DatePicker.getInstance().getLocalDate());
            }
        });
    }

    public void setText(skipDirection skipDirection) {
        if (skipDirection.equals(SkipButton.skipDirection.BACKWARD)) {
            this.setText("<");
        } else {
            this.setText(">");
        }
    }

    public enum skipDirection {
        FORWARD,
        BACKWARD
    }
}
