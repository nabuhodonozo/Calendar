package calendar.views.components;


import calendar.controllers.Controller;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.LocalDate;

public class TextFieldComp extends JTextField {
    public TextFieldComp() {
        setColumns(10);
        setHorizontalAlignment(JTextField.CENTER);
        setEditable(false);

        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {

            }

            @Override
            public void mousePressed(MouseEvent mouseEvent) {
                Controller.getInstance().updateDateDisplayComponents(LocalDate.parse(getText()));
            }

            @Override
            public void mouseReleased(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseEntered(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseExited(MouseEvent mouseEvent) {

            }
        });
    }
}
