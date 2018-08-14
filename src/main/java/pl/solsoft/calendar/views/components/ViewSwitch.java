package pl.solsoft.calendar.views.components;

import pl.solsoft.calendar.controllers.Controller;
import pl.solsoft.calendar.views.ViewType;

import javax.swing.*;

public class ViewSwitch extends JComboBox {
    public ViewSwitch() {
        super();

        this.setModel(new DefaultComboBoxModel<>(ViewType.values()));

        this.addActionListener(e -> Controller.getInstance().updateViewDisplayComponents((ViewType) getSelectedItem()));
    }

    public ViewSwitch(String[] stringArray) {
        super(stringArray);
    }
}
