package calendar.model;

import javax.swing.*;

public class MenuPanel extends JPanel {
    public MenuPanel() {
        this.add(new SkipButton(SkipButton.skipDirection.BACKWARD));
        this.add(DatePicker.getInstance());
        this.add(new SkipButton(SkipButton.skipDirection.FORWARD));

        JComboBox<Views> viewSwitch = new ViewSwitch();


        this.add(viewSwitch);
    }
}
