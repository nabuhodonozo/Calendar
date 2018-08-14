package pl.solsoft.calendar.views.components;


import pl.solsoft.calendar.controllers.Controller;
import pl.solsoft.notes.controller.NoteController;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.LocalDate;

public class DayTextField extends javax.swing.JTextField {
    public DayTextField() {
        setColumns(10);
        setHorizontalAlignment(javax.swing.JTextField.CENTER);
        setEditable(false);
        setHighlighter(null);

        addMouseListener();
    }

    private void noteEvent() {
        NoteController.getInstance().showNotesEvent(getText());
    }

    private void addMouseListener() {
        addMouseListener(new MouseListener() {
            @Override
            public void mousePressed(MouseEvent mouseEvent) {
                if (mouseEvent.getButton() == MouseEvent.BUTTON1) {
                    Controller.getInstance().updateDateDisplayComponents(LocalDate.parse(getText()));
                } else if (mouseEvent.getButton() == MouseEvent.BUTTON3) {
                    noteEvent();
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

            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
            }

        });
    }
}
