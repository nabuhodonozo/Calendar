package pl.solsoft.notes.views.component;

import pl.solsoft.notes.services.NotesService;

import javax.swing.*;

public class SaveButton extends JButton {
    public SaveButton() {
        setText("Save");

        addActionListener(actionListener -> NotesService.getInstance().saveNote());
    }
}
