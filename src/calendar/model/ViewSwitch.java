package calendar.model;

import calendar.Enum.Views;
import calendar.controllers.Controller;
import com.intellij.openapi.ui.ComboBox;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewSwitch extends ComboBox {
    public ViewSwitch(){
        super();

        this.setModel(new DefaultComboBoxModel<>(Views.values()));

        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Controller.getInstance().updateViewDisplayComponents(getSelectedItem());
            }
        });
    }

    public ViewSwitch(String[] stringArray){
        super(stringArray);
    }
}
