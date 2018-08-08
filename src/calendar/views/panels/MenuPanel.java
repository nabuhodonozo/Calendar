package calendar.views.panels;

import calendar.views.ViewSwitch;
import calendar.views.Views;
import calendar.views.components.DatePicker;
import calendar.views.components.SkipButton;

import javax.swing.*;

public class MenuPanel extends JPanel {
    private DatePicker datePicker = new DatePicker();
    private SkipButton skipButtonBackward = new SkipButton(datePicker, SkipButton.skipDirection.BACKWARD);
    private SkipButton skipButtonForward = new SkipButton(datePicker, SkipButton.skipDirection.FORWARD);

    public MenuPanel() {
        this.add(skipButtonBackward);
        this.add(datePicker);
        this.add(skipButtonForward);

        JComboBox<Views> viewSwitch = new ViewSwitch();
        this.add(viewSwitch);
    }
}
