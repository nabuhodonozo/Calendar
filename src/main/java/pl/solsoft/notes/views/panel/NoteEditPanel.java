package pl.solsoft.notes.views.panel;

import pl.solsoft.notes.model.Note;

import javax.swing.*;

public class NoteEditPanel extends JTextPane {
    private Note note;

    public Note getNote() {
        return note;
    }

    public void setNote(Note note) {
        this.note = note;
        this.setText(note.getText());
    }
}
