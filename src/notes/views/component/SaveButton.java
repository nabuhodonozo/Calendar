package notes.views.component;

import notes.controller.NoteController;

import javax.swing.*;

public class SaveButton extends JButton {
    public SaveButton() {
        setText("Save");

        addActionListener(actionListener -> NoteController.getInstance().saveNote());
    }
}
