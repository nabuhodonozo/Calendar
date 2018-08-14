package pl.solsoft.notes.views.component;

import pl.solsoft.notes.controller.NoteController;

import javax.swing.*;

public class SaveButton extends JButton {
    public SaveButton() {
        setText("Save");

        addActionListener(actionListener -> NoteController.getInstance().saveNote());
    }
}
