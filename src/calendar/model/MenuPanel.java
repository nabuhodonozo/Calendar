package calendar.model;

import javax.swing.*;

public class MenuPanel extends JPanel {
    public MenuPanel() {
        this.add(new SkipButton("previous"));
        this.add(DatePicker.getInstance());
        this.add(new SkipButton("next"));

        JComboBox<Views> viewSwitch = new ViewSwitch();


        this.add(viewSwitch);
    }
}
