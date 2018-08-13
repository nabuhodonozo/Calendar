package calendar.views.components;

import calendar.controllers.Controller;
import calendar.views.ButtonType;

import javax.swing.*;


public class SkipButton extends JButton {
    public SkipButton(ButtonType buttonType) {
        setProperties(buttonType);

        addActionListener(actionEvent -> {
            Controller.getInstance().skipButtonClicked(buttonType);
        });
    }

    private void setProperties(ButtonType buttonType) {
        if (ButtonType.BACKWARD == buttonType) {
            setText("<");
        } else {
            setText(">");
        }
    }
}
