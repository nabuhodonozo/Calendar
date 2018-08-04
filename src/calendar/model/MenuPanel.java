package calendar.model;

import javax.swing.*;

public class MenuPanel extends JPanel {
    public MenuPanel() {
        this.add(new SkipButton("previous"));
        this.add(DatePicker.getInstance());
        this.add(new SkipButton("next"));

        String[] views = new String[] {"Week", "Month"};

        JComboBox<String> viewSwitch = new ViewSwitch(views);

        String selectedView = (String) viewSwitch.getSelectedItem();

        this.add(viewSwitch);
    }
}
