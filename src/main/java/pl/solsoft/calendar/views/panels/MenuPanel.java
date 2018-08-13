package pl.solsoft.calendar.views.panels;

import pl.solsoft.calendar.views.ButtonType;
import pl.solsoft.calendar.views.ViewType;
import pl.solsoft.calendar.views.components.DatePicker;
import pl.solsoft.calendar.views.components.SkipButton;
import pl.solsoft.calendar.views.components.ViewSwitch;

import javax.swing.*;

public class MenuPanel extends JPanel {
    private DatePicker datePicker = new DatePicker();
    private SkipButton skipButtonBackward = new SkipButton(ButtonType.BACKWARD);
    private SkipButton skipButtonForward = new SkipButton(ButtonType.FORWARD);

    public MenuPanel() {
        this.add(skipButtonBackward);
        this.add(datePicker);
        this.add(skipButtonForward);

        JComboBox<ViewType> viewSwitch = new ViewSwitch();
        this.add(viewSwitch);
    }
}
