package calendar.views.components;


import calendar.controllers.Controller;
import calendar.controllers.NoteController;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.LocalDate;

public class JTextField extends javax.swing.JTextField {
    public JTextField() {
        setColumns(10);
        setHorizontalAlignment(javax.swing.JTextField.CENTER);
        setEditable(false);

        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {

            }

            @Override
            public void mousePressed(MouseEvent mouseEvent) {
                if (mouseEvent.getButton() == 1) {
                    Controller.getInstance().updateDateDisplayComponents(LocalDate.parse(getText()));
                } else if (mouseEvent.getButton() == 3) {
                    //wyswietl jakis nowy jframe ale to musi byc odelegowane gdzies indziej
                    NoteController.getInstance().createNote();
                }


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
