package notes.views.panel;

import notes.views.component.NoteTextField;

import javax.swing.*;
import java.awt.*;
import java.util.List;


public class NotesDisplay extends JPanel {
    private GridLayout gridLayout = new GridLayout();

    public NotesDisplay() {
        setLayout(gridLayout);
    }

    public void onNoteAdded(List<String> noteList) {
        removeAll();
        revalidate();

        int dimensionParameter = (int) Math.sqrt(noteList.size()) + 1;

        gridLayout.setColumns(dimensionParameter);
        gridLayout.setRows(dimensionParameter);

        for (String string : noteList) {
            NoteTextField noteTextField = new NoteTextField(string);
            add(noteTextField);
        }
    }
}