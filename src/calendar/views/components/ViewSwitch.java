package calendar.views.components;

import calendar.controllers.Controller;
import calendar.views.ViewType;
import com.intellij.openapi.ui.ComboBox;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewSwitch extends ComboBox {
    public ViewSwitch(){
        super();

        this.setModel(new DefaultComboBoxModel<>(ViewType.values()));

        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Controller.getInstance().updateViewDisplayComponents((ViewType) getSelectedItem());
            }
        });
    }

    public ViewSwitch(String[] stringArray){
        super(stringArray);
    }
}
