package calendar.views.panels;

import calendar.views.ButtonType;
import calendar.views.ViewType;
import calendar.views.components.DatePicker;
import calendar.views.components.SkipButton;
import calendar.views.components.ViewSwitch;

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
