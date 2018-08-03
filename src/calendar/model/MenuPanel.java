package calendar.model;

import org.jdesktop.swingx.JXDatePicker;

import javax.swing.*;
import java.util.Date;

public class MenuPanel extends JPanel {
    public MenuPanel() {
        this.add(new SkipButton("previous"));
        this.add(new DatePicker());
        this.add(new SkipButton("next"));

        String[] views = new String[] {"Week", "Month"};

        JComboBox<String> viewSwitch = new ViewSwitch(views);

        String selectedView = (String) viewSwitch.getSelectedItem();

        this.add(viewSwitch);
    }
}
