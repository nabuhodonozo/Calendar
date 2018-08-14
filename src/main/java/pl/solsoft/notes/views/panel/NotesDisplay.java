package pl.solsoft.notes.views.panel;

import pl.solsoft.notes.model.Note;
import pl.solsoft.notes.views.component.NoteTextField;

import javax.swing.*;
import java.awt.*;
import java.util.List;


public class NotesDisplay extends JPanel {
    private GridLayout gridLayout = new GridLayout();

    public NotesDisplay() {
        setLayout(gridLayout);
    }

    public void onNoteAdded(List<Note> noteList) {
        removeAll();
        revalidate();
        repaint();

        int dimensionParameter = (int) Math.sqrt(noteList.size()) + 1;

        gridLayout.setColumns(dimensionParameter);
        gridLayout.setRows(dimensionParameter);

        for (Note note : noteList) {
            NoteTextField noteTextField = new NoteTextField(note);
            add(noteTextField);
        }
    }
}