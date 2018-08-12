package notes.views.component;

import notes.controller.NoteController;
import notes.model.Note;

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
                NoteController.getInstance().editNote(note);
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
