package pl.solsoft.notes.views.component;

import pl.solsoft.notes.controller.NoteController;

import javax.swing.*;

public class NewButton extends JButton {
    public NewButton() {
        setText("New");

        addActionListener(actionEvent -> NoteController.getInstance().newNote());
    }
}
