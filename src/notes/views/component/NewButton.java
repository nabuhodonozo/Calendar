package notes.views.component;

import notes.controller.NoteController;

import javax.swing.*;

public class NewButton extends JButton {
    public NewButton() {
        setText("New");

        addActionListener(actionEvent -> NoteController.getInstance().newNote());
    }
}
