package pl.solsoft.notes.views.component;

import pl.solsoft.notes.services.NotesService;

import javax.swing.*;

public class NewButton extends JButton {
    public NewButton() {
        setText("New");

        addActionListener(actionEvent -> NotesService.getInstance().newNote());
    }
}
