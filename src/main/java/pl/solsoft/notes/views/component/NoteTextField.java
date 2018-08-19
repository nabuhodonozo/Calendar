package pl.solsoft.notes.views.component;

import pl.solsoft.notes.services.NotesService;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class NoteTextField extends javax.swing.JTextField {
    public NoteTextField(int noteID) {
        setHorizontalAlignment(javax.swing.JTextField.CENTER);
        setEditable(false);
        setHighlighter(null);

        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                if (mouseEvent.getButton() == MouseEvent.BUTTON1) {
                    NotesService.getInstance().editNoteEvent(noteID);
                } else if (mouseEvent.getButton() == MouseEvent.BUTTON3) {
                    NotesService.getInstance().removeNote(noteID);
                }
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
