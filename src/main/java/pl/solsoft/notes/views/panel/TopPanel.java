package pl.solsoft.notes.views.panel;

import javax.swing.*;
import java.awt.*;

public class TopPanel extends JPanel {
    private CardLayout cardLayout = new CardLayout();
    private NotesDisplay notesDisplay = new NotesDisplay();
    private NoteEdit noteEdit = new NoteEdit();

    public TopPanel() {
        setLayout(cardLayout);
        add(notesDisplay, notesDisplay.getClass().getSimpleName());
        add(noteEdit, noteEdit.getClass().getSimpleName());
    }

    public CardLayout getCardLayout() {
        return cardLayout;
    }

    public NoteEdit getNoteEdit() {
        return noteEdit;
    }

    public NotesDisplay getNotesDisplay() {
        return notesDisplay;
    }
}
