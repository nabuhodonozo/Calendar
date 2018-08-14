package pl.solsoft.notes.views.component;

import pl.solsoft.notes.model.Note;
import pl.solsoft.notes.services.NotesService;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class NoteTextField extends javax.swing.JTextField {
    public NoteTextField(Note note) {
        setText(note.getText());
        setHorizontalAlignment(javax.swing.JTextField.CENTER);
        setEditable(false);
        setHighlighter(null);

        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                NotesService.getInstance().editNote(note);
            }

            @Override
            public void mousePressed(MouseEvent mouseEvent) {
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
        });

    }
}
